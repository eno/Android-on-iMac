// File:    FIFOQueueInterface.java
// Author:  John Yoon
// Date:    dd/mm/yyyy
// Purpose: Specification for FIFO queue

public interface FIFOQueueInterface <E>
{
   boolean isEmpty();
   void enqueue(E item);
   E dequeue();
}