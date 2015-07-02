package ba.bitcamp.homework17.tasks;

/**
 * This class present two methods for array of computers
 * 
 * @author Niddal
 *
 */
public class ArrayManipulation {

	/**
	 * Expend array of computers for one place and enter null in last index
	 * 
	 * @param c
	 *            - array of computers
	 */
	public static Computer[] extendArray(Computer[] c) {

		Computer[] c1 = new Computer[c.length + 1];
		for (int i = 0; i < c.length; i++) {
			c1[i] = c[i];
		}
		c = c1;
		return c;
	}

	/**
	 * Method which deleted computer on entered index k from array of computers
	 * 
	 * @param c
	 *            - array of computers
	 * @param k
	 *            - index
	 */
	public static void shrinkArray(Computer[] c, int k) {

		Computer[] c1 = new Computer[c.length - 1];
		for (int i = 0; i < k; i++) {
			c1[i] = c[i];
		}
		for (int i = k + 1; i < c1.length; i++) {
			c1[i] = c[i];
		}

	}

}