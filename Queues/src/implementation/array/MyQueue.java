package implementation.array;

public interface MyQueue {

	// Tests if this queue is empty
	public boolean empty();

	// Inserts the specified element into this queue
	public boolean offer(Object item);

	// Retrieves and removes the head of this queue,
	// or returns null if this queue is empty.
	public Object poll();

	// Retrieves, but does not remove, the head of this queue,
	// or returns null if this queue is empty
	public Object peek();

	// Returns a String representation of your queue
	public String toString();

}
