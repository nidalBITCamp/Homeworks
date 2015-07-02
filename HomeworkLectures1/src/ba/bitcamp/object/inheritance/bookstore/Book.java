package ba.bitcamp.object.inheritance.bookstore;

/**
 * This class present one book with attributes name, price, author, and number
 * of same book
 * 
 * @author Niddal
 *
 */
public class Book {

	// Declaration constants
	public static final int ONE_BOOK = 1;
	public static final int TWO_BOOK = 2;
	public static final int THREE_BOOK = 3;
	public static final int NULL_BOOK = 0;

	// Attributes of book
	private String name;
	private int price;
	private Author author;
	private int status;
	private String bookAuthor;

	/**
	 * Declaration constructor of book
	 * 
	 * @param name
	 *            - name of book
	 * @param price
	 *            - price of book
	 * @param author
	 *            - Class author
	 * @param status
	 *            - use this input : ONE_BOOK = 1; TWO_BOOK = 2; THREE_BOOK = 3;
	 *            NULL_BOOK = 0;
	 */
	public Book(String name, int price, Author author, int status) {

		this.name = name;
		this.price = price;
		this.author = author;
		this.status = status;
	}

	public Book(String name, int price, String bookAuthor, int status) {

		this.name = name;
		this.price = price;
		this.bookAuthor = bookAuthor;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 *  Equals method
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	/**
	 *  Method toString for printing information of book to console
	 */
	public String toString() {
		if (this.author != null) {
			String l = "";
			l += "Book name is " + name + ", price of book " + price
					+ " $  ,author name is " + author.getName();

			if (status == Book.NULL_BOOK) {
				l += " No books in store";
			} else {
				l += " We have " + status + " copies of the book";
			}
			return l;

		} else {
			String l = "";
			l += "Book name is " + name + ", price of book " + price
					+ " $ ,author name is " + bookAuthor;

			if (status == Book.NULL_BOOK) {
				l += " No books in store";
			} else {
				l += "\n We add " + status + " copies of the book";
			}
			return l;
		}

	}

}
