package task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class HttpUtility {

	/**
	 * Method for saving specified picture from client
	 * 
	 * @param client
	 *            - connected client
	 * @param picture
	 *            - specified picture for save
	 * @throws IOException
	 */
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

	/**
	 * Method for upload picture to http server
	 * 
	 * @param client
	 *            - connected client
	 * @param picture
	 *            - picture for upload
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static void photoUploader(Socket client, File picture)
			throws IOException {

		FileInputStream reader = new FileInputStream(
				new File(picture.getName()));
		OutputStream writer = client.getOutputStream();

		byte[] bufferPicture = new byte[1024];
		int readBytesPicture;
		while ((readBytesPicture = reader.read(bufferPicture, 0, 1024)) > 0) {
			writer.write(bufferPicture, 0, readBytesPicture);
		}
		System.out.println("File sent");
		writer.flush();
		client.close();
	}

	public static void httpServer(Socket httpClient, File picture)
			throws IOException {

		BufferedWriter clientWriter = new BufferedWriter(
				new OutputStreamWriter(httpClient.getOutputStream()));
		BufferedReader clientReader = new BufferedReader(new InputStreamReader(
				httpClient.getInputStream()));

		BufferedReader fileReader = null;
		String htmlDoc = "";

		String fromClient = clientReader.readLine();
		String address = "example.html";
		String[] wantedAddress = fromClient.split(" ");

		if (wantedAddress[1].equals("/" + picture.getName())) {

			address = "/" + picture.getName();
		}

		if (address.equals("example.html")) {

			fileReader = new BufferedReader(new FileReader(new File(address)));
			while (fileReader.ready()) {
				htmlDoc += fileReader.readLine();
			}

			htmlDoc += "Picture link: " + "<a href =" + picture.getName() + ">"
					+ picture.getName() + "</a> " + "<br>\n";

			htmlDoc += "</p></body></html>";
			clientWriter.write(htmlDoc);
			clientWriter.flush();
			fileReader.close();

		} else {

			photoUploader(httpClient, picture);
		}

	}
}
