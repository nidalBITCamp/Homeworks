import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class present specified method for file
 * 
 * @author Niddal.Salkic
 *
 */
public class FileUtility {

	/**
	 * Method for get extension of input file
	 * 
	 * @param file
	 *            - file which extension get
	 * @return - extension of file
	 */
	public static String getFileExtension(File file) {

		try {

			String name = file.getName();
			try {
				return name.substring(name.lastIndexOf("."), name.length());
			} catch (StringIndexOutOfBoundsException e) {

				System.out.println("Error");
			}
		} catch (NullPointerException e) {

			System.out.println("Error");

		}
		return "";
	}

	/**
	 * Method for add selected file to order directory
	 * 
	 * @param directory
	 *            - directory for input
	 * @param file
	 *            - file for add to directory
	 */
	public static void moveSelectedFile(File directory, File file) {

		String fileName = file.getName();
		File tagFile = new File(directory, fileName);
		if (!tagFile.exists()) {
			try {

				tagFile.createNewFile();

				System.out.println(tagFile.getName());

				String path = directory.getAbsolutePath() + "\\" + fileName;
				path = path.replace("\\", "/");
				String oldFile = getAddressSelectedFile(file);
				System.out.println(path);
				System.out.println(oldFile);

				copyContent(oldFile, path);

			} catch (FileNotFoundException e) {
				System.err.println("File not found. Please scan in new file.");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method for get address of inputed file
	 * 
	 * @param file
	 *            - inputed file
	 * @return - string path od inputed file
	 */
	public static String getAddressSelectedFile(File file) {

		String oldFile = file.getAbsolutePath();
		oldFile = oldFile.replace("\\", "/");

		return oldFile;

	}

	/**
	 * Method for write name of selected file to file info.txt
	 * 
	 * @param temp
	 *            - String name of file
	 * @throws IOException
	 */
	public static void writeToFile(String temp) throws IOException {

		BufferedWriter output = null;
		try {
			File file = new File("info.txt");
			output = new BufferedWriter(new FileWriter(file, true));

			output.write(temp);
			output.newLine();
			output.flush();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	/**
	 * MEthod for copy contents of file to new file
	 * 
	 * @param path
	 *            -String address of old file
	 * @param addres
	 *            - String address of new file
	 */
	public static void copyContent(String path, String addres) {

		InputStream in = null;
		OutputStream out = null;

		try {
			File oldFile = new File(path);
			File newFile = new File(addres);

			byte[] moveBuff = new byte[1024];
			try {
				in = new FileInputStream(oldFile);
				out = new FileOutputStream(newFile);
			} catch (FileNotFoundException e) {

				System.out.println("");
			}
			int butesRead;

			while ((butesRead = in.read(moveBuff)) > 0) {

				out.write(moveBuff, 0, butesRead);
				out.flush();

			}

			in.close();
			out.close();

			// oldFile.delete();

			System.out
					.println("The File was successfully moved to the new folder");

		} catch (FileNotFoundException e) {
			System.out.println("123");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
