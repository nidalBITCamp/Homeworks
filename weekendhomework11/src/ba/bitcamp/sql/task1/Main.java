package ba.bitcamp.sql.task1;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Declaration of JList with only two options: write complaints or view
		// complaints
		@SuppressWarnings("rawtypes")
		JList choice = new JList(new String[] { " * WRITE THE COMPLAINTS",
				" * VIEW COMPLAINTS" });

		// Declaration the JOption pane with JList
		int result = JOptionPane.showConfirmDialog(null,
				new JScrollPane(choice), "Book of complaints",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (result != JOptionPane.OK_OPTION) {

			return;
		}

		// If choice first option then made new Book of complaints for input
		// complaint otherwise made new ListOfComplaints for view complaints
		if (choice.getSelectedIndex() == 0) {

			new BookOfComplaints();

		} else if (choice.getSelectedIndex() == 1) {

			new ListOfComplaints();
		}
	}

}
