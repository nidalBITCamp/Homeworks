package ba.bitcamp.homework2.task4;

import java.util.Arrays;

public class Company {

	// Declaration attributes of company
	private String nameOfCompany;
	private Employes director;
	private Employes[] Employe;

	// Declaration constructor of company
	public Company(String nameOfCompany, Employes director, Employes[] employe) {
		super();
		this.nameOfCompany = nameOfCompany;
		this.director = director;
		Employe = employe;
	}

	/**
	 * Identifies the number of employees in the company including the director
	 * of the company
	 * 
	 * @return - number of employees
	 */
	public int numberOfEmployes() {
		int number = 1;
		for (int i = 0; i < Employe.length; i++) {
			number++;
		}
		return number;
	}

	/**
	 * Calculated salary of all workers
	 * 
	 * @return - value of total salary
	 */
	public int totalSalary() {
		int total = 0;
		for (int i = 0; i < Employe.length; i++) {
			total += Employe[i].getSalary();
		}
		return total + director.getSalary();
	}

	/**
	 * Identifies how many female workers have company
	 * 
	 * @return - number of female workers
	 */
	public int femaleEmploye() {
		int num = 0;
		for (int i = 0; i < Employe.length; i++) {
			if (Employe[i].getGender().equalsIgnoreCase("female")) {
				num++;
			}
		}
		if (director.getGender().equalsIgnoreCase("female")) {
			return num + 1;
		} else
			return num;
	}

	/**
	 * Increasing wages to all employees in the company
	 * 
	 * @param num
	 *            - value of raise
	 */
	public void getRaise(int num) {
		for (int i = 0; i < Employe.length; i++) {
			Employe[i].setSalary(num);
		}
		director.setSalary(num);
	}

	// ToString method which print name of company, name of director and number
	// of employees
	public String toString() {
		return "Company name is " + nameOfCompany + ", director of company is "
				+ director.getNameOfEmployee()
				+ ", number of employees including director is "
				+ numberOfEmployes() + ".";
	}

}
