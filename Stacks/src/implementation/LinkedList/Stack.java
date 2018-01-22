package implementation.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Stack<E> {
	
	private LinkedList<E> elements;
	
	public Stack() {
		this.elements = new LinkedList<E>();
	}
	
	public E push(E object) {
		this.elements.addFirst(object);
		return object;
	}
	
	public E pop() {
		return this.elements.removeFirst();
	}
	
	public E peek() {
		return this.elements.getFirst();
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		return this.elements.size();
	}
	
	public int search(E object) {
		int index = -1;
		
		ListIterator<E> iter = this.elements.listIterator();
		while(iter.hasNext()) {
			index++;
			if(iter.next().equals(object)) {
				return index;
			}
		}
		
		return -1;
	}
	
	public String toString() {
		return this.elements.toString();
	}

	
}


