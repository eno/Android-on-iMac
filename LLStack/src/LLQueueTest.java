//import genericsEx.LLQueue;

//llqueuetest

public class LLQueueTest {

	public static void main(String[] args) {

		LLQueue<String> qe = new LLQueue<String>();

		qe.enqueue("Mercy");
		qe.enqueue("has");
		qe.enqueue("an");
		qe.enqueue("excellent");
		qe.enqueue("Cybersecurity");
		qe.enqueue("program");

		System.out
				.println("\n-------------- 1st -- while of iterator ----------");
		System.out.print(qe.dequeue() + " ");

		System.out.println("\n-------------- 1st -- while END----------");

		// get first value and remove that object from queue
		System.out.println("Queue dequeued :" + qe.dequeue());

		qe.enqueue("Yes!!");

		System.out
				.println("\n-------------- 2nd -- while of iterator ----------");
		while (!qe.isEmpty())
			System.out.print(qe.dequeue() + " ");

		System.out.println("\n-------------- 2nd -- while END----------");

	}
}