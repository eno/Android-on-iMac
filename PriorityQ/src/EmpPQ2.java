import java.util.PriorityQueue;


public class EmpPQ2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	PriorityQueue <Emp> myQ = new PriorityQueue <Emp>();	
 	myQ.add(new Emp(23, "Adam", 123.45));	
 	myQ.add(new Emp(23, "Bob", 93.25));
 	myQ.add(new Emp(23, "George", 129.99));
 	myQ.add(new Emp(23, "Xiang", 4568.22));
 	myQ.add(new Emp(23, "Alfredo", 985.00));
 	myQ.add(new Emp(23, "Poe", 1985.10));
 	
 	while (myQ.size() != 0){
 		System.out.println(myQ.remove());
 	}
	}
	}
	
	
			
		




