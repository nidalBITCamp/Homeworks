package ba.bitcamp.homeworks.task;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class present a program that has two check boxes that represent whether
 * the font is bold and whether the font is italic, includes a button that
 * updates the ( refresh ) the selected option on some text displayed above the
 * check boxes
 * 
 * @author Niddal
 *
 */
public class Task2 extends JFrame {

	private static final long serialVersionUID = -1485893100201245773L;

	// Add new check box to frame
	JCheckBox box1 = new JCheckBox(" Bold ");
	JCheckBox box2 = new JCheckBox(" Italic");

	// Add button to frame
	JButton button = new JButton(" Apply ");

	// Add new panel and new label
	JPanel window = new JPanel(new GridLayout(4, 1, 0, 0));
	JLabel text = new JLabel("Example font");
	Font f = new Font("Serif", Font.PLAIN, 25);

	public Task2() {

		// Set the title
		text.setBorder(BorderFactory.createTitledBorder("Label 1"));
		window.setBorder(BorderFactory.createTitledBorder("Window "));

		// Add the label text, check box 1, check box 2 and button to panel
		// window
		text.setHorizontalAlignment(JLabel.CENTER);
		window.add(text);
		window.add(box1);
		window.add(box2);
		window.add(button);

		// Add panel window to frame
		add(window);

		// Add action listener like anonymous class to button for set font
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (box1.isSelected() == true && box2.isSelected() == true) {
					text.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 25));
				} else if (box2.isSelected() == true) {
					text.setFont(new Font("Serif", Font.ITALIC, 25));
				} else if (box1.isSelected() == true) {
					text.setFont(new Font("Serif", Font.BOLD, 25));
				} else {
					text.setFont(f);
				}

			}
		});

		// Attributes of frame, size, title, and location
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		new Task2();

	}

}