package W.OOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K009_FindMaxObjectList_java7 {

	public static void main(String a[]) {

		List<Empl> emps = new ArrayList<Empl>();
		emps.add(new Empl(10, "Raghu", 25000));
		emps.add(new Empl(120, "Krish", 45000));
		emps.add(new Empl(210, "John", 14000));
		emps.add(new Empl(150, "Kishore", 24000));
		Empl maxSal = Collections.max(emps);
		System.out.println("Employee with max salary: " + maxSal);
	}
}

class Empl implements Comparable<Empl> {

	private int id;
	private String name;
	private Integer salary;

	public Empl(int id, String name, Integer sal) {
		this.id = id;
		this.name = name;
		this.salary = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Empl emp) {

		return this.salary.compareTo(emp.getSalary());
	}

	public String toString() {
		return id + "  " + name + "   " + salary;
	}
}