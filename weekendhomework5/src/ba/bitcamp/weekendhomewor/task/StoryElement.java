package ba.bitcamp.weekendhomewor.task;

/**
 * The class that describes an element in the plot of a story
 * 
 * @author Niddal
 *
 */
public abstract class StoryElement {

	// Attributes of class
	private String name;

	/**
	 * The constructor that initializes the name given value
	 * 
	 * @param name
	 *            - string name
	 */
	public StoryElement(String name) {

		this.name = name;
	}

	/**
	 * Empty constructor that initializes , over the first constructor , the
	 * name of the " STElement "
	 */
	public StoryElement() {
		this("STElement");

	}

	/**
	 * Method for get name
	 * 
	 * @return - string name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method for set name
	 * 
	 * @param name
	 *            - string name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Method toString for print information to console
	 */
	@Override
	public String toString() {
		return "Name is " + name + "";
	}
	
	

}
