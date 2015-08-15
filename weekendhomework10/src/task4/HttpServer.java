package task4;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer extends HttpUtility {

	protected static final int PORT = 1234;

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket client = null;

		try {
			System.out.println("Server started");
			server = new ServerSocket(PORT);
			client = server.accept();

			String ip = client.getInetAddress().getHostName();
			System.out.println("Client with IP: " + ip + " connected.");
			// Creating file and giving name as ip address
			File file = new File(ip + ".jpg");
			// Calling method that will download photo from client
			savePicture(client, file);

			while (true) {
				System.out.println("Waiting for client");
				Socket httpclient = server.accept();
				System.out.println("Client: " + httpclient.getLocalAddress()
						+ "is connected");
				try {
					httpServer(httpclient, file);

				} catch (NullPointerException e) {

					System.out.println("Client is disconnected");
					continue;
				}
			}
		} catch (IOException e) {
			System.out.println("Failed or interrupted I/O operations");
			e.printStackTrace();
		}
	}

}
