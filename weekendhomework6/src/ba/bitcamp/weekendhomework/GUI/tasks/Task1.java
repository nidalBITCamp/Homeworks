package ba.bitcamp.weekendhomework.GUI.tasks;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488387908852918696L;

	private int counter = 0;
	private String line = "Number: ";
	protected JButton buttons[] = new JButton[10];

	public Task1() {

		setVisible(true);
		setResizable(false);
		setLocation(350,50);
		setSize(200, 600);
		
		setTitle(" Task 1 ");

		setLayout(new GridLayout(10, 1));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			add(buttons[i]);
			buttons[i].setText("" + i);
			buttons[i].addActionListener(new Action());

		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new Task1();

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < buttons.length; i++) {

				if (e.getSource() == buttons[i]) {
					line += buttons[i].getText();
					if (counter == 2) {
						JOptionPane.showMessageDialog(null, line);
						line = "Number: ";
						counter = 0;
					} else {
						counter++;
					}
				}

			}
		}

	}

}
