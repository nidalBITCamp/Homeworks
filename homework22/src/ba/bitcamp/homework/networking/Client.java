package ba.bitcamp.homework.networking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class present one client which send to server link and link name
 * 
 * @author Niddal.Salkic
 *
 */
public class Client {

	private static final int PORT = Server.PORT;

	public static void main(String[] args) {
		try {

			@SuppressWarnings("resource")
			Socket client = new Socket("localhost", PORT);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			while (true) {
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);

				System.out
						.println("Please insert the link and the name of link");
				writer.write(input.nextLine());
				writer.newLine();
				writer.flush();

			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
