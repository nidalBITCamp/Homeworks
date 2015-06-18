package ba.bitcamp.homework2.task3;

public class Printers {

	// Attributes of printer
	private String name;
	private int amountOfPaper;
	private int amountOfInk;
	private static int printNumOfPaper = 0;

	// Declaration constructor of default printer
	public Printers() {
		this.name = "Default";
		this.amountOfPaper = 0;
		this.amountOfInk = 0;

	}

	// Declaration constructor of printer with specified name
	public Printers(String name) {
		this.name = name;
		this.amountOfPaper = 0;
		this.amountOfInk = 0;

	}

	/**
	 * Method which testing existence paper in the printer
	 * 
	 * @return Boolean true - exist or False- not exist
	 */
	public boolean inkExist() {
		if (this.amountOfInk == 0)
			return false;
		else
			return true;
	}

	/**
	 * Method which testing existence ink in the printer
	 * 
	 * @return - Boolean true - exist or false not exist
	 */
	public boolean paperExist() {
		if (this.amountOfPaper == 0)
			return false;
		else
			return true;
	}

	/**
	 * Counter number of printed papers
	 * 
	 * @return - number of printed papers
	 */
	public static int numberOfPrintPapers() {
		return printNumOfPaper;
	}

	/***
	 * Add paper in the printer
	 * 
	 * @param a
	 *            - amount of paper
	 */
	public void addPaper(int a) {
		this.amountOfPaper += a;

		if (this.amountOfPaper > 100) {
			this.amountOfPaper = 100;
		}
	}

	/**
	 * Set amount of ink to max (100)
	 */
	public void maxInk() {
		this.amountOfInk = 100;
	}

	/**
	 * Method which calculated number of printed paper
	 * 
	 * @param b
	 *            - number of papers to print
	 */
	public void printPaper(int b) {
		if (b > this.amountOfPaper) {
			System.out.println("You need add more paper");
		} else if (b * 3 > this.amountOfInk) {
			this.amountOfInk = 0;
			printNumOfPaper = 33;
		} else {
			for (int i = 0; i < b; i++) {
				this.amountOfPaper -= 1;
				this.amountOfInk -= 3;
				printNumOfPaper++;
				if (this.amountOfInk == 0 || this.amountOfPaper == 0) {
					break;
				}
			}

		}

	}

	/**
	 * Method which print to console name and status of printer
	 */
	public String toString() {
		String line = " ";
		line = "Printers name is " + name;
		if (this.amountOfPaper > 0 && this.amountOfInk > 0) {
			return line = line + " ready";
		} else if (this.amountOfPaper > 0 && this.amountOfInk == 0) {
			return line = line + " No Ink";
		} else if (this.amountOfPaper == 0 && this.amountOfInk > 0) {
			return line = line + " Not paper";
		} else {
			return line = line + " No paper and no ink";
		}

	}

}
