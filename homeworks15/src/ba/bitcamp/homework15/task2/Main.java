package ba.bitcamp.homework15.task2;

public class Main {

	public static void main(String[] args) {
		// Declaration two new animal with specified atributes
		Animal a1 = new Animal("Camel", 1, 1);
		Animal a2 = new Animal("Owl", 2, 3);

		// Print to console status of first animal.Time is day, water existence
		// is low
		a1.printStatus();
		// Print to console status of second animal.Time is day
		a2.printStatus();

		// Change day to night
		Animal.cycleDayNight();
		// Set the existence of water to maximum
		Animal.setAmountOfWater(3);

		// Print to console status of first animal.Time is night,water existence
		// is max
		a1.printStatus();
		// Print to console status of second animal.Time is night,water
		// existence is max
		a2.printStatus();

	}

}
