package ba.bitcamp.weekendhomework.GUI.tasks;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1802868981440306867L;

	private int counter = 0;
	private int array[] = new int[5];
	private JButton buttons[] = new JButton[10];
	
	public Task3() {

		setVisible(true);
		setResizable(false);
		setLocation(350, 50);
		setSize(600, 200);

		setTitle(" Task 3 ");

		setLayout(new GridLayout(2, 5));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			add(buttons[i]);
			buttons[i].setText("" + i);
			buttons[i].addActionListener(new Action());

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < 5; i++) {
				if (e.getSource() == buttons[i]) {
					array[counter] = Integer.parseInt(buttons[i].getText());
					counter++;
					buttons[i + 5].setEnabled(false);

					if (counter == 5) {

						JOptionPane.showMessageDialog(null,
								Arrays.toString(array));
						counter = 0;
						Task3.this.Enabled();

					}

				}
			}
			for (int i = 5; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					array[counter] = Integer.parseInt(buttons[i].getText());
					counter++;
					buttons[i - 5].setEnabled(false);

					if (counter == 5) {

						JOptionPane.showMessageDialog(null,
								Arrays.toString(array));
						counter = 0;
						Task3.this.Enabled();

					}

				}
			}

		}

	}

	public static void main(String[] args) {

		new Task3();
	}

	
	/**
	 * Method for enabled all buttons after testing
	 */
	public void Enabled() {

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(true);
		}

	}

}
