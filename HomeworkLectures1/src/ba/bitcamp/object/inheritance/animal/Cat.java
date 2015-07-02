package ba.bitcamp.object.inheritance.animal;

public class Cat extends Pet {

	private boolean isWild;

	/**
	 * Declaration constructor for cat
	 * 
	 * @param name
	 *            - name of pet
	 * @param age
	 *            - age of pet
	 * @param typeOfPet
	 *            - type of pet
	 * @param isWild
	 *            boolean is wild or not
	 */
	public Cat(String name, int age, boolean isWild) {
		super(name, age, null);
		this.setWild(isWild);
	}

	public boolean isWild() {
		return isWild;
	}

	public void setWild(boolean isWild) {
		this.isWild = isWild;
	}

	/**
	 * Method toString for print specified information
	 */
	@Override
	public String toString() {
		return "Go away human";
	}

}
