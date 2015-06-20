package ba.bitcamp.object.inheritance.animal;

public class Main {

	public static void main(String[] args) {

		// Declaration new dog with specified attributes
		Dog d1 = new Dog("Rex", 4, "Husky");
		System.out.println(d1.toString());

		// Declaration new cat with specified attributes
		Cat c1 = new Cat("Mex", 2, false);

		System.out.println(c1.toString());

	}

}
