// doc in /Docs
package textbook;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class LinkedList<E> {

	private class Node {
		public E data;
		public Node next;
	}

	private class LinkedListIterator implements ListIterator<E> {
		private Node position;
		private Node previous;
		private boolean isAfterNext;

		public LinkedListIterator() {
			position = null;
			previous = null;
			isAfterNext = false;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			previous = position; // Remember for remove
			isAfterNext = true;

			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}
			return position.data;
		}

		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		public void add(E element) {
			if (position == null) {
				addFirst(element);
				position = first;
			} else {
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			previous = position;
			isAfterNext = false;
		}

		public void remove() {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}

			if (position == first) {
				removeFirst();
			} else {
				previous.next = position.next;
			}

			position = previous;
			isAfterNext = false;

		}

		public void set(E element) {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			position.data = element;

			if (position == null) {
				throw new NoSuchElementException();
			}
			position.data = element;
		}

	}

	private Node first;

	public LinkedList() {
		first = null;
	}

	public void reverse() {
		if (first == null)
			return;
		Node previous = first;
		Node current = first.next;
		first.next = null;

		while (current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		first = previous;

	}

	public E get(int index) {
		ListIterator<E> iter = listIterator();
		int count = 0;

		while (iter.hasNext()) {
			E element = (E) iter.next();

			if (count == index) {
				return element;
			}
			count++;
		}
		return null;

	}

	public E getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public E getLast() {
		ListIterator<E> iter = listIterator();
		E element = null;

		while (iter.hasNext()) {
			element = (E) iter.next();
		}
		return element;

	}

	public boolean remove(E element) {
		ListIterator<E> iter = listIterator();

		while (iter.hasNext()) {
			if (iter.next().equals(element)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	public E removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		E element = first.data;
		first = first.next;
		return element;
	}

	public E removeLast() {
		ListIterator<E> iter = listIterator();
		E elem = null;
		while (iter.hasNext()) {
			elem = (E) iter.next();
		}
		iter.remove();
		return elem;
	}

	public void add(E element) {
		this.addLast(element);
	}

	public void add(int index, E element) {
		ListIterator<E> iter = listIterator();
		int count = 0;

		while (iter.hasNext()) {
			if (count == index) {
				iter.add(element);
				break;
			}
			count++;
			iter.next();
		}
	}

	public void addFirst(E element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}

	public void addLast(E element) {
		ListIterator<E> iter = listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		iter.add(element);

	}

	public void clear() {
		first = null;
	}

	public boolean contains(E element) {
		ListIterator<E> iter = listIterator();

		while (iter.hasNext()) {
			if (iter.next().equals(element)) {
				return true;
			}
		}
		return false;
	}

	public E set(int index, E element) {
		ListIterator<E> iter = listIterator();
		int count = 0;

		E ret = get(index);

		while (iter.hasNext()) {
			if (count == index) {
				iter.add(element);
				iter.next();
				iter.remove();

				return ret;
			}
			iter.next();
			count++;
		}
		return null;
	}

	public int size() {
		ListIterator<E> iter = listIterator();
		int count = 0;

		while (iter.hasNext()) {
			iter.next();
			count++;
		}
		return count;
	}

	public String toString() {
		ListIterator<E> iter = listIterator();
		String list = "";
		while (iter.hasNext()) {
			list += iter.next().toString() + ", ";
		}
		return "" + list;
	}

	public ListIterator<E> listIterator() {
		return new LinkedListIterator();
	}

}
