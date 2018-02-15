package circularArray;

public class CircularArrayQueue {

	private int tail, head, theSize;
	private Object[] elements;

	public CircularArrayQueue(int capacity) {
		this.elements = new Object[capacity];
	}

	public void add(Object x) {
		resize();
		this.elements[tail] = x;
		this.theSize++;
		this.tail++;
		if (this.tail == this.elements.length) {
			this.tail = 0;
		}

	}

	private void resize() {
		if (this.theSize == this.elements.length) {
			Object[] temp = new Object[elements.length * 2 + 1];
			int count = 0;

			for (int i = head; i < elements.length; i++) {
				temp[count] = elements[i];
				count++;
			}

			for (int i = 0; i < tail; i++) {
				temp[count] = elements[i];
				count++;
			}

			head = 0;
			tail = count;
			elements = temp;
		}
	}

	public Object remove() {
		Object temp = elements[this.head];
		this.elements[this.head] = null;
		this.head++;
		this.theSize--;
		if (this.head == this.elements.length) {
			this.head = 0;
		}
		return temp;
	}

	public int size() {
		return this.theSize;
	}

	public String toString() {
		String out = "";
		for (int i = 0; i < this.elements.length; i++) {
			out += this.elements[i] + " ";
		}
		return out;
	}

}