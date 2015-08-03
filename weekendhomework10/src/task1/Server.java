package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class present server which checking the inputed path for file from
 * connected client
 * 
 * @author Niddal.Salkic
 *
 */
public class Server {

	public static final int PORT = 1234;

	public static void main(String[] args) {

		String line = "";

		try {
			System.out.println("Server is made, waiting for client...");
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(PORT);
			Socket client = server.accept();
			System.out.println("Client is connected!!!");
			while (true) {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				line = reader.readLine();
				System.out.println(line);

				String test = isFileExist(line);

				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				writer.write(test);
				writer.newLine();
				writer.flush();

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/*
	 * Tests whether the file or directory denoted by this abstract pathname
	 * exists.
	 * 
	 * @param path - String path of file for check
	 * 
	 * @return "1" if and only if the file or directory denoted by this abstract
	 * pathname exists; "0" otherwise
	 */
	private static String isFileExist(String path) {

		File file = new File(path);

		if (file.exists()) {

			return "1";
		}

		return "0";
	}

}
