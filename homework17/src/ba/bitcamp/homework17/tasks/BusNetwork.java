package ba.bitcamp.homework17.tasks;

/**
 * This class present Busnetwork with attribute name ,which extends with class
 * Network and implements interface Functionable
 * 
 * @author Niddal
 *
 */
public class BusNetwork extends Network implements Functionable {

	// Assistant variable
	static int counter;
	static int num;

	/**
	 * Constructor for BusNEtwork
	 * 
	 * @param name
	 *            - string name of network
	 */
	public BusNetwork(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method for check functionable of network
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isFunctionable() {

		for (int i = 0; i < comp.length; i++) {
			if (comp[i] == null) {
				num++;
			}
		}

		if (num >= 2) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Method for add computer to network
	 * 
	 * @param c
	 *            - object of computer
	 */
	@Override
	public void addComputer(Computer c) {

		if (c instanceof Client) {
			Client c1 = (Client) c;
			Computer comp1[] = ArrayManipulation.extendArray(comp);
			comp1[comp1.length - 1] = c1;
			c1.connect(this);
			counter++;

		} else {
			throw new ClassCastException();

		}

	}

	/**
	 * Method for remove computer from network
	 * 
	 * @param c
	 *            - object of computer
	 */

	@Override
	public void removeComputer(Computer c) {

		if (c instanceof Client) {

			Client c1 = (Client) c;
			for (int i = 0; i < comp.length; i++) {
				if (c1.equals(comp[i])) {
					c1.disconnect();
					ArrayManipulation.shrinkArray(getComp(), i);
					counter--;
					return;
				} else {
					throw new UnsupportedOperationException();
				}
			}

		}
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Number of computers are: " + counter
				+ " Network functionable is " + isFunctionable();
	}

}