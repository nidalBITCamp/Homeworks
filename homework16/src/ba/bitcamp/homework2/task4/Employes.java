package ba.bitcamp.homework2.task4;

public class Employes {

	private String nameOfEmployee;
	private String gender;
	private int salary;

	// Declaration constructor of employees
	public Employes(String nameOfEmployee, String gender, int salary) {

		this.nameOfEmployee = nameOfEmployee;
		this.gender = gender;
		this.salary = salary;
	}

	// Get name of employee
	public String getNameOfEmployee() {
		return nameOfEmployee;
	}

	// Get gender of employee
	public String getGender() {
		return gender;
	}

	// Get salary of employee
	public int getSalary() {
		return salary;
	}

	// Set salary of employee
	public void setSalary(int salary) {
		this.salary += salary;
	}

}
