package ba.bitcamp.homework17.tasks;

/**
 * Interface connectable with methods
 * 
 * @author nidal.salkic
 *
 */
public interface Connectable {

	/**
	 * Connected computer
	 * 
	 * @param c
	 *            - computer
	 */
	void connect(Computer c);

	/**
	 * Connected network
	 * 
	 * @param n
	 *            - network
	 */
	void connect(Network n);

	/**
	 * Method for disconnect
	 */
	void disconnect();
	
}