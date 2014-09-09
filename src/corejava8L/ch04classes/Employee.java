package corejava8L.ch04classes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private static int nextId = 0;

	private String name;
	private double salary;
	private Date hireDate;
	private int id;

	{
		id = initId();
	}

	private static int initId() {
		int next = nextId;
		System.out.println("initId() in init block, id will be " + next);
		nextId++;
		System.out.println("nextId incremented to " + nextId);
		return next;
	}

	public Employee(double salary) {
		this("Employee #" + nextId, salary);
		System.out.println("Constructor Employee(double), current id=" + id + ", nextId=" + nextId);
	}

	public Employee(String name, double salary) {
		System.out.println("Constructor Employee(String,double), current id=" + id + ", nextId=" + nextId);
		this.name = name;
		this.salary = salary;
		Calendar cal = new GregorianCalendar();
		hireDate = cal.getTime();
	}

	public Employee(String name, double salary, int y, int m, int d) {
		System.out.println("Constructor Employee(String,double,int,int,int)");
		this.name = name;
		this.salary = salary;
		Calendar cal = new GregorianCalendar(y, m, d);
		hireDate = cal.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDate() {
		return (Date) hireDate.clone();
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * (byPercent / 100.0);
		salary += raise;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("id=");
		sb.append(id);
		sb.append("; name=");
		sb.append(name);
		sb.append("; salary=");
		sb.append(salary);
		sb.append("; hireDate=");
		sb.append(String.format("%tF", hireDate));
		return sb.toString();
	}
}
