package textbook;

public interface ListIterator {

	Object next();
	boolean hasNext();
	void add(Object element);
	void remove();
	void set(Object element);
	
}
