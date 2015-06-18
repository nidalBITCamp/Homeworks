 package ba.bitcamp.homework2.task1;

public class Main {
	public static void main(String[] args) {

		// Declaration new temperature and print to console
		Temperature t = new Temperature(40);
		System.out.println(t);

		// Set the temperature to Kelvin and Fahrenheit with method and print it
		System.out.println("Temperature to kelvin is: " + t.getKelvin() + "K");
		System.out.println("Temperature to Fahrenheit is: " + t.getInF() + "F");

		// Set the new value of temperature and print the console
		t.setTemp(60);
		System.out.println("New temperature is " + t.getTemp());

	}
}
