package ba.bitcamp.weekendhomewor.task;

public class Main {

	public static void main(String[] args) {

		// Declaration characters for goal
		Character c = new Character("Cimi", "male", false);
		Character c1 = new Character("Cima", "male", true);
		Character c2 = new Character("Cimke", "male", true);
		Character c3 = new Character("Cimka", "female", false);
		Character c4 = new Character("Cimer", "male", false);

		// Declaration new event
		Event e = new Event(Event.DEFEAT);
		System.out.println(e.toString());

		// Declaration new goal
		Goal g = new Goal("Fihgt", Goal.EASY_GOAL, e, c);
		System.out.println(g);

		// Declaration new protagonist
		Protagonist pg = new Protagonist("Monster", "male", true, g);

		// Set the enemy with method
		pg.setEnemy(c2);

		// Add support
		pg.addSupport(c);
		pg.addSupport(c1);
		pg.addSupport(c2);
		pg.addSupport(c2);

		// Start the goal ad print the result
		pg.attainGoal();
		

	}
}
