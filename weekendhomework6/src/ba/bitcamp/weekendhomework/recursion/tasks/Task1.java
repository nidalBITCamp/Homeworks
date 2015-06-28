package ba.bitcamp.weekendhomework.recursion.tasks;

public class Task1 {

	/**
	 * Method for the grading of numbers
	 * 
	 * @param a
	 *            double number- base
	 * @param b
	 *            double number exponent
	 * @return - double number
	 */
	public static double getPower(double a, double b) {

		if (b % 1 == 0) {

			if (b == 0) {

				return 1;
			}

			if (b > 0) {
				return a * getPower(a, b - 1);
			} else {
				return 1 / (a * getPower(a, -b - 1));
			}

		} else {

			if (b == 0) {

				return 1;
			}

			return Math.pow(a, b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getPower(-5.1, -6));

		System.out.println(Math.pow(-5.1, -6));

	}
}
