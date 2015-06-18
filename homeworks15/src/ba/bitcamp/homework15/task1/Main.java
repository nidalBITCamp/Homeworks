package ba.bitcamp.homework15.task1;

public class Main {

	public static void main(String[] args) {
		// Declaration new class Safe with name specified name
		Safe s = new Safe("Safe for everyone");

		// Print to console information of Safe
		s.printInformation();
		// Add money to safe in this case 30 KM
		s.addMoney(30);
		// Print to console information of Safe
		s.printInformation();
		// Add money to safe in this case 100 KM
		s.addMoney(100);
		// Print to console information of Safe
		s.printInformation();
		// Clear all money
		s.clear();
		// Print to console information of Safe
		s.printInformation();
	}

}
