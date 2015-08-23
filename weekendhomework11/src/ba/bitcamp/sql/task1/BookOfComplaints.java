package ba.bitcamp.sql.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * This class present the application for consumer complaints
 * 
 * @author Niddal.Salkic
 *
 */
public class BookOfComplaints extends JFrame {

	private static final long serialVersionUID = -3198156231549173438L;

	private JTextArea message = new JTextArea();

	public BookOfComplaints() {

		// Set layout for window
		setLayout(new BorderLayout());

		// Declaration of swing object, button for send and text area for input
		// complaints
		JButton send = new JButton("Send");

		// Add scroll to text area
		JScrollPane scroll = new JScrollPane(message);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Add title for button and area
		scroll.setBorder(BorderFactory
				.createTitledBorder("  Write complaints here:   "));
		send.setBorder(BorderFactory
				.createTitledBorder(" Confirm the complaints "));

		// Add action listener to button
		send.addActionListener(new MyAction());

		// Add scroll with text area and button to window
		add(scroll);
		add(send, BorderLayout.SOUTH);

		// Set some of option for window
		setSize(500, 300);
		setResizable(false);
		setTitle("   Complaints book   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * This class present the action when button pressed, then create new table
	 * in base and insert complaints in the base
	 * 
	 * @author Niddal.Salkic
	 *
	 */
	public class MyAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Made access to data base
			Connection conn = null;
			try {

				Class.forName("org.sqlite.JDBC");
				System.out.println("Library loaded.");

				conn = DriverManager.getConnection("jdbc:sqlite:info.db");
				System.out.println("Connection established.");

			} catch (ClassNotFoundException ex) {
				System.err.println("JDBC library is not loaded.");
				System.err.println("Msg: " + ex.getMessage());
				ex.printStackTrace();
				System.exit(1);
			} catch (SQLException ex) {
				System.err.println("Could not connect to the database.");
				System.err.println("Msg: " + ex.getMessage());
				System.exit(1);
			}

			// Creating the statement, and execute update for make new table
			// complaints in the specified data base
			try {

				Statement statement = conn.createStatement();
				String createTable = "CREATE TABLE IF NOT EXISTS complaints( id INTEGER PRIMARY KEY,time DATE,message TEXT);";
				statement.executeUpdate(createTable);

				// Declaration the time and date of inputed complaint
				DateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println(dateFormat.format(cal.getTime()));

				// Make another execute update for insert complaints with
				// specified attributes in the data base
				String command = "INSERT INTO complaints VALUES(null, + '"
						+ dateFormat.format(cal.getTime()) + "','"
						+ message.getText() + "');";
				statement.executeUpdate(command);

			} catch (SQLException ex) {

				System.out.println("Bad SQL Command.");
				System.out.println("Continuing on.");
			}

			message.setText("");

		}
	}

}
