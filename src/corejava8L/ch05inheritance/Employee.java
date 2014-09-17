package corejava8L.ch05inheritance;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {
	public static void main(String[] args) {
		Employee e = new Employee("A", 100000);
		System.out.println(e);
		e = new Manager("Boss", 60000);
		if (e instanceof Manager) {
			Manager m = (Manager) e;
			m.setBonus(10000);
			System.out.println(m);
		} else {
			System.out.println("is not instance of Manager");
		}
	}

	private Date hireDate;
	private double salary;

	public Employee(String name, double salary) {
		super(name);
		Log.finer("Constructor Employee(String,double)");
		this.salary = salary;
		Calendar cal = new GregorianCalendar();
		hireDate = cal.getTime();
	}

	public Employee(String name, double salary, int y, int m, int d) {
		super(name);
		Log.finer("Constructor Employee(String,double,int,int,int)");
		this.salary = salary;
		Calendar cal = new GregorianCalendar(y, m, d);
		hireDate = cal.getTime();
	}

	@Override
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", getSalary());
	}

	public final Date getHireDate() {
		return (Date) hireDate.clone();
	}

	public double getSalary() {
		return salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * (byPercent / 100.0);
		salary += raise;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Employee other = (Employee) obj;
		return getName().equals(other.getName())
				&& salary == other.salary && hireDate.equals(other.hireDate);
	}

	@Override
	public int hashCode() {
		int h = 11 * getName().hashCode() + 13
				* new Double(salary).hashCode() + 17 * hireDate.hashCode();
		return h;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("name=");
		sb.append(getName());
		sb.append("; salary=");
		sb.append(getSalary());
		sb.append("; hireDate=");
		sb.append(String.format("%tF", hireDate));
		sb.append("]");
		return sb.toString();
	}
}
