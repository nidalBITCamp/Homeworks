package ba.bitcamp.sql.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * This class present the information of consumer complaints for employees
 * 
 * @author Niddal.Salkic
 *
 */
public class ListOfComplaints extends JFrame {

	private static final long serialVersionUID = 3648805382776185023L;

	public ListOfComplaints() {

		// Declaration of text area
		JTextArea info = new JTextArea();

		// Add title for text area
		info.setBorder(BorderFactory
				.createTitledBorder(" Consumer complaints "));

		// Add scroll to text area
		JScrollPane scroll = new JScrollPane(info);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Made a access to date base
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

		// Declaration the array list of Complaints
		ArrayList<Complaints> list = new ArrayList<Complaints>();

		// Creating the statement and execute query for select all complaints in
		// the data base
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("select * from complaints");

			while (result.next()) {

				Integer id = result.getInt(1);
				String date = result.getString(2);
				String complaints = result.getString(3);

				Complaints compl = new Complaints(id, date, complaints);
				list.add(compl);

			}

		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		// Adding the complaints info into text area
		for (Complaints c : list) {

			info.append(c.toString());
		}

		// Add info- text area to main window
		add(info);

		// Set some of option for window
		setSize(500, 300);
		setResizable(false);
		setTitle("   Book of complaints...   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
