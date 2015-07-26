package ba.bit.camp.stackString.homework;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class present array of string with specified method from Stack form
 * 
 * @author nidal.salkic
 *
 */
public class StackStringArray {

	private String[] array;

	public StackStringArray() {

		array = new String[0];
	}

	/**
	 * Method check is array empty
	 */
	public boolean empty() {

		return (array.length == 0);
	}

	/**
	 * Method for add new string in the array
	 * 
	 * @param line
	 * @return
	 */
	public String push(String line) {

		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = line;
		return line;

	}

	/**
	 * Method for remove last element of array
	 * 
	 * @return = removed element
	 * @throws EmptyStackException
	 */
	public String pop() throws EmptyStackException {

		if (array.length > 0) {

			String temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);

			return temp;

		} else {

			throw new EmptyStackException();
		}

	}

	/**
	 *  Method which return last element of array
	 * 
	 * @throws EmptyStackException
	 */
	public String peek() throws EmptyStackException {

		if (array.length > 0) {

			return array[array.length - 1];

		} else {

			throw new EmptyStackException();
		}
	}

	/**
	 * Method for searching element
	 * 
	 * @param line
	 *            - searching string
	 * @return - index of searching string -1 if do not exist
	 */
	public int search(String line) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			if (array[i].toString().equals(line))
				;

			temp = i;

		}
		temp = -1;

		return temp;

	}

	/**
	 * toString method
	 */
	public String toString() {

		return Arrays.toString(array);
	}

}