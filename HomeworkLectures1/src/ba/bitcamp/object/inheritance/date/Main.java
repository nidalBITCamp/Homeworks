package ba.bitcamp.object.inheritance.date;

public class Main {

	public static void main(String[] args) {

		// Declaration new date with all attributes
		Date d1 = new Date(30, 22, 2001);
		System.out.println(d1);

		// Declaration new date with attribute of day
		Date d2 = new Date(12, 12, 2006);
		System.out.println(d2);

		// Declaration new date with attributes of day and month
		Date d3 = new Date(23, 7);
		System.out.println(d3);

		// Declaration new date with set method
		d2.setDay(5);
		d2.setMonth(18);
		d2.setYear(2001);
		System.out.println(d2);

		// Passed one day and one month with method
		d2.dayPassed();
		System.out.println(d2);
		d2.monthPasse();
		System.out.println(d2);

	}

}
