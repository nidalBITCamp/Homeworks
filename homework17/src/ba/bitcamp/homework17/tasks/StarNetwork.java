package ba.bitcamp.homework17.tasks;

public class StarNetwork extends Network implements Functionable {

	int counter;
	private Server s;

	public StarNetwork(String name, Server s) {
		super(name);
		this.s = s;
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

			if (comp[i] != null) {
				counter++;
			}
		}
		if (s.getNumber() < counter) {
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
			Computer[] com1 = ArrayManipulation.extendArray(super.getComp());
			com1[com1.length - 1] = c1;

			c1.connect(s);
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
			for (int i = 0; i < getComp().length; i++) {
				if (c.equals(getComp()[i])) {
					c1.disconnect();
					ArrayManipulation.shrinkArray(getComp(), i);
					counter--;
					return;

				} else {
					throw new UnsupportedOperationException("Don't exist");
				}
			}

		}
		throw new UnsupportedOperationException("Wrong input");

	}

	@Override
	public String toString() {
		return "Number of computers are: " + counter
				+ " network functionable is " + isFunctionable();
	}

}
