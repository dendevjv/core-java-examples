package corejava8L.ch05inheritance;

public class PersonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person[] people = new Person[2];
		
		people[0] = new Employee("Harry Hacker", 50000);
		people[1] = new Student("Maria Morris", "Computer Science");
		
		for (Person p : people) {
			System.out.println(p.getName() + ", " + p.getDescription());
		}

	}

}
