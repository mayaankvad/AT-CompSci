package circularArray;

import java.util.Arrays;

public class CircularArrayQueue {

	private Object[] elements;
	private int head;
	private int tail;
	private int theSize;

	public CircularArrayQueue(int capacity) {
		this.elements = new Object[capacity];
		this.head = -1;
		this.tail = 0;
		this.theSize = 0;
	}

	public void add(Object x) {
		this.elements[this.tail] = x;
		this.head++;
		this.tail++;
		this.theSize++;
	}

	public Object remove() {
		if (this.size() > 0) {
			Object e = this.elements[head];
			this.elements[head] = null;
			
			return e;
			
		}
		return null;
	}

	public int size() {
		return this.theSize;
	}
	
	public String toString() {
		return Arrays.toString(this.elements);
	}

}
