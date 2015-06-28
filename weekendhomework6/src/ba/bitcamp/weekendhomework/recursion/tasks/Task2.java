package ba.bitcamp.weekendhomework.recursion.tasks;

public class Task2 {

	public static void fillArray(int[][] matrix) {

		fillArray(matrix, 0, 0, 0);
	}

	/**
	 * MEthod for fill matrix
	 * 
	 * @param matrix
	 *            - empty matrix
	 * @param a
	 *            - column
	 * @param b
	 *            - row
	 * @param c
	 *            - number for input
	 */
	public static void fillArray(int[][] matrix, int a, int b, int c) {

		if (a == matrix.length) {

			return;
		}
		if (b == matrix[a].length - 1) {
			matrix[a][b] = c;
			fillArray(matrix, a + 1, 0, c + 1);

		} else {
			matrix[a][b] = c;
			fillArray(matrix, a, b + 1, c + 1);
		}

	}

	public static void main(String[] args) {

		int[][] matrix = new int[8][7];
		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();

		}
	}

}
