package ba.bitcamp.homework2.task2;

public class Main {

	public static void main(String[] args) {

		// Declaration new glass with max capacity
		Glass g1 = new Glass(200);
		System.out.println(g1);

		// Print max place in the glass
		System.out.println("Maximum capacity in thees glass is: "
				+ g1.getMaxAmount());

		// Set new type of liquid
		g1.setType("Cola");
		g1.addLiquid("Cola", 40);
		System.out.println(g1);

		// Print the free space in the glass
		System.out.println("Empty space in the glass is: "
				+ g1.getCurrentlyAmount());

		// Add different liquid
		g1.addLiquid("Pepsi", 30);

		// Empty the glass for input new type of liquid and get new information
		// of glass
		g1.emptyGlass();
		System.out.println(g1);
	}

}
