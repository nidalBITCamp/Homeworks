package task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpUtility {

	public static void savePicture(Socket client, File picture)
			throws IOException {
		InputStream sReader = client.getInputStream();

		FileOutputStream sWriter = new FileOutputStream(picture);

		byte[] buffer = new byte[1024];
		int readBytes;
		while ((readBytes = sReader.read(buffer, 0, 1024)) > 0) {
			sWriter.write(buffer, 0, readBytes);
		}
		System.out.println("File recieved, and saved as: " + picture.getName());
		sWriter.close();
		client.close();

	}

	public static void httpServer(Socket client, File picture)
			throws IOException {

		BufferedWriter clientWriter = new BufferedWriter(
				new OutputStreamWriter(client.getOutputStream()));
		BufferedReader clientReader = new BufferedReader(new InputStreamReader(
				client.getInputStream()));

		BufferedReader fileReader = null;
		String htmlDoc = "";
		boolean printIps = true;
		try {

			String fromClient = clientReader.readLine();
			String[] wantedAddress = fromClient.split(" ");

			String address = "example.html";

			if (wantedAddress[1].equals("/about.html")
					|| wantedAddress[1].equals("/other")) {
				address = "other.html";
			}

			fileReader = new BufferedReader(new FileReader(new File(address)));

		} catch (NullPointerException ex) {

		}

		while (fileReader.ready()) {
			htmlDoc += fileReader.readLine();
		}

		if (printIps) {

			while (fileReader.ready()) {
				htmlDoc += fileReader.readLine();
			}
			htmlDoc += "\nPicture: "
					+ "<a href ="
					+ picture.getName()
					+ ">"
					+ picture.getName()
					+ "</a> ";
					
		}

		htmlDoc += "</p></body></html>";
		clientWriter.write(htmlDoc);
		clientWriter.flush();
		fileReader.close();
		client.close();
	}
}
