package ba.bitcamp.homework.networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 * This class present local server which get inputed link and name of link from
 * connected server, then check is link valid, and write valid link in the file
 * 
 * @author Niddal
 *
 */
public class Server {

	static final int PORT = 3333;

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

				System.out.println(getLink(line));
				System.out.println(getLinkName(line));

				File file = new File("info.txt");
				if (!file.exists()) {
					file.createNewFile();
				}

				String link = getLink(line);
				// System.out.println(getResponseCode(link));
				System.out.println(isValid(link));
				@SuppressWarnings("resource")
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,
						true));
				if (isValid(link)) {

					writer.write(line);
					writer.newLine();
					writer.flush();
					line = " ";

				} else {
					line = " ";
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Method for get link name
	 * 
	 * @param line
	 *            - String of link name and link address
	 * @return - String of link name
	 */
	public static String getLinkName(String line) {

		return line.substring(line.indexOf(" ") + 1, line.length());

	}

	/**
	 * Method for get link address
	 * 
	 * @param line
	 *            - String of link name and link address
	 * @return - String of link address
	 */
	public static String getLink(String line) {

		String link = "";
		try {
			link = line.substring(0, line.indexOf(" "));
		} catch (StringIndexOutOfBoundsException e) {

		}
		return link;

	}

	/**
	 * Method for get response cod when url connect
	 */
	public static int getResponseCode(String url) throws MalformedURLException,
			IOException {

		URL link = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection) link.openConnection();
		urlConn.setRequestMethod("GET");
		urlConn.connect();
		return urlConn.getResponseCode();
	}

	/**
	 * Method for checking is inputed link is valid and exists
	 * 
	 * @param url
	 *            - String of link
	 * @return- True if is valid
	 */
	public static boolean isValid(String url) {

		try {
			return (getResponseCode(url) == 200);
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}
}
