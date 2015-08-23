package ba.bitcamp.sql.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * This class present the application for deleted selected article from data
 * base
 * 
 * @author Niddal.Salkic
 *
 */
public class DeleteArticle {

	// Declaration the JList of article, and connection
	private JList<Article> list;
	private Connection conn = null;

	public DeleteArticle() {

		// Declaration the array of article with length of article list
		Article[] items = new Article[listOfArticles().size()];

		// Add all article from article list to article array
		for (int i = 0; i < listOfArticles().size(); i++) {

			items[i] = listOfArticles().get(i);
		}

		// Declaration the JList with article array
		list = new JList<Article>(items);

		// Made a JOption pane with JList
		int result = JOptionPane.showConfirmDialog(null, new JScrollPane(list),
				"Delete the article", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		// Made a instruction for selected option
		if (result == JOptionPane.OK_OPTION) {

			delete();
			new DeleteArticle();

		} else if (result == JOptionPane.CANCEL_OPTION) {

			new Main();
		}

	}

	/**
	 * Method for get array list of article from data base
	 * 
	 * @return Array list of Article
	 */
	private ArrayList<Article> listOfArticles() {

		ArrayList<Article> list = new ArrayList<Article>();

		// Made a access to data base
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:article.db");

		} catch (SQLException ex) {

			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + ex.getMessage());
			System.exit(1);
		}

		// Create a statement and new execute query for get all articles from
		// specified tables in the data base
		try {

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from articles");

			while (result.next()) {

				String id = result.getString(1);
				String name = result.getString(2);
				Double price = result.getDouble(3);

				Article a = new Article(id, name, price);
				list.add(a);
			}

		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

		System.out.println(list);
		return list;

	}

	/**
	 * Method for delete selected article from data base with specified execute
	 */
	private void delete() {

		Article art = list.getSelectedValue();
		String id = art.getCode();
		try {

			Statement statement = conn.createStatement();
			String command = "DELETE FROM articles WHERE  id = '" + id + "'";
			statement.execute(command);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
