package ba.bitcamp.object.inheritance.bookstore;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class present bookstore with specified attributes
 * 
 * @author Niddal
 *
 */
public class Bookstore {

	Scanner input = new Scanner(System.in);

	// Attributes of bookstore
	private String name;
	private Book[] book;

	/**
	 * Declaration constructor for bookstore
	 * 
	 * @param name
	 *            - name of bookstore
	 * @param book
	 *            - array of book for sale;
	 */
	public Bookstore(String name, Book[] book) {
		super();
		this.name = name;
		this.book = book;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book[] getBook() {
		return book;
	}

	public void setBook(Book[] book) {
		this.book = book;
	}

	/**
	 * Method for add new book in bookstore, book is not for sale
	 * 
	 * @param num
	 *            - number of book
	 */
	public void addNewBook(int num) {

		Book b[] = new Book[num];
		for (int i = 0; i < num; i++) {
			b[i] = new Book("Book" + (i + 7), 10 + i, "Author" + (i + 2),
					(i + 1));
			System.out
					.println("Information of new book: \n " + b[i].toString());
		}
	}

	/**
	 * Method for sell book
	 */
	public void sellBook() {

		int counter = 0;
		int num = 1;
		do {

			System.out.println("Enter name of book for sale");
			String s = input.nextLine();

			for (int i = 0; i < book.length; i++) {

				if (book[i].getName().equals(s)) {

					if (book[i].getStatus() != Book.NULL_BOOK) {
						book[i].setStatus(book[i].getStatus() - 1);
						System.out.println("One book is sold. We have "
								+ book[i].getStatus() + " more books");
						break;
					} else {
						System.out.println("No more book in the store");
						break;
					}

				}
				counter++;
			}
			if (counter == book.length) {
				System.out.println("Wrong name of book");
			}
			try {
				System.out.println("Enter 1 for again sale,  or -1 for exit");
				num = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Only 1 or -1");
			}
			input.nextLine();
		} while (num != -1);

	}

	/**
	 * Find name of book of entered author
	 */
	public void authorBooks() {

		System.out.println("Enter name of author");
		String a = input.nextLine();
		String l = "";
		int counter = 0;
		for (int i = 0; i < book.length; i++) {

			if (book[i].getAuthor().getName().equals(a)) {
				l += (book[i].getName()) + " ,";
			} else {
				counter++;

			}

		}
		if (counter == book.length) {
			System.out.println("No book of the imputed author");
		} else {
			System.out.println(l);
		}

	}

	/**
	 * Method toString for printing information to console
	 */
	public String toString() {
		String l = "";
		l += "Bookstore name is " + name + ",\n Book for sale is ";
		for (int i = 0; i < book.length; i++) {
			l += " \n  " + book[i].getName() + ". ";
		}
		return l;
	}

}
