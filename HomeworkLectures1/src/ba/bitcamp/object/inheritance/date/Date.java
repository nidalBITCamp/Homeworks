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

		if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
			System.out.println("Wrong input");
		}
		if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			System.out.println(" Wrong input of day  for entered month");
		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			System.out.println(" Wrong input of day  for entered month ");

		} else if ((year % 4 == 0 && year % 400 == 0) && day > 29) {
			System.out.println(" Wrong input of day for entered month");

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
	 * @throws Exception
	 */
	public void setMonth(int month) throws Exception {
		if (month > 0 && month <= 12) {
			this.month = month;
		} else {
			throw new Exception("Month is out of range");

		}
	}

	/**
	 * Method for set day
	 * 
	 * @param day
	 *            - integer day
	 * @throws Exception
	 */
	public void setDay(int day) throws Exception {

		if (year < 1 || month < 1 || month > 12 || day < 1) {
			throw new Exception("Wrong input");
		} else if (day > 31
				&& (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12)) {
			throw new Exception(" Wrong input of day  for entered month");

		} else if (day > 30
				&& (month == 4 || month == 6 || month == 9 || month == 11)) {
			throw new Exception(" Wrong input of day  for entered month ");

		} else if ((year % 4 == 0 && year % 400 == 0) && day > 29) {
			throw new Exception(" Wrong input of day for entered month");

		} else if (month == 2 && day > 28) {
			throw new Exception(" Wrong input of day  for entered month ");

		}

		this.day = day;

	}

	/**
	 * Method to add one day
	 * 
	 * @param
	 * @throws Exception
	 */
	public void dayPassed() throws Exception {
		try {
			setDay(day + 1);

		} catch (Exception e) {
			setDay(1);
			monthPasse();
		}
	}

	/**
	 * Method to add one month
	 * 
	 * @throws Exception
	 */
	public void monthPasse() throws Exception {

		try {
			setMonth(month + 1);
		} catch (Exception e) {
			setDay(day);
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
