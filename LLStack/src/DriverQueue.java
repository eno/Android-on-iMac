


public class DriverQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	LLQueue<String> myQ = new LLQueue <String>();
	myQ.enqueue("Mercy");
	myQ.enqueue("CS");
	myQ.enqueue("Cybersecurity");
	System.out.println(myQ.dequeue());
	System.out.println();
	while (! myQ.isEmpty() )
	System.out.println(myQ.dequeue());
	
	System.out.println("-----------------");

	
	LLQueue<Integer> myQ2 = new LLQueue <Integer>();
	myQ2.enqueue(21);
	myQ2.enqueue(44);
	myQ2.enqueue(1);
	System.out.println(myQ2.dequeue());
	System.out.println();
	while (! myQ2.isEmpty() )
	System.out.println(myQ2.dequeue());
	}

}
