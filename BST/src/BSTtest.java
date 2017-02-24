
public class BSTtest
{
  public static void main (String [] args) {
    BinarySearchTree <Integer> bt = new BinarySearchTree <Integer> ();
    bt.add(5);

    bt.add(3);
    bt.add(9);
    bt.add(2);
    bt.add(6);
    bt.add(10);
    bt.add(5);
    bt.add(4);
    bt.add(7);
    //System.out.println(bt.getData());
    System.out.println(bt);
 
    BinarySearchTree <String> bt2 = new BinarySearchTree <String> ();
    bt2.add("Mercy");
    
    bt2.add("College");
    bt2.add("is");
    bt2.add("one");
    bt2.add("of");
    bt2.add("the");
    bt2.add("best");
    bt2.add("NY");
    bt2.add("schools");
    //System.out.println(bt2.getData());
    System.out.println(bt2);
  }
}