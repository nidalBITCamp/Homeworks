package task3;

import javax.swing.JLabel;

/**
 * This class present the thread which print the char of alphabet to label every
 * one second
 * 
 * @author Niddal.Salkic
 *
 */
public class MyThread extends Thread {

	private JLabel label;
	private boolean pauseThread = true;

	public MyThread(JLabel label) {

		this.label = label;

	}

	@Override
	public void run() {

		String line = "";
		char alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };

		for (int i = 0; i < alphabet.length; i++) {

			line += alphabet[i];
			while (!pauseThread) {

				yield();
			}

			label.setText(line);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out
						.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.");
				e.printStackTrace();
			}

			// Return character to A
			if (i == alphabet.length) {

				i = 0;
			}
		}
	}

	/**
	 * MEthod for pause thread;
	 */
	public void pauseThread() {

		pauseThread = false;
	}

	/**
	 * Method for resume thread
	 */
	public void resumeThread() {

		pauseThread = true;
	}

}
