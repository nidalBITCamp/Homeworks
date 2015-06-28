package ba.bitcamp.weekendhomework.GUI.tasks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3808415954214927694L;

	public int num;
	private String line = "";
	private String[] characters = { "A", "B", "C", "D", "E", "F", "K", "L",
			"M", "N", "U", "V", "Z" };

	private JButton button1 = new JButton(" > ");
	private JButton button2 = new JButton(" < ");
	private JButton button3 = new JButton(" Insert ");
	private JButton button4 = new JButton(" Character: ");
	private JLabel text = new JLabel("_");

	public Task4() {

		setVisible(true);
		setResizable(false);
		setLocation(350, 350);
		setSize(400, 200);

		setTitle(" Task 2 ");

		setLayout(new BorderLayout());
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.SOUTH);
		add(button4, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);

		button1.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
		button4.addActionListener(new Action());
		text.setHorizontalAlignment(NORMAL);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button1) {
				num = text.getText().indexOf("_");
				line = text.getText().substring(0, num)
						+ text.getText().substring(num + 1, num + 2)
						+ "_"
						+ text.getText().substring(num + 2,
								text.getText().length());
				text.setText(line);

			}
			if (e.getSource() == button2) {

				num = text.getText().indexOf("_");
				line = text.getText().substring(0, num - 1)
						+ "_"
						+ text.getText().substring(num - 1, num)
						+ text.getText().substring(num + 1,
								text.getText().length());
				text.setText(line);
			}
			if (e.getSource() == button4) {
				button4.setText(characters[(int) (Math.random() * characters.length)]);
			}
			if (e.getSource() == button3) {

				num = text.getText().indexOf("_");
				line = text.getText().substring(0, num)
						+ button4.getText()
						+ "_"
						+ text.getText().substring(num + 1,
								text.getText().length());
				text.setText(line);

			}

		}

	}

	public static void main(String[] args) {
		new Task4();
	}

}
