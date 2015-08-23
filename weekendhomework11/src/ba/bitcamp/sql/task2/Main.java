package ba.bitcamp.sql.task2;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main {

	public Main() {

		// Declaration of JList with options: Add article or delete article 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList choice = new JList(new String[] { " * ADD ARTICLE",
				" * DELETE ARTICLE" });

		int result = JOptionPane.showConfirmDialog(null,
				new JScrollPane(choice), "Article option",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (result != JOptionPane.OK_OPTION) {
			return;
		}
		if (choice.getSelectedIndex() == 0) {

			new ArticleBase();
		} else if (choice.getSelectedIndex() == 1) {

			new DeleteArticle();
		}

	}

	public static void main(String[] args) {

		new Main();

	}
}
