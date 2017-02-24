package genericsEx;
//emptyueueu
public class EmptyQueue extends RuntimeException
{
    public EmptyQueue (String txt) {
    	//constructor must be evoked how the constructor was defind , not as ()
        super(txt); // super calls in a constructor of RTE, Emptyqueue is just an easy wa
        //to call it in our context
    }
}