import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DistributeFile extends JFrame {

	private static final long serialVersionUID = 3473078609897498555L;

	private String line;
	private FileBrowser browser = new FileBrowser();
	private DeleteUtility remove = new DeleteUtility();

	public DistributeFile() {

		// Set border layout of main window
		setLayout(new BorderLayout());

		// Declaration of panels, buttons and text area
		JPanel info = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton open = new JButton("File Browser...");
		JButton delete = new JButton("Delete");
		JTextArea fileInfo = new JTextArea();

		// Method for upload file name info from file
		setFileInfo(fileInfo);

		// Set text area editable and add sliders to area
		fileInfo.setEditable(false);
		JScrollPane scroll = new JScrollPane(fileInfo);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Set title of buttons panel
		buttons.setBorder(BorderFactory.createTitledBorder("Options"));
		// Adding buttons open and delete to panel buttons
		buttons.add(open);
		buttons.add(delete);

		// Set title of info panel
		info.setBorder(BorderFactory.createTitledBorder("The existing file: "));
		// Adding text area with slider to panel info
		info.add(scroll);

		// Adding panels info and buttons to main window
		add(info);
		add(buttons, BorderLayout.SOUTH);

		// Add action listener with anonymous class for open button
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				browser.openBrowse(fileInfo);
				browser.getFileInfo();
			}
		});

		// Add action listener with anonymous class for delete specified file
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				remove.browserForDelete(fileInfo);

			}
		});

		// Set some of option for frame
		setVisible(true);
		setSize(400, 500);
		setTitle("DISTRIBUTE FILE");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * Method for set area text from file
	 * 
	 * @param fileInfo
	 *            - text area where set text from file
	 */
	public void setFileInfo(JTextArea fileInfo) {

		setSortedText();
		try {
			@SuppressWarnings("resource")
			BufferedReader bf = new BufferedReader(new FileReader("info.txt"));

			String areaLine = fileInfo.getText();
			while (bf.ready()) {

				line += bf.readLine() + "\n";
				fileInfo.setText(areaLine + line);
				fileInfo.setFont(new Font("Serif", Font.BOLD, 15));

			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

		}
	}

	/**
	 * Method for editing text in file, sort and write to area, using Tree set
	 */
	public void setSortedText() {

		TreeSet<String> arr = browser.getFileInfo();
		FileWriter writer;
		try {
			writer = new FileWriter("info.txt");
			for (String str : arr) {
				writer.write(str + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
