import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Class for deleting selected file, which extends BrowserUtility
 * 
 * @author Niddal.Salkic
 *
 */
public class DeleteUtility extends FileBrowser {

	private static final long serialVersionUID = -5940545406863303744L;

	public void browserForDelete(JTextArea fileInfo) {

		File file = null;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e2) {

			e2.printStackTrace();
		}
		JFileChooser jfc = new JFileChooser(System.getProperty("user/desktop"));

		int tmp = jfc.showDialog(null, "Select");

		if (tmp == JFileChooser.APPROVE_OPTION) {

			file = jfc.getSelectedFile();

		}
		if (tmp == JFileChooser.CANCEL_OPTION) {

			doLayout();
		}

		deletingFile(file, fileInfo);

	}

	/**
	 * Method for deleting file and set information on text area
	 * 
	 * @param file
	 *            - file for delete
	 */
	public void deletingFile(File file, JTextArea fileInfo) {
		String deletedFile = "";
		try {
			deletedFile = file.getPath() + ".del";
			File delFile = new File(deletedFile);

			fileForDistribut(delFile, fileInfo);
		} catch (NullPointerException e) {

		}
		// Deleting file is turn off, work like simulation of deleting
		// file.delete();

	}

}
