package ba.bitcamp.weekend.homework.task.main;
import ba.bitcamp.weekend.homework.task.LinkedListBoolean;


public class BooleanListMain {

	public static void main(String[] args) {

		// Declaration of new linked list of boolean
		LinkedListBoolean MyList = new LinkedListBoolean();

		// Adding element with add method
		MyList.add(true);
		MyList.add(false);
		MyList.add(false);
		MyList.add(true);
		MyList.add(false);

		// Testing the remove methods
		MyList.remove(false);
		MyList.remove(3, false);

		// Testing contains method
		System.out.println(MyList.contains(false));

		// Testing is alternating method
		MyList.add(true);
		System.out.println(MyList.isAlternating());

		System.out.println(MyList);

	}

}
