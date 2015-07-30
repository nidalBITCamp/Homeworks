import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class present assist class for distribute file with specified method
 * utility
 * 
 * @author Niddal.salkic
 */
public class FileBrowser extends JFrame {

	private String path = "";

	private static final long serialVersionUID = -2270443679271766234L;

	/**
	 * Method which of input file get extension and set file for add to
	 * specified directory
	 * 
	 * @param file
	 *            - file
	 */
	public void fileForDistribut(File file, JTextArea fileInfo) {

		path = enterDirectorypath();
		System.out.println(path);
		try {
			String check = FileUtility.getFileExtension(file);

			if (check.equals(".txt") || check.equals(".doc")
					|| check.equals(".xlsx")) {

				File dir = new File(path + "/Documents");

				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileUtility.moveSelectedFile(dir, file);
				try {
					FileUtility.writeToFile("Documents: " + file.getName());
					fileInfo.setText(fileInfo.getText() + "Documents: "
							+ file.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (check.equals(".mp4") || check.equals(".avi")
					|| check.equals(".mkv")) {

				File dir = new File(path + "/Video");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileUtility.moveSelectedFile(dir, file);
				try {
					FileUtility.writeToFile("Video: " + file.getName());
					fileInfo.setText(fileInfo.getText() + "Video: "
							+ file.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else if (check.equals(".mp3") || check.equals(".flac")
					|| check.equals(".wmv")) {

				File dir = new File(path + "/Audio");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileUtility.moveSelectedFile(dir, file);
				try {
					FileUtility.writeToFile("Audio: " + file.getName());
					fileInfo.setText(fileInfo.getText() + "Audio: "
							+ file.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (check.equals(".png") || check.equals(".jpg")
					|| check.equals(".bmp")) {

				File dir = new File(path + "/Pictures");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				FileUtility.moveSelectedFile(dir, file);
				try {
					FileUtility.writeToFile("Pictures: " + file.getName());
					fileInfo.setText(fileInfo.getText() + "Pictures: "
							+ file.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (check.equals(".del")) {

				File dir = new File(path + "/Trash");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				FileUtility.moveSelectedFile(dir, file);
				String name = removeExtension(file);
				FileUtility.writeToFile("Deleted: " + name);
				fileInfo.setText(fileInfo.getText() + "Deleted: " + name + "\n");

			}

			else {

				File dir = new File(path + "/Other");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				FileUtility.moveSelectedFile(dir, file);
				try {
					FileUtility.writeToFile("Other: " + file.getName());
					fileInfo.setText(fileInfo.getText() + "Other: "
							+ file.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (NullPointerException e) {

			System.out.println("Error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method for open show input dialog and get the entered path for new
	 * directory
	 * 
	 * @return - String path
	 */
	public String enterDirectorypath() {

		String message = JOptionPane.showInputDialog(null,
				"Enter the path where you want made new directory");

		return message;

	}

	/**
	 * MEthod for remove extension of file
	 * 
	 * @param file
	 *            - File file
	 * @return - file name without extension
	 */
	public String removeExtension(File file) {

		String temp = file.getName();

		int pos = temp.lastIndexOf(".");
		return temp.substring(0, pos);

	}

	/**
	 * MEthod for show open dialog for selection of files
	 */
	public void openBrowse(JTextArea fileInfo) {

		File file = null;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e2) {

			e2.printStackTrace();
		}
		JFileChooser jfc = new JFileChooser(System.getProperty("user/desktop"));

		int tmp = jfc.showOpenDialog(null);

		if (tmp == JFileChooser.APPROVE_OPTION) {

			file = jfc.getSelectedFile();

		}
		if (tmp == JFileChooser.CANCEL_OPTION) {

			doLayout();
		}

		fileForDistribut(file, fileInfo);

	}

	/**
	 * Method for add to Tree set list content of text area
	 * 
	 * @return - String Tree set List 
	 */
	public TreeSet<String> getFileInfo() {
		TreeSet<String> list = new TreeSet<String>();
		Scanner s;
		try {
			s = new Scanner(new File("info.txt"));

			while (s.hasNextLine()) {

				list.add(s.nextLine());

			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
