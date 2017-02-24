
public class BinaryTreeTest extends BinaryTree
{
	
  public static void main (String [] args) {
	  StringBuilder sb1 = new StringBuilder();
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
    bt.preOrderTraverse(null, 0, sb1);
    
   
    System.out.println(bt);
  }
  public String toString() {
	  StringBuilder sb1 = new StringBuilder();
		preOrderTraverse(root, 1, sb1);
		return sb1.toString();
  
  }
  
  BinaryTreeTest left;
  BinaryTreeTest right;
  int value;

  public BinaryTreeTest(int v) {
  value = v;
  }
  
public void insert(int v) {
	  if(v < value) {
	  if(left == null)
	  left = new BinaryTreeTest(v);
	  else
	  left.insert(v);
	  }
  
	  else if(v > value) {
		  if(right == null)
		  right = new BinaryTreeTest(v);
		  else
		  right.insert(v);
		  }
		  }
BinaryTreeTest b = new BinaryTreeTest(50);
/*b.insert(20);
b.insert(40);
b.insert(10);
b.insert(5);
b.insert(45);

b.insert(70);
b.insert(60);
b.insert(80);
b.insert(55);
b.insert(85);
*/		  
public void preorder() {
System.out.println(value);
if(left != null) left.preorder();
if(right != null) right.preorder();
}  
  
  
  
  
  
  
}