package ba.bitcamp.weekendhomewor.task;

/**
 * The class that describes the objective of a single character in the plot of a
 * story
 * 
 * @author Niddal
 *
 */
public class Goal extends StoryElement {

	// Constants
	public static final int EASY_GOAL = 1;
	public static final int HARD_GOAL = 2;
	public static final int IMPOSSIBLE_GOAL = 3;

	// Specified attributes
	private int weightOfGoal;
	private Event events;
	private Character characters;

	/**
	 * Constructor that initializes the three mentioned attributes , as well as
	 * the destination name
	 * 
	 * @param name
	 *            - name of goal
	 * @param weightOfGoal
	 *            - level of goal
	 * @param events
	 *            - name o event
	 * @param characters
	 *            - characters
	 */
	public Goal(String name, int weightOfGoal, Event events,
			Character characters) {
		super(name);
		this.weightOfGoal = weightOfGoal;
		this.events = events;
		this.characters = characters;
	}

	public int getWeightOfGoal() {
		return weightOfGoal;
	}

	public void setWeightOfGoal(int weightOfGoal) {
		this.weightOfGoal = weightOfGoal;
	}

	public Event getEvents() {
		return events;
	}

	public void setEvents(Event events) {
		this.events = events;
	}

	public Character getCharacters() {
		return characters;
	}

	public void setCharacters(Character characters) {
		this.characters = characters;
	}

	/**
	 * Print the information of level of goal
	 * 
	 * @return - string informations
	 */
	public String weightToString() {
		String l = "";
		if (weightOfGoal == EASY_GOAL) {
			l += "weight of goal is easy";
		} else if (weightOfGoal == IMPOSSIBLE_GOAL) {
			l += "weight of goal is impossible";
		} else if (weightOfGoal == HARD_GOAL) {
			l += " weight of goal is hard";
		}
		return l;

	}

	
	/**
	 * Method toString for print information to console
	 */
	@Override
	public String toString() {
		super.toString();
		return super.toString() + ", " + weightToString() + ", "
				+ events.toString() + ", characters is " + characters.getName()
				+ ".";
	}

}
