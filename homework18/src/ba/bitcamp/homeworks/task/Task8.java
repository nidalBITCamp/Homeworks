package ba.bitcamp.homeworks.task;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class present program where the user registers The user needs to enter
 * the username and twice should enter the password . At the bottom there are
 * two buttons , clear and submit .
 * 
 * @author Niddal
 *
 */
public class Task8 extends JFrame {

	private static final long serialVersionUID = 7502612102587957794L;

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField password1 = new JPasswordField();
	JLabel text1 = new JLabel("Enter Username");
	JLabel text2 = new JLabel(" Enter Password");
	JLabel text3 = new JLabel(" Repeat Password");
	JButton clear = new JButton(" Clear ");
	JButton submit = new JButton(" Submit ");
	JPanel window = new JPanel(new GridLayout(6, 1, 5, 5));

	public Task8() {

		window.add(text1);
		window.add(username);
		window.add(text2);
		window.add(password);
		window.add(text3);
		window.add(password1);
		window.add(clear);
		window.add(submit);

		submit.addActionListener(new Action());
		clear.addActionListener(new Action());

		// Attributes of frame, size, title, and location
		add(window);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clear) {

				clear = (JButton) clear;
				username.setText("");
				password.setText("");
				password1.setText("");

			} else if (e.getSource() == submit) {

				submit = (JButton) submit;

				String s = String.valueOf(password.getPassword());
				String s1 = String.valueOf(password1.getPassword());

				if (!s.equals(s1)) {

					JOptionPane.showMessageDialog(null,
							" Entered password is not same ");

				} else if (username.getText().length() < 6) {

					JOptionPane.showMessageDialog(null,
							" Username must be at least 6 characters");

				} else if (s.length() < 6) {

					JOptionPane.showMessageDialog(null,
							" Password must be at least 6 characters");

				} else if (checkPassword(password.getPassword()) == false) {

					JOptionPane
							.showMessageDialog(null,
									"Password must contain at least one digit and one special character");

				} else {

					JOptionPane.showMessageDialog(null,
							"You have successfully registered");

				}

			}

		}
	}

	private boolean checkPassword(char[] password) {

		for (int i = 0; i < password.length; i++) {

			if ((password[i] > 32 && password[i] < 48)
					|| (password[i] > 57 && password[i] < 65)
					&& ((password[i] > 47 && password[i] < 58))) {

				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		new Task8();
	}

}