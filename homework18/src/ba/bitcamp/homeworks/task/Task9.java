package ba.bitcamp.homeworks.task;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * This class present a program where the user has the option to enter a
 * location for the file to be read .
 * 
 * @author Niddal
 *
 */
public class Task9 extends JFrame {

	private static final long serialVersionUID = 1844001882749346198L;

	private JTextField name = new JTextField();
	private JTextArea info = new JTextArea();
	private JScrollPane scroll = new JScrollPane(info);

	public Task9() {

		// Set the title
		name.setBorder(BorderFactory
				.createTitledBorder(" Input field for location of file"));
		info.setBorder(BorderFactory
				.createTitledBorder(" The content of the text"));

		// Set the text area disable
		info.setEditable(false);

		setLayout(new BorderLayout());

		add(name, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		// Add scroll to text area
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Add key listener on the text field
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					try {

						TextIO.readFile(name.getText());
						String text = "";
						while (!TextIO.eof()) {
							text += TextIO.getln() + "\n";
						}
						info.setText(text);

					} catch (IllegalArgumentException g) {

						JOptionPane.showMessageDialog(null,
								"Can not find the text");
					}

				}
			}
		});

		// Attributes of frame, size, title, and location
		setSize(600, 600);
		setTitle("Import text file");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task9();
	}
}