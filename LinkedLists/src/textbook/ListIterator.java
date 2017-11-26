package textbook;

public interface ListIterator<E> {

	Object next();
	boolean hasNext();
	void add(E element);
	void remove();
	void set(E element);
	
}
