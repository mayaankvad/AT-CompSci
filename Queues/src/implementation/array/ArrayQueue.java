package implementation.array;

import java.util.Arrays;

public class ArrayQueue implements MyQueue {

	private Object[] elements;
	int first;
	int end;

	public ArrayQueue() {
		elements = new Object[10];
		first = 0;
		end = -1;
	}

	@Override
	public boolean empty() {
		pretty();
		return elements[first] == null;
	}

	@Override
	public boolean offer(Object item) {
		this.end++;
		try {
			elements[end] = item;
		}
		catch(Exception e) {
			resize();
			elements[end] = item;
		}
		return true;
	}

	@Override
	public Object poll() {
		Object e = this.elements[first];
		this.elements[first] = null;
		return e;
	}

	@Override
	public Object peek() {
		return this.elements[first];
	}

	@Override
	public String toString() {
		pretty();
		return Arrays.toString(elements);
	}

	/**
	 * Adds q to the end of the current queue. Queue q is then cleared.
	 */
	public void append(ArrayQueue q) {
		while(!q.empty()) {
			this.offer(q.poll());
		}
	}

	/**
	 * Inserts q to the current queue alternately. Queue q is then cleared.
	 */
	public ArrayQueue alternate(ArrayQueue q) {
		ArrayQueue n = new ArrayQueue();
		
		this.pretty();
		q.pretty();
		
		
		while(!this.empty()) {
			n.offer(this.poll());
			n.offer(q.poll());
			
			this.pretty();
			q.pretty();
		}
		
		n.pretty();
		
		return n;
	}

	// shifts head to 0
	private void pretty() {

		int size = 0;
		for (Object o : elements) {
			size += (o != null) ? 1 : 0;
		}

		Object[] e = new Object[size];

		int j = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				e[j] = elements[i];
				j++;
			}
		}

		elements = e;
		end = e.length -1;
		first = 0;
		resize();

	}

	// adds 10 more elements to the end
	private void resize() {

		Object[] e = new Object[elements.length + 10];

		for (int i = 0; i < elements.length; i++) {
			e[i] = elements[i];
		}

		elements = e;

	}

}
