package ba.bitcamp.homework2.task2;

public class Glass {

	private String types;
	private int amount;
	private int max;

	// Declaration of constructor with only parameters for max amount of water
	public Glass(int max) {
		super();
		this.types = "";
		this.amount = 0;
		this.max = max;
	}

	/**
	 * Method for get type of liquid
	 * 
	 * @return - String type
	 */
	public String getTypeOfLiquid() {
		return types;

	}

	/**
	 * Method for get maxAmount
	 * 
	 * @return - max amount
	 */
	public int getMaxAmount() {
		return max;
	}

	/**
	 * Get the currently amount
	 * 
	 * @return - currently amount
	 */
	public int getCurrentlyAmount() {
		return max -= amount;
	}

	// Set the new type of liquid
	public void setType(String a) {
		this.types = a;
	}

	/**
	 * Method for add liquid type and liquid amount
	 * 
	 * @param a
	 *            - Type of liquid
	 * @param b
	 *            - Amount of liquid
	 */
	public void addLiquid(String a, int b) {
		if (!a.equals(this.types)) {
			System.out.println("Types of liquid is diffrent");
		} else {
			this.types.equals(a);
			this.amount += b;
			if (this.amount > max) {
				this.amount = max;
			}
		}
	}

	/**
	 * Method which empty glass
	 */
	public void emptyGlass() {
		this.types = "";
		this.amount = 0;
	}

	// Method toString for printing information of glass to console
	public String toString() {
		return "Glass types of liquid is " + types + ", capacity is " + amount
				+ ", max capacity is " + max + ".";
	}

}
