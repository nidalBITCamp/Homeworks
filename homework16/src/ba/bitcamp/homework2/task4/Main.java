package ba.bitcamp.homework2.task4;

public class Main {

	public static void main(String[] args) {

		// Declaration Workers at company
		Employes emp1 = new Employes("Patrick", "male", 1200);
		Employes emp2 = new Employes("John", "male", 900);
		Employes emp3 = new Employes("Ana", "female", 1200);
		Employes emp4 = new Employes("Thomas", "male", 1100);
		Employes emp5 = new Employes("Natalia", "female", 1000);
		Employes director = new Employes("Snow", "male", 3000);

		// Declaration array of employees
		Employes[] emp = new Employes[5];
		emp[0] = emp1;
		emp[1] = emp2;
		emp[2] = emp3;
		emp[3] = emp4;
		emp[4] = emp5;

		// Declaration new company with company name, director and with
		// employees
		Company com1 = new Company("Future Javatar", director, emp);

		// Get number of employees with method
		System.out.println("The company has total employees: "
				+ com1.numberOfEmployes());

		// Get total salary expense including director with method
		System.out.println("Total expense to salary is: " + com1.totalSalary()
				+ " $");

		// Get number of female employees with method
		System.out.println("Number of female employees is: "
				+ com1.femaleEmploye());

		// Raise salary all employees with entered amount with method
		com1.getRaise(100);
		System.out.println("Total expense to salary after raise is: "
				+ com1.totalSalary() + " $");

		// Get information of company with method
		System.out.println(com1);

	}

}
