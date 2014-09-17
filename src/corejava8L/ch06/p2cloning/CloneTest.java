/*
 * Listing 6-2.
 */
package corejava8L.ch06.p2cloning;

public class CloneTest {
	public static void main(String[] args) {
		try {
			Employee original = new Employee("John Q. Public", 50000);
			original.setHireDate(2000, 1, 1);
			System.out.println("original=" + original);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDate(2007, 12, 31);
			System.out.println("original=" + original);
			System.out.println("copy    =" + copy);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}
}
