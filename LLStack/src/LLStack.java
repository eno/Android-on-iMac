import java.util.Scanner;
import java.util.Stack;
public class LLStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack <String> myStack = new Stack();
		myStack.push("Mercy");
		myStack.push("College");
		myStack.push("is");
		System.out.println(myStack.search("Mercy"));
		System.out.println(myStack.pop());
		myStack.push("Number");
		System.out.println(myStack.peek());
		myStack.push("One");
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
		Stack <Integer> myInt = new Stack<Integer>();
		myInt.push(99);
		myInt.push(1);
		myInt.pop();
		System.out.println(myInt.pop());
		
		Stack <Scanner> myScans = new Stack();
		Scanner scan = new Scanner(System.in);
		myScans.push(scan);
		System.out.println(myScans.pop());
		
			
	}

}
