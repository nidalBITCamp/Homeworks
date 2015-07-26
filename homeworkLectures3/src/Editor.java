import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Editor extends JFrame {

	private static final long serialVersionUID = -444770814677149105L;

	/**
	 * Method for save text from text area to specified file
	 */
	public void saveAs(JTextArea area) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JFileChooser jfc = new JFileChooser(System.getProperty("user.desktop"));
		File f = null;
		int tmp = jfc.showSaveDialog(null);
		if (tmp == JFileChooser.APPROVE_OPTION) {

			f = jfc.getSelectedFile();
		}
		if (tmp == JFileChooser.CANCEL_OPTION) {

			doLayout();
		}

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

			area.write(bw);
			bw.flush();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (NullPointerException e1) {

		}

	}

	/**
	 * Method for open file and adding text to area text
	 * 
	 */
	public void OpenFile(JTextArea area) {

		String line = "";
		Font font = new Font("Serif", Font.BOLD, 15);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JFileChooser jfc = new JFileChooser(System.getProperty("user/desktop"));
		File f = null;
		int tmp = jfc.showOpenDialog(null);
		if (tmp == JFileChooser.APPROVE_OPTION) {
			f = jfc.getSelectedFile();
		}
		if (tmp == JFileChooser.CANCEL_OPTION) {

			doLayout();
		}

		try {
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new FileReader(f));

			String areaLine = area.getText();
			while (bf.ready()) {

				line += bf.readLine() + "\n";
				area.setText(areaLine + line);
				area.setFont(font);
			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		} catch (NullPointerException e1) {

		}

	}
	
	public void check(JTextArea area){
		
		int info = JOptionPane.showConfirmDialog(null,
				"Do you want to save your changes");

		if (info == JOptionPane.OK_OPTION) {

			saveAs(area);

		}
		if (info == JOptionPane.CANCEL_OPTION) {

			doLayout();
		}
		if (info == JOptionPane.NO_OPTION) {

			dispose();
		}

	}
	
	public void setFont(JTextArea area, int count , int size){
		
		if (count == 1) {
			area.setFont(new Font("Serif", Font.BOLD, size));
		} else if (count == 2) {
			area.setFont(new Font("Monospaced", Font.BOLD, size));

		} else if (count == 2) {
			area.setFont(new Font("SANS_SERIF", Font.BOLD, size));
		}

		
	}

}
