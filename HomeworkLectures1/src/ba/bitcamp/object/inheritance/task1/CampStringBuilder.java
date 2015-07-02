package ba.bitcamp.object.inheritance.task1;

/**
 * This class present work of class StringBUilder using array of characters
 * 
 * @author Niddal
 *
 */
public class CampStringBuilder {

	private char[] characters;

	/**
	 * Constructor for specified attributes
	 * 
	 * @param characters
	 *            - array of character
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	public char[] getCharacters() {
		return characters;
	}

	public void setCharacters(char[] characters) {
		this.characters = characters;
	}

	/**
	 * Method which add characters of object to the end of the array
	 * 
	 * @param o
	 *            - Object
	 */
	public void append(Object o) {

		int num = characters.length;
		int num1 = num;

		for (int i = 0; i < o.toString().length(); i++) {
			num1++;
		}
		char[] c1 = new char[num1];
		for (int i = 0; i < characters.length; i++) {
			c1[i] = characters[i];
		}

		int counter = 0;
		for (int i = num; i < c1.length; i++) {
			c1[i] = o.toString().charAt(counter++);
		}
		characters = c1;
	}

	/**
	 * Method which add characters of object to the beginning of the array
	 * 
	 * @param o
	 */
	public void prepend(Object o) {
		int num = characters.length;
		int num1 = num;
		for (int i = 0; i < o.toString().length(); i++) {
			num1++;
		}
		char[] c2 = new char[num1];
		for (int i = 0; i < o.toString().length(); i++) {
			c2[i] = o.toString().charAt(i);
		}
		int counter = 0;
		for (int i = o.toString().length(); i < c2.length; i++) {
			c2[i] = characters[counter++];
		}
		characters = c2;
	}

	public String toString() {
		String l = "";
		for (int i = 0; i < characters.length; i++) {
			l += characters[i];
		}
		return l;

	}
}