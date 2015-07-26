package ba.bitcamp.weekend.homework.task;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class NumberList {

	public static void main(String[] args) {

		LinkedList<Number> nums = new LinkedList<Number>();

		for (int i = 0; i < 11; i++) {

			nums.add((int) (Math.random() * 10 + 1));
		}

		System.out.println(nums);
		ListIterator<Number> iter = nums.listIterator();

		while (iter.hasNext()) {
			try {
				Number tmp = iter.next();
				Number tmp1 = iter.next();
				System.out.print(tmp.intValue() + tmp1.intValue() + " ");
			} catch (NoSuchElementException e) {
				System.out.println(iter.previous());
				break;

			}
		}

	}

}
