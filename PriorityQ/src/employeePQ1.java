import java.util.PriorityQueue;
import java.util.Comparator;


public class employeePQ1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Employee>myQ = new PriorityQueue <Employee>(16,
				new Comparator <Employee>(){
					public int compare (Employee e1, Employee e2) {
						if (e1.getSalary() == e2.getSalary()) return 0;
						else if (e1.getSalary() > e2.getSalary()) return 1;
						else return -1;
					}			
	});
 	myQ.add(new Employee(23, "Adam", 123.45));
 	myQ.add(new Employee(23, "jo", 123.45));
 	myQ.add(new Employee(23, "Bob", 93.25));
 	myQ.add(new Employee(23, "George", 129.99));
 	myQ.add(new Employee(23, "Xiang", 4568.22));
 	myQ.add(new Employee(23, "Alfredo", 985.00));
 	
 	while (myQ.size() != 0){
 		System.out.println(myQ.remove());
 	}
	
	}	
		
}


	
