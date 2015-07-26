package ba.bitcamp.LinkedList.homework;

public class Main {

	public static void main(String[] args) {

		LinkedListDouble test = new LinkedListDouble();

		// Testing add methods
		test.add(5.5);
		test.add(4.4, 1);
		test.add(2.2);
		test.add(1.1);
		test.add(3.3, 2);
		System.out.println(test);

		// Testing get methods
		Double first = test.getFirst();
		Double last = test.getLast();
		Double middle = test.getMidle();
		Double num = test.get(2);
		System.out.printf(
				"First: %.1f - Middle: %.1f - Last: %.1f - Specified: %.1f \n",
				first, middle, last, num);

		// Testing remove methods
		test.removeFirst();
		test.removeLast();
		test.remove(1);
		System.out.println(test);

		// Testing constructor with Double linked input
		LinkedListDouble test1 = new LinkedListDouble(test);
		test1.add(1.1);
		System.out.println(test1);

	}

}
