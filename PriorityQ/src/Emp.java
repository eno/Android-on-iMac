


public class Emp implements Comparable {

	public int compareTo(Object e) {
		// TODO Auto-generated method stub
		if (this.salary == ((Emp) e).salary) return 0;
		else if (this.salary > ((Emp) e).salary) return 1;
		else return -1;
	}

	private int id;
	private String name;
	private double salary;
	
	public Emp(int id, String name, double sal) {
		this.id = id;
		this.name = name;
		salary = sal;
	}
	
	

	public String toString() {
		return id + "\t" + name + "\t" + salary;
	}
}
