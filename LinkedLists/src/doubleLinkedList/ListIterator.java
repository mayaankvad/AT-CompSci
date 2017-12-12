package doubleLinkedList;


public interface ListIterator<E> {

	Object next();
	boolean hasNext();
	boolean hasPrevious();
	void add(E element);
	void remove();
	void set(E element);
	
}