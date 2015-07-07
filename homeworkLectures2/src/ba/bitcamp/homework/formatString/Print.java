package ba.bitcamp.homework.formatString;

import java.util.MissingFormatArgumentException;

public class Print {

	/**
	 * Method for format string with only one indicator
	 * 
	 * @param format
	 *            - String
	 * @param value
	 *            - array of object
	 */
	public static void simpleFormatString(String format, Object... value) {
		String sentence = "";
		int tmp = format.indexOf('%');

		sentence = format.substring(0, tmp);
		for (int i = 0; i < value.length; i++) {
			sentence += value[i];
		}
		sentence += format.substring(tmp + 2, format.length());

		System.out.println(sentence);
	}

	/**
	 * Method for check of compatible string format and entered object
	 * 
	 * @param format
	 *            - String for format
	 * @param value
	 *            - array of Objects
	 * @return true if length of Object is equals with number of char '%' in
	 *         string format
	 */
	public static boolean isCompatible(String format, Object... value) {

		int counter = numberOfFormat(format);
		if (counter == value.length) {
			return true;
		}

		return false;
	}

	/**
	 * Method for fill array of index of characters '%'
	 * 
	 * @param format
	 *            - input string
	 * @return integer array of value of index of character %
	 */
	public static int[] arrayOfIndex(String format) {

		int length = numberOfFormat(format);
		int[] array = new int[length];

		int index = format.indexOf('%');

		while (index >= 0) {
			for (int i = 0; i < length; i++) {
				array[i] = index;

				index = format.indexOf('%', index + 1);
			}
		}

		return array;

	}

	/**
	 * MEthod for calculated number of char '%' in string format
	 * 
	 * @param format
	 *            String
	 * @return integer
	 */
	public static int numberOfFormat(String format) {

		int counter = 0;
		for (int i = 0; i < format.length(); i++) {
			if (format.charAt(i) == '%') {
				counter++;
			}

		}
		return counter;
	}

	/**
	 * Method for formating string for print
	 * 
	 * @param format
	 *            - String
	 * @param value
	 *            - array of Object
	 * @throws MissingFormatArgumentException
	 */
	public static void formatString(String format, Object... value)
			throws MissingFormatArgumentException {

		String sentence = "";
		int counter = 0;

		// if number of indicator is not same of number of elements of object
		// array
		if (isCompatible(format, value) == false) {

			throw new MissingFormatArgumentException("Wrong input");

		} else {

			// Finding the indicator to format and replace it with elemt of
			// array of object
			for (int i = 0; i < format.length(); i++) {

				if (i > format.length() - 2) {
					break;
				}

				// Case without of number of length of string, which need to
				// write in indicator place
				if (format.substring(i, i + 2).equals("%d")) {

					sentence += value[counter];
					counter++;
					i++;

				} else if (format.substring(i, i + 2).equals("%.")) {

					int length = Integer.parseInt(format.charAt(i + 2) + "");

					// If length of object element for input is higher
					if (value[counter].toString().length() > length) {

						sentence += (value[counter].toString().substring(0,
								length));
						counter++;
						i += 3;

					} else {

						sentence += value[counter];
						for (int j = value[counter].toString().length(); j < length; j++) {

							sentence += " ";
						}

						counter++;
						i += 3;
					}

				} else {

					// Add other characters to string
					sentence += format.charAt(i);
				}

			}
			System.out.println(sentence);
		}
	}

}
