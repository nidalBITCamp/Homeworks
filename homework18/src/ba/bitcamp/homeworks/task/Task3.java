package ba.bitcamp.homeworks.task;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class present a program that gives the user the ability to log in.Two
 * information should be entered , the username and password . The correct
 * combination is " Mujo " and the password " 1234" .
 * 
 * @author Niddal
 *
 */
public class Task3 extends JFrame {

	private static final long serialVersionUID = -6113314470529613237L;

	// Add text and password field
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();

	// Add labels and panel
	JLabel text1 = new JLabel("Enter Username");
	JLabel text2 = new JLabel(" Entter Password");
	JPanel window = new JPanel(new GridLayout(2, 4, 0, 2));

	public Task3() {

		// Set title
		username.setBorder(BorderFactory.createTitledBorder("Username"));
		password.setBorder(BorderFactory.createTitledBorder("Pasword"));

		// Add labels text1, text2, text field and password field in panel
		// window
		window.add(text1);
		window.add(username);
		window.add(text2);
		window.add(password);

		// Add action listener to password field
		password.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String s = String.valueOf(password.getPassword());
				String n = username.getText();

				if (n.equals("Mujo") && s.equals("1234")) {
					System.exit(3);
				} else {
					JOptionPane.showMessageDialog(null,
							"Wrong ussername or pasword");
				}

			}
		});

		// Attributes of frame, size, title, and location
		add(window);
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Task3();
	}

}