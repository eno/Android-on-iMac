

//llqueue
public class LLQueue <T> implements FIFOQueueInterface <T>
{

// Node of a linked list

   private class Node
   {
      private T data;
      private Node next;
   }

// Instance variables

   private Node front, back;

// Constructor

   public LLQueue()
   {
      front = back = null;
   }

// Returns whether the queue is empty

   public boolean isEmpty()
   {
      return front == null;
   }


// Inserts the specified type parameter at the back of the queue

   public void enqueue(T data)
   {
      Node newBack = new Node();
      newBack.data = data;
      newBack.next = null;
      if (back == null)
         front = newBack;
      else
         back.next = newBack;
      back = newBack;
   }

// Removes the object at the front of the queue and returns it

   public T dequeue()
   {
      if (isEmpty())
         throw new EmptyQueue("Error: The queue is empty");
      T data = front.data;
      front = front.next;
      if (isEmpty())
         back = null;
      return data;
   }

  public void display() {
    Node temp = front;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
} 