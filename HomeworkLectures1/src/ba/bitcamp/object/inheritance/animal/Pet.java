package ba.bitcamp.object.inheritance.animal;

/**
 * This class present pet with specified attributes
 * 
 * @author Niddal
 *
 */
public class Pet {

	private String name;
	private int age;
	private String typeOfPet;

	/**
	 * Constructor for pet
	 * 
	 * @param name
	 *            - string name of pet
	 * @param year
	 *            - string age of pet
	 * @param typeOfPet
	 *            - string type of pet
	 */
	public Pet(String name, int age, String typeOfPet) {
		super();
		this.name = name;
		this.age = age;
		this.typeOfPet = typeOfPet;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTypeOfPet() {
		return typeOfPet;
	}

	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}

	@Override
	public String toString() {
		return "Pet name is" + name + ", age is " + age + ", type of Pet is "
				+ typeOfPet + ".";
	}

}
