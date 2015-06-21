package ba.bitcamp.weekendhomewor.task;

/**
 * Describes the main positives of the story
 * 
 * @author Niddal
 *
 */
public class Protagonist extends Character {

	private Goal goals;
	private Character[] friends = new Character[3];
	private Character enemy;

	/**
	 * Constructor that initializes the name , gender, ability and objective
	 * character
	 * 
	 * @param name
	 *            - name of character
	 * @param gender
	 *            - gender of characters
	 * @param isAbility
	 *            - ability of characters
	 * @param goals
	 *            - goal of characters
	 */
	public Protagonist(String name, String gender, boolean isAbility, Goal goals) {
		super(name, gender, isAbility);
		this.goals = goals;

	}

	public Character getEnemy() {
		return enemy;
	}

	/**
	 * Method for set enemy
	 * 
	 * @param enemy
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	/**
	 * Method for add support
	 * 
	 * @param c
	 *            - character for support
	 */

	int i = 0;

	public void addSupport(Character c) {

		try {
			friends[i] = c;
			i++;
		} catch (Exception e) {
			System.out.println("You are entered max number of supports");
		}
	}

	/**
	 * MEthod toString for print information to console
	 */
	public String toString() {
		String l = "";
		l += "Protagonist is" + goals + "friends is";
		for (int i = 0; i < friends.length; i++) {
			l += friends[i].getName();
		}
		l += ", enemy=" + enemy + "]";
		return l;
	}

	/**
	 * The method starts a cycle of fighting the main character and attempt to
	 * fathom its goal
	 */
	public void attainGoal() {

		// Calculated what is the chance that the main character fathom its goal
		int chance = 0;

		if (super.isAlive() == true) {
			if (super.isAbility() == true) {
				chance += 40;
			}
			for (int i = 0; i < this.friends.length; i++) {
				if (this.friends[i].isAbility() == true) {
					chance += 20;
				}
			}
			if (enemy.isAbility() == true) {
				chance -= 30;
			}
			if (goals.getWeightOfGoal() == Goal.HARD_GOAL) {
				chance -= 20;
			}
			if (goals.getWeightOfGoal() == Goal.IMPOSSIBLE_GOAL) {
				chance -= 100;
			}
			if (chance < 0) {
				chance = 0;
			} else if (chance > 100) {
				chance = 100;
			}

		} else {
			System.out.println("Character is not alive");
		}

		// Based on the calculated odds method decide whether a character
		// succeeded or not
		if (chance >= 50) {
			System.out.println(" Succes in " + goals.getName());
			for (int i = 0; i < friends.length; i++) {
				if (friends[i].isAbility() == false) {
					friends[i].ability();
					System.out.println("Capable become " + friends[i].getName());
					break;
				} else {
					System.out.println("All assistants are capable");
				}
			}
		} else {
			System.out.println(" Failed in " + goals.getName());
			for (int i = 0; i < friends.length; i++) {
				if (friends[i].isAbility() == false) {
					friends[i].ability();
					System.out.println("Capable became " + friends[i].getName());
				} else {
					friends[i].killCharacter();
					System.out.println("Killed character is " + friends[i].getName());
					break;
				}
			}
		}
	}

}
