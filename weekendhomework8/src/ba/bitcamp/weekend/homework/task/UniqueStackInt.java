package ba.bitcamp.weekend.homework.task;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class present integer stack with specified methods
 * 
 * @author Niddal.Salkic
 *
 */
public class UniqueStackInt {

	private int[] array;

	public UniqueStackInt() {

		super();
		this.array = new int[0];
	}

	/**
	 * Method for adding element to stack if he does not already exist
	 * 
	 * @param value
	 *            - integer value of element
	 */
	public void push(int value) {

		boolean temp = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				System.out.println("ERROR");
				temp = true;
			}
		}
		if (temp == false) {

			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = value;

		}
	}

	/**
	 * Method for remove last element of array
	 * 
	 * @return = removed element
	 * @throws EmptyStackException
	 */
	public int pop() throws EmptyStackException {

		if (array.length > 0) {

			int temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);

			return temp;

		} else {

			throw new EmptyStackException();
		}
	}

	/**
	 * Check are element are sorted by value
	 * 
	 * @return true it does
	 */
	public boolean isIncreasing() {

		boolean tmp = false;
		for (int i = 0; i < array.length - 1; i++) {

			if (array[i] < array[i + 1]) {

				tmp = true;
			} else {
				return false;
			}
		}
		if (tmp)

			return true;
		return tmp;

	}

	/**
	 * toString method
	 */
	public String toString() {

		return Arrays.toString(array);
	}

}
