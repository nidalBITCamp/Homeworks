package ba.bitcamp.homework15.task2;

public class Animal {

	// Attributes of class Animal
	private String name;
	private Integer activeDayOrNight;
	private Integer needWater;
	private static Integer isDayOrNight;
	private static Integer existenceOfWater;

	// Declaration of constructor
	public Animal(String name, Integer activeDayOrNight, Integer needWater) {
		super();
		this.name = name;
		this.activeDayOrNight = activeDayOrNight;
		this.needWater = needWater;
		this.isDayOrNight = 1;
		this.existenceOfWater = 1;
	}

	/**
	 * Print the status of animal to console
	 */
	public void printStatus() {

		if (this.activeDayOrNight.equals(this.isDayOrNight)
				&& this.needWater <= this.existenceOfWater) {
			System.out
					.println("It’s fine. The animal is active and has water.");
		} else if (this.activeDayOrNight.equals(this.isDayOrNight)
				&& this.needWater > this.existenceOfWater) {
			System.out
					.println("The animal is active, but does not have enough water.");
		} else if ((this.activeDayOrNight != this.isDayOrNight)
				&& this.needWater <= this.existenceOfWater) {
			System.out
					.println("The animal is not active, but has enough water.");
		} else {
			System.out
					.println("The animal is not active and it does not have enough water.");
		}

	}

	/**
	 * Change day to night and night to day
	 */
	public static void cycleDayNight() {
		if (Animal.isDayOrNight == 1) {
			Animal.isDayOrNight = 2;
		} else
			Animal.isDayOrNight = 1;
	}

	/**
	 * Set the value of existence of water
	 * 
	 * @param num
	 *            - The number represents the amount of water
	 */
	public static void setAmountOfWater(int num) {
		Animal.existenceOfWater = (num);
	}
}
