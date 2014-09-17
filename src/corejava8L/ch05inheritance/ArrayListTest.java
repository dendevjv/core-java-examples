package corejava8L.ch05inheritance;

import java.util.ArrayList;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();

		staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
		staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

		for (Employee e : staff) {
			e.raiseSalary(5);
		}

		for (Employee e : staff) {
			System.out.printf("name=%s, salary=%s, hireDay=%tF%n", e.getName(),
					e.getSalary(), e.getHireDate());
		}
	}

}
