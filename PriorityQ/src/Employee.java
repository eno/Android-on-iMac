
public class Employee {

	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double sal) {
		this.id = id;
		this.name = name;
		salary = sal;
	}
	
	public double getSalary() {
		return salary;
	}

	public String toString() {
		return id + "\t" + name + "\t" + salary;
	}
}
