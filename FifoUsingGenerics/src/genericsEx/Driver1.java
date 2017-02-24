package genericsEx;
//This is fifo NOT stack which reverses
import java.util.Scanner;


public class Driver1 {

	public static void main(String[] args) {
		System.out.println("enter 4 inputs");
		Scanner scan = new Scanner(System.in);
		
		LLQueue<FileObject<String>> myQ = new LLQueue();
		String inp;
		
		int i = 0;
		do{
		System.out.print("entry "+(i+1)+": ");
			inp = scan.nextLine();
			i++;
			FileObject noScope = new FileObject(inp);
			myQ.enqueue(noScope);
		}while (i<4);
		
		System.out.println("peek: ");
		myQ.display();
		System.out.println("---------------");
		
		
		System.out.println("dequeue procedure:");
		i=0;
		while (! myQ.isEmpty()){
			
			System.out.println(i+": "+myQ.dequeue());
			i++;
		}
		System.out.println("---------------");

		System.out.println("peek: ");
		myQ.display();
	}

}
