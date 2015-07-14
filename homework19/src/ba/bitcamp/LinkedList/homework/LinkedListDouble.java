package ba.bitcamp.LinkedList.homework;

/**
 * This class present double linked list with specified method
 * 
 * @author Niddal
 *
 */
public class LinkedListDouble {

	private Node start;

	/**
	 * Empty constructor with default set start to null
	 */
	public LinkedListDouble() {
		super();
		start = null;
	}

	/**
	 * Constructor with input of double linked list, which elements add to this
	 * LinkedListDouble
	 * 
	 * @param doubleLinked
	 *            - Object of LinkedListDouble
	 */
	public LinkedListDouble(LinkedListDouble doubleLinked) {

		for (int i = 0; i <= doubleLinked.getSize(); i++) {

			add(doubleLinked.get(i));
		}
	}

	/**
	 * Method for add double element to double linked list
	 * 
	 * @param element
	 *            - double value of element
	 */
	public void add(Double element) {
		if (start == null) {
			
			start = new Node(element);
		
		} else {
			
			Node last = getLastNode();

			last.setNext(new Node(element));
		}
	}

	public void add(Double element, int index) {

		try {

			Node tmp = start;

			for (int i = 0; i < index - 1; i++) {

				tmp = tmp.getNext();
			}

			Node newNode = new Node(element);
			newNode.setNext(tmp.getNext());
			tmp.setNext(newNode);

		} catch (IndexOutOfBoundsException e) {

			System.out.println(" Wrong index input ");
		}

	}

	/**
	 * Method for remove element from specified index
	 * 
	 * @param index
	 *            - integer index of element
	 */
	public void remove(int index) {
		try {
			Node temp = start;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			Node previous = getPrevious(temp);
			previous.setNext(temp.getNext());

		} catch (IndexOutOfBoundsException e) {

			System.out.println(" Input index is out of range ");
		}
	}

	/**
	 * Method for get previous element from input Object of node
	 * 
	 * @param n
	 *            - specified Object of Node
	 * @return - previous element
	 */
	public Node getPrevious(Node n) {

		if (n == start) {
			return null;
		}

		Node tmp = start;
		while (tmp.getNext() != n) {

			tmp = tmp.getNext();
		}
		return tmp;
	}

	/**
	 * Method for get double value of element from input index
	 * 
	 * @param index
	 *            - integer index of element
	 * @return - double value of element
	 */
	public Double get(int index) {

		try {

			Node tmp = start;
			for (int i = 0; i < index; i++) {

				tmp = tmp.getNext();
			}

			return tmp.getValue();
			
		} catch (IndexOutOfBoundsException e) {

			System.out.println(" Input index is out of raange ");
		}
		return null;
	}

	/**
	 * Method for get size of linked Double list
	 * 
	 * @return - integer vallue of size
	 */
	public int getSize() {

		if (start == null) {
			return 0;
		}

		int counter = 0;
		Node temp = start;

		while (temp.getNext() != null) {

			counter++;
			temp = temp.getNext();

		}

		return counter;
	}

	/**
	 * Method for get middle element from linked list
	 * 
	 * @return - double value of middle element
	 */
	public Double getMidle() {

		if (start == null) {
			return null;
		}

		Node temp = start;

		int size = getSize() / 2;

		for (int i = 0; i < size ; i++) {

			temp = temp.getNext();

		}

		return temp.getValue();

	}

	/**
	 * Method for remove first element from linked list
	 */
	public void removeFirst() {

		Node first = start;
		first = first.getNext();
		start = first;

	}

	/**
	 * Method for remove last element from linked list
	 */
	public void removeLast() {

		Node last = getLastNode();
		Node last1 = getPrevious(last);

		last1.setNext(null);

	}

	/**
	 * Method for get last object of linked list
	 * 
	 * @return - Object of node of last element from linked list
	 */
	public Node getLastNode() {

		if (start == null) {
			return null;
		}
		Node temp = start;
		while (temp.getNext() != null) {

			temp = temp.getNext();
		}
		return temp;

	}

	/**
	 * Method for get first element from linked list
	 * 
	 * @return - double value of first element;
	 */
	public Double getFirst() {

		if (start == null) {
			return null;
		}

		return start.getValue();

	}

	/**
	 * Method for get last element from linked list
	 * 
	 * @return - Double value of last element
	 */
	public Double getLast() {

		return getLastNode().getValue();
	}

	// To string method
	@Override
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * Inner class of Node
	 * 
	 * @author Niddal
	 *
	 */
	public class Node {

		private Double value;
		private Node next;

		/**
		 * Constructor of Node
		 * 
		 * @param value
		 *            - double value
		 */
		public Node(Double value) {
			super();
			this.value = value;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
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
