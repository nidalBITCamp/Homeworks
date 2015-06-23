package ba.bitcamp.homework17.tasks;

/**
 * This class present server with specified attributes which extend class
 * Computer
 * 
 * @author nidal.salkic
 *
 */
public class Server extends Computer {
	
	
	// Attribute of server
	public int number;

	/**
	 * Constructor for server with attributes from class Computer
	 * 
	 * @param name
	 *            - name of server
	 * @param mac
	 *            - Mac address of computer
	 * @param number
	 *            - number of limit
	 */
	public Server(String name, char[] mac, int number) {
		super(name, mac);
		this.number = number;
	}

	/**
	 * Get method
	 * 
	 * @return - number of limits computer
	 */
	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Server limit is " + number + " Connected computer is:";
	}

}