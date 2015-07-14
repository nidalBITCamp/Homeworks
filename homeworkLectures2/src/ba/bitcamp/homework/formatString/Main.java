package ba.bitcamp.homework.formatString;

public class Main {

	public static void main(String[] args) {
		
		// Start time of method
		double start = System.currentTimeMillis() / 60;

		Print.formatString(
				"%d  format %.6d is with number of %d name of cimer is %.4d",
				true, "stringdkf", 33.455, "aj");

		// End time of method
		double end = System.currentTimeMillis();

		// Print the take time of method
		System.out.println(end - start);


	
	}

}
