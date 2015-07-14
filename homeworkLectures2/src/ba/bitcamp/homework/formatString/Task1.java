package ba.bitcamp.homework.formatString;

public class Task1 {

	public static void formatString(String format, Object value) {

		int tmp = format.indexOf('%');

		format = format.substring(0, tmp) + value.toString()
				+ format.substring(tmp + 2, format.length());

		System.out.println(format);
	}

	public static void formatStringManipulation(String format, Object value) {

		int index = format.indexOf('%');
		String tmp = "" + (format.charAt(index + 2));
		String sentence = "";
		
		try {

			int length = Integer.parseInt(tmp);

			if (value.toString().length() >= length) {
				sentence = format.substring(0, index)
						+ value.toString().substring(0, length)
						+ format.substring(index + 4, format.length());
			} else {

				sentence = format.substring(0, index)
						+ value.toString().substring(0,
								value.toString().length());
				for (int i = value.toString().length(); i < length; i++) {
					sentence += " ";

				}
				sentence += format.substring(index + 4, format.length());

			}
		} catch (NumberFormatException e) {
			formatString(format, value);
		}
		System.out.println(sentence);
	}

	public static void main(String[] args) {

		double start = System.currentTimeMillis()/60;
		
		formatString("My %d format", "Nidal");
		formatStringManipulation("My %.3d format", 5342);
		
		double end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		System.out.printf("%b, %d", 5 , 4);
		
		
		
	}
}
