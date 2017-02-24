import java.util.Iterator;
import java.util.LinkedList;


public class IterateLLIteratorMethod {

	public static void main(String[] args) {
		LinkedList myLL = new LinkedList();
		myLL.add("Clinton");
		myLL.add("Bush");
		myLL.add("Obama");
		myLL.add("Romney");
		myLL.add("Washington");
		Iterator myItr = myLL.iterator();
		while (myItr.hasNext()) System.out.println(myItr.next());	
	}

}
