package corejava8L.ch06.p1interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import corejava8L.ch05inheritance.Person;

public class Employee extends Person implements Comparable<Employee> {
	public static void main(String[] args) {
		Employee e1 = new Employee("A1", 100000);
		Employee e2 = new Employee("A1", 100000);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1.equals(e2));
	}
	
	private Date hireDate;
	private double salary;

	public Employee(String name, double salary) {
		super(name);
		Log.finer("Constructor Employee(String,double)");
		this.salary = salary;
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
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
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", getSalary());
	}

	public final Date getHireDate() {
		return (Date) hireDate.clone();
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int hashCode() {
		int h = 11 * getName().hashCode() + 13
				* new Double(salary).hashCode() + 17 * hireDate.hashCode();
		return h;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * (byPercent / 100.0);
		salary += raise;
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

	@Override
	public int compareTo(Employee o) {
		if (salary < o.salary) {
			return -1;
		} else if (salary > o.salary) {
			return 1;
		} 
		return 0;
	}
}
