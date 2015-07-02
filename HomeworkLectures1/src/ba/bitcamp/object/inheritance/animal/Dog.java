package ba.bitcamp.object.inheritance.animal;

/**
 * This class present dog with attributes. Also this class extends class pet
 * 
 * @author Niddal
 *
 */
public class Dog extends Pet {

	private String species;

	/**
	 * Constructor for dog attributes
	 * 
	 * @param name
	 *            - name of pet
	 * @param age
	 *            - age of pet
	 * @param typeOfPet
	 *            - type of pet
	 * @param species
	 *            - string species of dog
	 */
	public Dog(String name, int age, String species) {
		super(name, age,null);
		this.setSpecies(species);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Method toString for print specified information of dog
	 */
	@Override
	public String toString() {
		return  "Av Av Av";
	}

}
