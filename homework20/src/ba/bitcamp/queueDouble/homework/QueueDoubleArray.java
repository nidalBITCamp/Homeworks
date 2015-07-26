package ba.bitcamp.queueDouble.homework;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * This class present the queue double array with specified methods
 * 
 * @author nidal.salkic
 *
 */
public class QueueDoubleArray {

	private Double[] array;

	public QueueDoubleArray() {

		array = new Double[0];
	}

	/**
	 * Method for add new double element to array
	 * 
	 * @param num
	 *            - Double value of add element
	 * @return added element
	 */
	public boolean add(Double num) {

		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = num;
		return true;
	}

	/**
	 * Method for get first added element to array
	 * 
	 * @throws EmptyStackException
	 */
	public Double peek() {

		if (array.length > 0) {

			return array[0];

		} else {

			return null;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. This method
	 * differs from peek only in that it throws an exception if this queue is
	 * empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException
	 */
	public Double element() throws NoSuchElementException {

		if (array.length > 0) {

			return array[0];

		} else {

			throw new NoSuchElementException();
		}

	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions. When using a
	 * capacity-restricted queue, this method is generally preferable to add(E),
	 * which can fail to insert an element only by throwing an exception.
	 * 
	 */
	public boolean offer(Double num) {

		return add(num);
	}

	/**
	 * Retrieves and removes the head of this queue. This method differs from
	 * poll only in that it throws an exception if this queue is empty.
	 * 
	 * @return - the head of this queue
	 * @throws NoSuchElementException
	 */
	public Double remove() throws NoSuchElementException {

		if (array.length > 0) {

			double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;

		} else {

			throw new NoSuchElementException();
		}
	}

	/**
	 * Method for remove first element from double array
	 * 
	 * @return removed element
	 */
	public Double poll() {

		if (array.length > 0) {

			double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;

		} else {

			return null;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {

		return Arrays.toString(array);
	}

}