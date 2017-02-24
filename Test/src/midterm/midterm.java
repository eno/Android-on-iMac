package midterm;

import java.util.Iterator;import java.util.NoSuchElementException;import java.util.ArrayList;
public class IterableArrayList<E> 
implements Iterable<E>{     private int index;     private ArrayList <E> aLst = new ArrayList<E>();
  public void add(E s) {     aLst.add(s);  }
  public E get(int i) 
  {     return aLst.get(i);  }
  @Override
public Iterator<E> iterator() 
  {     return new ArrayListIterator();  }
  private class ArrayListIterator implements
  Iterator {     @Override
public boolean hasNext() {                return (index < aLst.size());     }
     @Override
	public E next() {              
    	 if (!hasNext()) throw new NoSuchElementException();            E temp = aLst.get(index);
    	 index++;           return temp;     }
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}  }
     }

  public static void main (String[] args) {    
	  IterableArrayList <String> myaLst = new IterableArrayList <String> ();  
	  myaLst.add("zaa");     myaLst.add("ab");     myaLst.add("abc");    
     // answers to the questions to be here  }}
  }