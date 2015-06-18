package ba.bitcamp.homework15.task1;

public class Safe {
	
	// Attributes of class Safe
	private String name;
	private Integer currentMoney;

	// Declaration of constructor
	public Safe(String name) {
		this.name = name;
		this.currentMoney = 0;
	}

	/**
	 * Add entered money to safe
	 * 
	 * @param input
	 *            - input the value of money
	 */
	public void addMoney(int input) {

		this.currentMoney += input;
	}

	/**
	 * Clear all money from Safe
	 */
	public void clear() {
		this.currentMoney = 0;
	}

	/**
	 * Print information of safe to console
	 */
	public void printInformation() {
		if (this.currentMoney == 0) {
			System.out.println("It is empty...");
		} else if (currentMoney >= 1 && currentMoney <= 20) {
			System.out.println("There’s some, but not much.");
		} else if (currentMoney > 21 && currentMoney < 100) {
			System.out.println("There’s some.");
		} else if (currentMoney > 100) {
			System.out.println("There’s a lot.”");
		}
	}

}
