package ba.bitcamp.sql.task2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class present the application for input new article in the data base
 * with specified attributes
 * 
 * @author Niddal.Salkic
 *
 */
public class ArticleBase extends JFrame {

	private static final long serialVersionUID = -8600581848197188321L;
	private static final int COLUMN = 4;
	private static final int ROW = 2;

	// Declaration JLabel swing object
	private JLabel code = new JLabel("    Code of article");
	private JLabel name = new JLabel("    Name of article");
	private JLabel price = new JLabel("   Price of article");

	// Declaration JTextField swing object
	private JTextField codeField = new JTextField();
	private JTextField nameField = new JTextField();
	private JTextField priceField = new JTextField();

	// Declaration the buttons
	private JButton button = new JButton("Add article");
	private JButton cancel = new JButton("Cancel");

	// Declaration the new Connection
	private Connection conn = null;

	public ArticleBase() {

		// Set layout for main window
		setLayout(new GridLayout(COLUMN, ROW));

		// Add code JLabel and code JTextField in the same line
		add(code);
		add(codeField);
		// Add name label and name field in the same line
		add(name);
		add(nameField);
		// Add price label and price field in the same line
		add(price);
		add(priceField);
		// Add buttons
		add(button);
		add(cancel);

		// Add action listener for button of adding article
		button.addActionListener(new MyAction());

		// Add action listener for cancel button with anonymous class
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				new Main();

			}
		});

		// Set some of option for window
		setSize(400, 200);
		setResizable(false);
		setTitle("   Add item   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * This class present the action listener for button, used for add new
	 * article into base
	 * 
	 * @author Niddal.Salkic
	 *
	 */
	public class MyAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Made access to date base
			try {

				Class.forName("org.sqlite.JDBC");
				System.out.println("Library loaded.");

				conn = DriverManager.getConnection("jdbc:sqlite:article.db");
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

			// Made a new statement and execute update for create new table -
			// articles in the specified data base
			try {

				Statement statement = conn.createStatement();
				String createTable = "CREATE TABLE IF NOT EXISTS articles( id VARCHAR(10) PRIMARY KEY,name VARCHAR(150),price REAL);";
				statement.executeUpdate(createTable);

				// Add new article in the data base with methods
				addArticle(statement);

			} catch (SQLException ex) {
				System.out.println("Bad SQL Command.");
				System.out.println("Continuing on.");
			}

		}
	}

	/**
	 * Method for add new article in the data base with execute update
	 * 
	 */
	private void addArticle(Statement statement) {
		try {
			statement.executeUpdate("insert into articles values ('"
					+ setCode() + "', '" + setName() + "', '"
					+ priceField.getText() + "')");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null,
					"Article with this ID alredy exists");
		}
	}

	/**
	 * Method for checking inputed code of article- code must have 10 digit, and
	 * code could not have a letters
	 * 
	 * @return - String value of code
	 */
	@SuppressWarnings("unused")
	private String setCode() {

		String inputedCode = codeField.getText();

		try {

			int codeNum = Integer.parseInt(inputedCode);

		} catch (NumberFormatException e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Your code have letters!!!");
		}

		if (inputedCode.length() == 10) {

			return inputedCode;

		} else {

			JOptionPane.showMessageDialog(null, "Code must have 10 digits");
		}

		return inputedCode;
	}

	/**
	 * Method for checking inputed name of article, if name exist return
	 * warnings about that
	 * 
	 * @return - String value of name
	 */
	private String setName() {

		String nameForCheck = nameField.getText();
		System.out.println(nameForCheck);

		ArrayList<String> list = getNamesFromBase();

		for (String names : list) {

			if (names.equals(nameForCheck)) {

				int tmp = JOptionPane.showConfirmDialog(null,
						"Do you want add article with same entered name");

				if (tmp == JOptionPane.OK_OPTION) {

					return nameForCheck;

				} else if (tmp == JOptionPane.NO_OPTION) {

					break;
				}
			} else {

				return nameForCheck;
			}
		}
		return nameForCheck;
	}

	/**
	 * Method for get all name of inputed articles in the data base, a add them
	 * into array list
	 * 
	 * @return Array List of article names - String
	 */
	protected ArrayList<String> getNamesFromBase() {

		ArrayList<String> list = new ArrayList<String>();

		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from articles");

			while (result.next()) {

				String existsName = result.getString(2);

				list.add(existsName);
			}

		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		System.out.println(list);
		return list;

	}

}
