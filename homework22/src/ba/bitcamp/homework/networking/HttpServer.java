package ba.bitcamp.homework.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class present http server connected to http port
 * 
 * @author Niddal
 *
 */
public class HttpServer {

	private static final int HTTP_PORT = 3636;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ServerSocket http;
		try {
			http = new ServerSocket(HTTP_PORT);
			System.out.println("Server is made");

			while (true) {
				Socket client = http.accept();
				System.out.println("Client: "
						+ client.getLocalAddress());
				BufferedWriter clientWriter = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				BufferedReader clientReader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				BufferedReader fileReader = null;
				String htmlDoc = "";
				boolean printIps = true;
				try {
					String fromClient = clientReader.readLine();
					String[] wantedAddress = fromClient.split(" ");

					String address = "src/example.html";

					if (wantedAddress[1].equals("/about.html")
							|| wantedAddress[1].equals("/other")) {
						address = "src/other.html";
						printIps = false;
					}

					fileReader = new BufferedReader(new FileReader(new File(
						address)));

				} catch (NullPointerException ex) {
					continue;
				}
				while (fileReader.ready()) {
					htmlDoc += fileReader.readLine();
				}

				BufferedReader fileRead = new BufferedReader(new FileReader(
						"info.txt"));
				if (printIps) {
					while (fileRead.ready()) {
						String line = fileRead.readLine();
						String[] s = line.split(" ");
						htmlDoc += "\n<a href=" + s[0] + " target="+ "_blank >" + s[0] +"</a>"
								
								+ "<br>\n";
					}
				}
				fileRead.close();

				htmlDoc += "</p></body></html>";
				clientWriter.write(htmlDoc);
				clientWriter.close();
				client.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
