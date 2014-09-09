package corejava8L.ch04classes;

import static java.util.Calendar.*;

public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee[] emps = new Employee[] {
				new Employee("Carl Cracker", 75000, 1970, APRIL, 20),
				new Employee("May Wong", 100000, 2001, JULY, 30),
				new Employee("John Hacker", 65000),
				new Employee(55000)
		};
		
//		for (Employee e : emps) {
//			e.raiseSalary(5.0);
//		}

//		for (Employee e : emps) {
//			System.out.printf("Name: %s, Salary: %.2f, Hire date: %tF%n", e.getName(), e.getSalary(), e.getHireDate());
//		}
		
		for (Employee e : emps) {
			System.out.println(e);
		}
	}

}
