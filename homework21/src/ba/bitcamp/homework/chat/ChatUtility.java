package ba.bitcamp.homework.chat;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class ChatUtility {

	/**
	 * Method for get inputed command in chat
	 * 
	 * @param line
	 *            - String line of chat
	 * @return - String inputed command
	 */
	public static String getCommand(String line) {
		String command = "";
		try {
			command = line.substring(0, line.indexOf(" "));
		} catch (StringIndexOutOfBoundsException e) {

		}

		return command;
	}

	/**
	 * Method for get instruction of command
	 * 
	 * @param line
	 *            - String line of chat
	 * @return - String address
	 */
	public static String getAddress(String line) {

		return line.substring(line.indexOf(" ") + 1, line.length());
	}

	/**
	 * Method for open entered URL
	 * 
	 * @param address
	 *            - address of URL
	 */
	public static String openURL(String address) {

		try {
			Desktop desktop = Desktop.getDesktop();
			URI oURL = new URI("http://" + address);
			desktop.browse(oURL);
			return address + " is opened";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	/**
	 * Method for open specified file in computer
	 * 
	 * @param address
	 *            - address of file
	 */
	public static String openFile(String address) {

		File file = new File(address);

		Desktop desktop = Desktop.getDesktop();
		if (file.exists()) {
			try {
				desktop.open(file);
				return "File " + address + " is opened";
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return "File dont exist";

	}

	/**
	 * Method for delete file
	 * 
	 * @param address
	 *            - address of file
	 */
	public static String deleteFile(String address) {

		File file = new File(address);

		if (file.exists()) {

			file.delete();
			return "File " + address + " is deleted";
		}

		return "File dont exist";
	}

	/**
	 * Method for list of files which contains directory
	 * 
	 * @param address
	 *            - address of directory
	 */
	public static String listDirectory(String address) {
		String path = "";
		File directory = new File(address);
		File[] contents = directory.listFiles();
		for (File f : contents) {
			path += (f.getAbsolutePath() + "\n");
		}

		return path;
	}

	/**
	 * Method for some of function in chat
	 * 
	 * @param line
	 *            - inputed line in chat
	 */
	public static String function(String line) {

		
		String command = getCommand(line);
		String address = getAddress(line);

		if (command.equals("/web")) {

			openURL(address);
			return line;
		} else if (command.equals("/open")) {

			return openFile(address);

		} else if (command.equals("/delete")) {

			return deleteFile(address);
		}

		else if (command.equals("/list")) {

			return listDirectory(address);
		}

		return line;
	}

}
