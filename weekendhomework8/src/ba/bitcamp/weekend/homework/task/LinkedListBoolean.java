package ba.bitcamp.weekend.homework.task;

/**
 * This class present boolean linked list with specified method
 * 
 * @author Niddal.Salkic
 *
 */
public class LinkedListBoolean {

	private Node start;

	public LinkedListBoolean() {
		start = null;

	}

	/**
	 * Method for add boolean element to boolean linked list
	 * 
	 * @param element
	 *            - boolean value of element
	 */
	public void add(Boolean value) {

		if (start == null) {
			start = new Node(value);

		} else {
			Node last = getLast();

			last.next = new Node(value);
		}

	}

	/**
	 * Method for remove boolean element from boolean linked list
	 * 
	 * @param index
	 *            - index of boolean element
	 * 
	 */
	public void remove(int index) {

		Node tmp = start;
		for (int i = 0; i < index - 1; i++) {
			tmp = tmp.next;
		}
		Node tmp1 = start;
		for (int i = 0; i < index; i++) {
			tmp1 = tmp1.next;
		}

		tmp.next = tmp1;
	}

	/**
	 * Method for remove boolean element with specified index from boolean
	 * linked list
	 * 
	 * @param index
	 *            - index of boolean element
	 * @param b
	 *            - boolean element
	 */
	public void remove(int index, Boolean b) {

		Node tmp = start;

		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}

		for (int i = index; i < getSize(); i++) {
			if (tmp.next.value == b) {
				tmp = tmp.next;
				break;
			} else {
				tmp = tmp.next;
			}
		}
		Node previous = getPreviousNode(tmp);
		previous.setNext(tmp.next);
	}

	/**
	 * Method for remove boolean element to boolean linked list
	 * 
	 * @param element
	 *            - boolean value of element
	 */
	public void remove(Boolean b) {

		Node temp = start;

		for (int i = 0; i < getSize(); i++) {

			if (temp.value == b) {
				break;
			} else {
				temp = temp.next;
			}
		}
		Node previous = getPreviousNode(temp);
		previous.setNext(temp.next);
	}

	/**
	 * Method for check contains of entered boolean element
	 * 
	 * @param b
	 *            - testing element
	 * @return true if list contains element,
	 */
	public Boolean contains(Boolean b) {

		Node tmp = start;

		if (tmp.value.equals(b)) {

			return true;
		}
		while (tmp != null) {

			if (tmp.next.value.equals(b)) {

				return true;
			}
		}
		return false;

	}

	/**
	 * Method for checking are element alternating
	 * 
	 * @return - true if it does
	 */
	public Boolean isAlternating() {

		Node tmp = start;

		while (tmp.next != null) {

			if (tmp.value.equals(tmp.next.value)) {

				return false;
			}

			tmp = tmp.next;

		}

		return true;

	}

	/**
	 * Method for get previous element from link
	 * 
	 * @param - Node which previous element search
	 * @return - previous element of Node n
	 */
	private Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node temp = start;
		while (temp.next != n) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Method for get last element of list
	 * 
	 * @return - last boolean element
	 */
	private Node getLast() {
		Node tmp = start;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp;
	}

	/**
	 * Method for get size of linked boolean list
	 * 
	 * @return - boolean value of size
	 */
	public int getSize() {

		if (start == null) {
			return 0;
		}

		int counter = 0;
		Node temp = start;

		while (temp.next != null) {

			counter++;
			temp = temp.next;

		}

		return counter;
	}

	// To string method
	@Override
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	// /////////////////////////////////////////////////////////////

	/**
	 * inner class which present node
	 * 
	 * @author Nidal.Salkic
	 *
	 */
	class Node {
		Boolean value;
		Node next;

		public Node(Boolean value) {
			this.value = value;
			this.next = null;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			if (next == null) {
				return value + "";
			}

			return value + " , " + next.toString();
		}

	}

}
