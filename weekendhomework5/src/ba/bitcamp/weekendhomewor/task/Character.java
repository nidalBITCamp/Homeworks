package ba.bitcamp.weekendhomewor.task;

/**
 * The class that describes one of the characters in the plot of a story.
 * 
 * @author Niddal
 *
 */
public class Character extends StoryElement {

	private String gender;
	private boolean isAlive;
	private boolean isAbility;

	/**
	 * The constructor that initializes the name, gender character and ability
	 * of character
	 * 
	 * @param name
	 *            - string name
	 * @param gender
	 *            - string gender male or female
	 * @param isAlive
	 *            - boolean true is alive
	 * @param isAbility
	 */
	public Character(String name, String gender, boolean isAbility) {
		super(name);
		this.gender = gender;
		this.isAlive = true;
		this.isAbility = isAbility;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAbility() {
		return this.isAbility;
	}

	public void setAbility(boolean isAbility) {
		this.isAbility = isAbility;
	}

	public void killCharacter() {

		this.isAlive = false;
	}

	public void ability() {

		this.isAbility = true;
	}

	/**
	 * Method toString for printing information of character
	 */
	@Override
	public String toString() {
		super.toString();
		return "Character gender is" + gender + ", is alive " + isAlive
				+ ", is ability " + isAbility + ".";
	}

}
