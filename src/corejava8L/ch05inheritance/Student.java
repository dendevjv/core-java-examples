package corejava8L.ch05inheritance;

public class Student extends Person {
	private String major;

	public Student(String name, String major) {
		super(name);
		this.major = major;
	}

	@Override
	public String getDescription() {
		return "a student majoring in " + major;
	}

	public static void main(String[] args) {
		Person p = new Student("Bob", "Math");
		System.out.println(p.getDescription());
	}
}
