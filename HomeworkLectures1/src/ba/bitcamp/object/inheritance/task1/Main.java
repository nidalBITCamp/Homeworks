package ba.bitcamp.object.inheritance.task1;

public class Main {

	public static void main(String[] args) {

		// Declaration new array of characters
		char[] c = { 'a', 'b', 'c' };
		char[] c1 = { 'a', 'u', 'i' };
		// Declaration new camp string builder with array of characters
		CampStringBuilder csb = new CampStringBuilder(c);
		CampStringBuilder csb1 = new CampStringBuilder(c1);

		// Add character of object Math.random to the end of array of character
		// using method
		csb.append(Math.random());
		System.out.println(csb.toString());

		// Add character of object Math.random to the beginning of array of
		// character using method
		csb1.prepend(Math.E);
		System.out.println(csb1.toString());

	}

}
