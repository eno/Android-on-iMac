package midterm1;


public class A {   private String av;   public A(String av) 
{       this.av = av;   }  
public int b() 
	{       int c = (int) (Math.random()*2) - 2;       
	return av.length()+c;   }
public static void main(String []args){
	System.out.println((new A("c")).b());}
}
