package ba.bitcamp.homework17.tasks;

/**
 * This class present clients with specified attributes, which extend class
 * Computer and implements interface Connectable
 * 
 * @author nidal.salkic
 *
 */
public class Client extends Computer implements Connectable {

	// Attributes for Client
	private Computer comp;
	private Network net;

	/**
	 * Constructor for client with computer constructor
	 * 
	 * @param name
	 *            - string name
	 * @param mac
	 *            - Mac Address
	 */
	public Client(String name, char[] mac) {
		super(name, mac);

	}

	/**
	 * Method for connect computer
	 * 
	 * @param c
	 *            - Computer
	 */
	@Override
	public void connect(Computer c) {

		if (comp == null && net == null) {
			comp = c;

		} else {
			throw new NullPointerException("Computers can not connect");
		}
	}

	/**
	 * Method for connect network
	 * 
	 * @param n
	 *            - network
	 */
	@Override
	public void connect(Network n) {
		if (comp == null && net == null) {
			net = n;

		} else {
			throw new NullPointerException("Networks can not connect");
		}
	}

	/**
	 * Method for disconnect computer and network
	 */
	@Override
	public void disconnect() {
		comp = null;
		net = null;

	}

	/**
	 * Check connected computer
	 * 
	 * @return true ,false
	 */
	public boolean isConnectCom() {
		if (comp == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check connected network
	 * 
	 * @return
	 */
	public boolean isConnectedNet() {
		if (net == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Get method for computer
	 * 
	 * @return - computer
	 */
	public Computer getComp() {
		return comp;
	}

	/**
	 * Get method for network
	 * 
	 * @return - network
	 */
	public Network getNet() {
		return net;
	}

	/**
	 * Equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (comp == null) {
			if (other.comp != null)
				return false;
		} else if (!comp.equals(other.comp))
			return false;
		if (net == null) {
			if (other.net != null)
				return false;
		} else if (!net.equals(other.net))
			return false;
		return true;
	}

	/**
	 * Method toString for print information
	 */
	@Override
	public String toString() {
		return "Client: " + super.toString() + ".";
	}

}