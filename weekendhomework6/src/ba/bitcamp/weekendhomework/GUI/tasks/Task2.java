package ba.bitcamp.weekendhomework.GUI.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4348810152502086804L;

	private String n = "First name";
	private String ln = "Last name";
	private JButton button1 = new JButton("First name");
	private JButton button2 = new JButton("Last name");
	private JLabel text = new JLabel(n + " " + ln);

	public Task2() {

		setVisible(true);
		setResizable(false);
		setLocation(350, 350);
		setSize(400, 200);

		setTitle(" Task 2 ");

		setLayout(new BorderLayout());
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		add(text, BorderLayout.CENTER);

		text.setHorizontalAlignment(NORMAL);
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button1) {

				n = new Names().toString();
				text.setText(n + " " + ln);

			} else if (e.getSource() == button2) {

				ln = new LastNames().toString();
				text.setText(n + " " + ln);
			}

		}

	}

	/**
	 * This class is inerClass for set names
	 * 
	 * @author Niddal
	 *
	 */
	static class Names {

		protected String names[] = { "Nidal", "Zaid", "Hajrudin", "Ajdin" };

		/**
		 * Method for generate random name from arrays of names
		 * 
		 * @return - one name
		 */
		public String generateName() {

			return names[(int) (Math.random() * names.length)];
		}

		@Override
		public String toString() {
			return generateName();
		}

	}

	/**
	 * This class is inerClass for set surname
	 * 
	 * @author Niddal
	 *
	 */
	static class LastNames {

		public String LastNames[] = { "Lastname 1", "Lastname2", "Lastname3",
				"Lastname4 " };

		/**
		 * Method for generate random surname from array of surname
		 * 
		 * @return one surname
		 */
		String generateSurnName() {

			return LastNames[(int) (Math.random() * LastNames.length)];
		}

		@Override
		public String toString() {
			return generateSurnName();
		}
	}

	public static void main(String[] args) {
		new Task2();
	}

}
