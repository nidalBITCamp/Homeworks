package task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterruptingThreads extends JFrame {

	private MyThread thread;
	private JButton button;
	private int temp = 1;

	private static final long serialVersionUID = 3969594738146042179L;

	public InterruptingThreads() {

		// Declaration new swing object for this window
		setLayout(new BorderLayout());
		JLabel info = new JLabel();
		button = new JButton(" PAUSE ");

		// Set the title for JLabel and button
		info.setBorder(BorderFactory.createTitledBorder("  Label info... "));
		button.setBorder(BorderFactory.createTitledBorder(" Function "));

		// Initialize new thread and start them
		thread = new MyThread(info);
		thread.start();

		// Add action listener to button
		button.addActionListener(new ButtonAction());

		// Add label and button to window
		add(info);
		add(button, BorderLayout.SOUTH);

		// Set some of option for window
		setSize(500, 300);
		setResizable(false);
		setTitle("   Interrupting a threads   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (temp == 1) {

				thread.pauseThread();
				button.setText("RESUME");
				temp++;

			} else if (temp == 2) {

				thread.resumeThread();
				button.setText("PAUSE");
				temp = 1;
			}

		}
	}

	public static void main(String[] args) {

		new InterruptingThreads();
	}

}
