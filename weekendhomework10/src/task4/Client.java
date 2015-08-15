package task4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {

			Socket client = new Socket("localhost", 1234);

			@SuppressWarnings("resource")
			FileInputStream reader = new FileInputStream(
					new File("picture.jpg"));
			OutputStream writer = client.getOutputStream();

			byte[] buffer = new byte[1024];
			int readBytes;

			while ((readBytes = reader.read(buffer, 0, 1024)) > 0) {
				writer.write(buffer, 0, readBytes);
			}

			writer.close();
			client.close();
		} catch (IOException e) {
			
			System.out.println("Failed or interrupted I/O operations");
			e.printStackTrace();
		}

	}

}
