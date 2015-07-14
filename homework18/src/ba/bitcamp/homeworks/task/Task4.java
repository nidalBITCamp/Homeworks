package ba.bitcamp.homeworks.task;

import javax.swing.JOptionPane;

/**
 * This class present a program that asks the user to enter a number. Then asks
 * the user whether he wants to enter another number
 * 
 * @author Niddal
 *
 */
public class Task4 {

	public static void main(String[] args) {

		Integer num = 0;

		int sum = 0;
		boolean s = true;

		while (s) {

			try {

				// Set the first message dialog
				String s1 = JOptionPane.showInputDialog("Enter the number");
				if (s1.equals(null)) {
					throw new NullPointerException("");

				} else {
					num = Integer.parseInt(s1);
					sum += num;

					// Set the message dialog if user use cancel option
					if (num == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Sum of number is "
								+ sum);
					} else {

						// Set the option of second message dialog if user use
						// OK option
						int choice = JOptionPane.showConfirmDialog(null,
								"Enter again");
						if (choice == JOptionPane.YES_OPTION) {
							s = true;
						} else if (choice == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null,
									"Sum of number is " + sum);
							s = false;
						} else if (choice == JOptionPane.CANCEL_OPTION) {
							System.exit(3);
							s = false;
							JOptionPane.showMessageDialog(null,
									"Okay, you canceled.");
						}
					}
				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Wrong input");
				System.exit(3);

			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Sum of number is " + sum);
				System.exit(3);
			}
		}
	}
}