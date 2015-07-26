package ba.bitcamp.weekend.homework.task.main;

import ba.bitcamp.weekend.homework.task.UniqueStackInt;

public class UniqueStackMain {

	public static void main(String[] args) {

		// Declaration new integer stack
		UniqueStackInt test = new UniqueStackInt();

		// Adding element to stack
		for (int i = 1; i < 6; i++) {
			test.push(i);
		}

		test.push(9);
		test.push(7);

		// Testing increasing method
		System.out
				.println("Are element sorted by value:" + test.isIncreasing());

		// Testing pop method
		System.out.println(test.pop());

		System.out.println(test);
		System.out
				.println("Are element sorted by value:" + test.isIncreasing());

	}

}
