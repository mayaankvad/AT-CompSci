package implementation.arrayList;

import java.util.ArrayList;

public class Stack<E> {
	
	private ArrayList<E> elements;
	
	public Stack() {
		this.elements = new ArrayList<E>();
	}
	
	public E push(E object) {
		this.elements.add(object);
		return object;
	}
	
	public E pop() {
		return this.elements.remove(this.size() -1);
	}
	
	public E peek() {
		return this.elements.get(this.size() -1);
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		return this.elements.size();
	}
	
	public int search(E object) {
		for(int i = 0; i < this.elements.size(); i++) {
			if(this.elements.get(i).equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString() {
		String res = "[";
		
		for(int i = this.elements.size() -1; i >= 0; i--) {
			res += this.elements.get(i) + ", ";
		}
		
		return res + "]";
	}

	
}


