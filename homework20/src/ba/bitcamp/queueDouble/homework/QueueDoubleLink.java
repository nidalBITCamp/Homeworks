package ba.bitcamp.queueDouble.homework;

/**
 * This class present the queue double link with specified methods
 * 
 * @author nidal.salkic
 *
 */
public class QueueDoubleLink {

	private Node start;
	private Node finish;

	public QueueDoubleLink() {

		start = null;
		finish = null;
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning true upon
	 * success and throwing an IllegalStateException if no space is currently
	 * available.
	 * 
	 * @param value
	 *            - double element to add
	 * @return - true if the element was added to this queue, else false
	 */
	public boolean add(Double value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			n.setPrev(start);
			finish = n;
			start.next = n;
		} else {
			finish.next = n;
			n.setPrev(finish);
			finish = n;
		}
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Double poll() {
		try {
			Double tmp = start.value;
			start = start.next;
			start.setPrev(null);
			return tmp;
		} catch (NullPointerException ex) {
			return null;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public Double peek() {
		if (start == null) {
			return null;
		}

		return start.value;
	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * Inner class
	 * 
	 * @author nidal.salkic
	 *
	 */
	private class Node {
		
		Double value;
	    @SuppressWarnings("unused")
		Node prev;
		Node next;

		public Node(Double value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + " ";
			}
			return value + " , " + next.toString();
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

}
