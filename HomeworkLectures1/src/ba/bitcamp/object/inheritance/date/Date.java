package ba.bitcamp.object.inheritance.date;

/**
 * This class present date with format day, month ,year .
 * 
 * @author Niddal
 *
 */
public class Date {

	// Attributes of date
	private int year;
	private int month;
	private int day;

	/**
	 * Declaration constructor for all attributes
	 * 
	 * @param year
	 *            - integer year
	 * @param month
	 *            - integer month
	 * @param day
	 *            - integer day
	 */
	public Date(int day, int month, int year) {

		if (year < 1 || month < 1 || month > 12 || day < 1) {
			System.out.println("Wrong input");
		}
		if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			System.out.println(" Wrong input of day  for entered month");
		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			System.out.println(" Wrong input of day  for entered month ");

		} else if (month == 2 && day > 28) {
			System.out.println(" Wrong input of day  for entered month ");
		}

		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Constructor for two attributes day and month
	 * 
	 * @param month
	 *            - integer month
	 * @param day
	 *            - integer day
	 */

	public Date(int day, int month) {
		this(day, month, 1);
	}

	/**
	 * Constructor only for input attribute of day, Month and Year are set to
	 * value of 1;
	 * 
	 * @param day
	 *            - integer day
	 */
	public Date(int day) {

		this(day, 1, 1);
	}

	/**
	 * Method set for year
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		} else {
			System.out.println("BBC");
		}
	}

	/**
	 * Method for set month
	 * 
	 * @param month
	 *            - integer month
	 */
	public void setMonth(int month) {
		if (month > 0 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("Month is out of range");

		}
	}

	/**
	 * Method for set day
	 * 
	 * @param day
	 *            - integer day
	 */
	public void setDay(int day) {

		if (year < 1 || month < 1 || month > 12 || day < 1) {
			System.out.println("Wrong input");
		}
		if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			System.out.println(" Wrong input of day  for entered month");
		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			System.out.println(" Wrong input of day  for entered month ");

		} else if (month == 2 && day > 28) {
			System.out.println(" Wrong input of day  for entered month ");
		}

		this.day = day;

	}

	/**
	 * Method to add one day
	 * 
	 * @param
	 */
	public void dayPassed() {

		this.day += 1;

		if (day == 32) {

			this.day = 1;
			this.month += 1;
			if (month > 12) {
				month = 1;
				year += 1;
			}
		}

	}

	/**
	 * Method to add one month
	 */
	public void monthPasse() {

		this.month += 1;
		if (month == 13) {
			this.month = 1;
			this.year += 1;
		}
	}

	/**
	 * Method toString for print date in format day.month.year
	 */
	@Override
	public String toString() {

		if (day > 31 || day < 0 || month > 12 || month < 0) {
			System.out.println("Date is out of range");
		} else if (day < 10 && month < 10) {
			return "Date  is: 0" + day + ". 0" + month + ". " + year + "";
		} else if (day < 10) {
			return "Date  is: 0" + day + ". " + month + ". " + year + "";
		} else if (month < 10) {
			return "Date  is: " + day + ". 0" + month + ". " + year + "";

		} else
			return "Date  is: " + day + ". " + month + ". " + year + "";

		return "Please set new date ";

	}
}
