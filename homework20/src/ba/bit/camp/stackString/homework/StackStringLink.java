package ba.bit.camp.stackString.homework;

import java.util.EmptyStackException;

/**
 * This class present of string link with specified method from Stack form
 * 
 * @author nidal.salkic
 *
 */
public class StackStringLink {

	private Node start;

	public StackStringLink() {
		start = null;

	}

	/**
	 * Check is link empty
	 */
	public boolean empty() {

		return start == null;
	}

	/**
	 * MEthod for add new string in the string link
	 * 
	 * @param value
	 *            - String for add
	 * @return - added string
	 */
	public String push(String value) {

		if (start == null) {

			start = new Node(value);

		} else {

			Node tmp = new Node(value);
			tmp.setNext(start);
			start = tmp;
		}
		return value;
	}

	/**
	 * Get last element of string link
	 */
	public String peek() throws EmptyStackException {

		if (start == null) {

			throw new EmptyStackException();
		}
		return start.getValue();
	}

	/**
	 * Method for remove last element of string link
	 * 
	 * @return removed element
	 * @throws EmptyStackException
	 */
	public String pop() throws EmptyStackException {

		if (start == null) {

			throw new EmptyStackException();

		} else {

			String tmp = start.getValue();
			start = start.getNext();
			return tmp;
		}
	}

	/**
	 * To string method
	 */
	public String toString() {

		if (start == null) {

			return "Link is empty";

		} else {

			return start.toString();
		}

	}

	/**
	 * Method for searching element
	 * 
	 * @param line
	 *            - string for search
	 * @return - index of element or -1 if does not exist
	 */
	public int search(String line) {

		int index = 1;
		if (start == null) {
			return -1;
		}

		Node tmp = start;

		if (tmp.getValue().equals(line))
			return 1;

		while (tmp.getNext() != null) {

			if (tmp.getValue().equals(line))

				return index;
			tmp = tmp.getNext();
			index++;

		}

		return -1;
	}

	/**
	 * Inner class
	 */
	public class Node {

		private Node next;
		private String value;

		public Node(String value) {
			this.value = value;
			next = null;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " , " + next.toString();
		}

	}

}