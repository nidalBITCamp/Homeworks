package ba.bitcamp.weekendhomewor.task;

/**
 * The class that describes the event actions of a story
 * 
 * @author Niddal
 *
 */
public class Event {

	public static final int DEFEAT = 1;
	public static final int FRIENDSHIP = 2;
	public static final int LOVE = 3;
	public static final int REVENGE = 4;
	public static final int MANIPULATION = 5;

	private int events;

	/**
	 * Declaration constructor
	 * 
	 * @param event
	 *            - event actions
	 */
	public Event(int events) {
		super();
		this.events = events;
	}

	public int getEvents() {
		return events;
	}

	public void setEvents(int events) {
		this.events = events;
	}

	
	/**
	 * Method toString for print information to console
	 */
	@Override
	public String toString() {
		
		String l = "";
		if (events == DEFEAT) {
			l += "event is defeat";
		} else if (events == FRIENDSHIP) {
			l += "events is friendship";
		} else if (events == LOVE) {
			l += "events is love";
		} else if (events == REVENGE) {
			l += "events is revenge";
		} else if (events == MANIPULATION) {
			l += "events is manipulaton";
		}

		return l;

	}

}
