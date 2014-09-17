package corejava8L.ch05inheritance;

public class Manager extends Employee {
	private double bonus = 0;
	
	public Manager(String name, double salary) {
		super(name, salary);
	}
	
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
	}
	
	public final void setBonus(double b) {
		bonus = b;
	}
	
	@Override
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		Manager other = (Manager) obj;
		return bonus == other.bonus;
	}
	
	@Override
	public int hashCode() {
		return 19 * super.hashCode() + new Double(bonus).hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[bonus=");
		sb.append(String.format("%.1f", bonus));
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Manager[] managers = new Manager[3];
		for (int i = 0; i < managers.length; i++) {
			managers[i] = new Manager("M" + i, (i + 1) * 1000, 2014, 9, 11);
		}
		Employee[] staff = managers;
		for (Employee e : staff) {
			System.out.printf("%s : %h%n", e.toString(), e.hashCode());
		}
		System.out.println();
		
		Employee m1 = new Manager("M1", 2000, 2014, 9, 11);
		print(m1);
		print(staff[1]);
		boolean eq = m1.equals(staff[1]);
		System.out.println(eq);
	}

	private static void print(Employee m1) {
		System.out.printf("%s : %h%n", m1.toString(), m1.hashCode());
	}
}
