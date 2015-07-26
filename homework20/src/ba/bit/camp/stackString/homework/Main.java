package ba.bit.camp.stackString.homework;

public class Main {

	public static void main(String[] args) {

		// Declaration Stack of string array
		StackStringArray s = new StackStringArray();

		// Use some of methods
		System.out.println(s.empty());
		s.push("NIdal");
		s.push("test");
		
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);

		// Testing push method
		Long start = System.currentTimeMillis();
		for (int i = 1; i < 10000; i++) {

			s.push("Line");

		}

		System.out.println("Array time: " + (System.currentTimeMillis() - start));
		System.out.println();
		//////////////////////////////////////////////////////////////
		
		// Declaration Stack of String link
		StackStringLink s1 = new StackStringLink();

		// Use some of methods
		s1.push("Adi");
		s1.push("Nidal");
		s1.push("Adis");
		System.out.println(s1.empty());
		System.out.println(s1.search("Nidal"));
		System.out.println(s1);
		System.out.println(s1.pop());
		System.out.println(s1);

		// Testing push method
		Long start1 = System.currentTimeMillis();

		for (int i = 1; i < 10000; i++) {
			s1.push("Line");
		}

		System.out.println("Link time: "+ (System.currentTimeMillis() - start1));

	}

}
