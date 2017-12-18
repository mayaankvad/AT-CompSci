package circular;

public class CircularLinkedList {

	class Node {
		public Object data;
		public Node next;

		public Node() {

		}

		public Node(Object d, Node n) {
			data = d;
			next = n;
		}
	}

	public class Iterator {
		private Node current;

		public Iterator() {
			Node n = last;
			while (n != last) {
				n = n.next;
			}
			current = n;
		}

		public Object next() {
			current = current.next;
			return current.data;
		}

		public void add(Object e) {
			Node n = new Node();
			n.data = e;

			if (isEmpty()) {
				addFirst(e);
			} else {
				n.next = current.next;
				current.next = n;
			}
		}

		public Object remove() {
			if (current != null) {

				Node n = last;
				while (n.next != current) {
					n = n.next;
				}

				Node ret = current;
				n.next = current.next;
				current = current.next;
				return ret.data;
			}
			return null;
		}

		public void set(Object e) {
			current.data = e;
		}

	}

	private Node last;

	public void addFirst(Object element) {

		if (last == null) {
			last = new Node();
			last.data = element;
			last.next = last;
		} else {
			Node search = last.next;
			while (search != last) {
				search = search.next;
			}

			search.next = new Node(element, search.next);
		}

	}

	public void addLast(Object element) {
		if (last == null) {
			last = new Node();
			last.data = element;
			last.next = last;
		} else { //
			Node sleepDeprivation = new Node();
			sleepDeprivation.data = element;
			sleepDeprivation.next = last.next;
			last.next = sleepDeprivation;
			last = sleepDeprivation;
		}
	}

	public Object getFirst() {
		Node n = last;
		while (n != last) {
			n = n.next;
		}
		return n.data;
	}

	public Object getLast() {
		return last.data;
	}

	public boolean isEmpty() {
		return last == null;
	}

	public void clear() {
		last = null;
	}

	public Iterator iterator() {
		return new Iterator();
	}

	public String toString() {
		String list = "";

		Node temp = last.next;

		while (temp != last) {
			list += temp.data.toString() + ", ";
			temp = temp.next;
		}

		return list + last.data + ", ";
	}

}
