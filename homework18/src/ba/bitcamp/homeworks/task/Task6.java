package ba.bitcamp.homeworks.task;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * This class present a program where the user enters the value of time in
 * seconds . Then the user will press button to start the countdown .
 * 
 * @author Niddal
 *
 */
public class Task6 extends JFrame {

	private static final long serialVersionUID = 7340183130572100017L;

	int tmp;

	// Declaration new panel, label, button, text field and timer
	JPanel window = new JPanel(new GridLayout(4, 4, 1, 1));
	JLabel info = new JLabel();
	JButton button = new JButton(" START ");
	JTextField number = new JTextField();
	Timer start = new Timer(1000, new Action());

	
	public Task6() {

		//Set title
		number.setBorder(BorderFactory.createTitledBorder(" Input field"));
		info.setBorder(BorderFactory.createTitledBorder("Countdown"));

		info.setHorizontalAlignment(JLabel.CENTER);

		// Add label, text field and button to panel window
		window.add(info);
		window.add(number);
		window.add(button);

		// Set action listener to button
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tmp = Integer.parseInt(number.getText());
				} catch (NumberFormatException t) {
					JOptionPane.showMessageDialog(null, " Wrong input ");
				}
				start.start();
			}
		});

		// Add panel window to frame
		add(window);

		// Attributes of frame, size, title, and location
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * This class used for set action listener on the button
	 * 
	 * @author Niddal
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tmp >= 0)
				info.setText(String.valueOf(tmp));
			tmp--;
		}

	}

	public static void main(String[] args) {

		new Task6();
	}

}