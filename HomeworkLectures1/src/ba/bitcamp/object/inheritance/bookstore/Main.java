package ba.bitcamp.object.inheritance.bookstore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Declaration new author and print information to console
		Author a = new Author("Patrick", "patrick@mail.com", "male");
		Author b = new Author("Luis", "Luis@mail.com", "male");

		// Declaration new books
		Book b1 = new Book("Book1", 12, a, Book.ONE_BOOK);
		Book b2 = new Book("Book2", 15, a, Book.THREE_BOOK);
		Book b3 = new Book("Book3", 12, a, Book.TWO_BOOK);
		Book b4 = new Book("Book4", 15, b, Book.ONE_BOOK);
		Book b5 = new Book("Book5", 12, a, Book.NULL_BOOK);
		Book b6 = new Book("Book6", 15, b, Book.THREE_BOOK);

		// Declaration array of book for sale
		Book arr[] = new Book[6];
		arr[0] = b1;
		arr[1] = b2;
		arr[2] = b3;
		arr[3] = b4;
		arr[4] = b5;
		arr[5] = b6;

		// Declaration new bookstore
		Bookstore bs = new Bookstore("Store", arr);

		// Add new book in bookstore
		System.out.println("How much you want to add a book to bookstore");
		int num = input.nextInt();
		bs.addNewBook(num);
		System.out.println();
		
		
		// Print information of bookstore
		System.out.println(bs);

		// Method for finding book from specified author and selling books
		bs.authorBooks();
		bs.sellBook();
		
		
		input.close();

	}

}
