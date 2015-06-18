package ba.bitcamp.homework2.task1;

public class Temperature {

	private int temp;

	/**
	 * Constructor for temperature
	 * 
	 * @param temp
	 *            - value of temperature
	 */
	public Temperature(int temp) {

		this.temp = temp;
	}

	/**
	 * Get the value of temperature
	 * 
	 * @return - value of temperature
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Method which return temperature in Kelvin
	 * 
	 * @return temperature in Kelvin
	 */
	public int getKelvin() {
		return this.temp + 274;
	}

	/**
	 * Method which return temperature in Fahrenheit
	 * 
	 * @return Temperature in Fahrenheit
	 */
	public double getInF() {
		return this.temp * 1.8 + 32;
	}

	/**
	 * Set the temperature
	 * 
	 * @param temp
	 *            temperature
	 */
	public void setTemp(int temp) {
		this.temp = temp;
	}

	/**
	 * Method for printing to console class temperature
	 */
	public String toString() {
		return "Temperature is " + temp + ".";
	}

}
