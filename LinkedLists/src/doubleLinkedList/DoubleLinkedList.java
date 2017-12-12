package doubleLinkedList;

public class DoubleLinkedList<E> {

	private class DoubleListNode {
		private E value;
		private DoubleListNode next;
		private DoubleListNode previous;

		public DoubleListNode(E element, DoubleListNode next, DoubleListNode previous) {
			this.value = element;
			this.next = next;
			this.previous = previous;
		}

	}

	@SuppressWarnings("unused")
	private class DoubleListIterator implements ListIterator<E>{
		private DoubleListNode current;
		private DoubleListNode previous;
		//private boolean canRemove; // for remove() method. true if OK to call

		
		public DoubleListIterator() {
			current = first;///?
		}
		
		public boolean hasPrevious() {
			return first != current;
		}

		public boolean hasNext() {
			//System.err.println(current != null);
			return current != null;
		}

		public E next() {
			if(!hasNext())
				return null;
			previous  = current;
			current = current.next;
			return previous.value;
		}

		public E previous() {
			if(hasPrevious()){
				if(current == null){
					current = last;
					previous = current;
					return current.value;
				}
					
				current = current.previous;
				previous = current;
				return current.value;
			}		
			
			return null;
		}

		public void remove() {
			//if (canRemove) {
				if (hasPrevious()) {
					//current = previous.next;
					previous.next = current.next;
					
					if(current.next !=  null) {
						current.next.previous = previous;
					}
					current = current.next;
				} else {
					previous = null;
				}
			//}
		}

		
		public void add(E element) {
			
			DoubleListNode node;
			System.err.println(current==null);
			if(current == null) {
				node = new DoubleListNode(element, null, current);
			} else {
				node = new DoubleListNode(element, current.next, current);
			}
			
			
			if(current == first) {
				current.next.previous = node;
				current.next = node;
			}
			else {
				current.next = node;	
//				current.next.previous = node;
			}
			
			
			
			
		}

		public void set(E element) {
			if(current != null) {
				current.value = element;
			}
		}
		
	}

	private DoubleListNode first;
	private DoubleListNode last;

	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return first == null || last == null;
	}

	public void addFirst(E o) {
		if (this.isEmpty()) {
			DoubleListNode node = new DoubleListNode(o, null, null);
			first = node;
			last = node;
		} else {
			DoubleListNode node = new DoubleListNode(o, first, null);
			first.previous = node;
			first = node;
		}
	}

	public void addLast(E o) {
		if (this.isEmpty()) {
			DoubleListNode node = new DoubleListNode(o, null, null);
			first = node;
			last = node;
		} else {
			DoubleListNode node = new DoubleListNode(o, null, last);
			last.next = node;
			last = node;
		}
	}

	public Object removeFirst() {
		DoubleListNode temp = first;
		first = first.next;
		return temp;
	}

	public Object removeLast() {
		DoubleListNode temp = last;
		last.previous.next = null;
		last = last.previous;
		return temp;
	}

	public int size() {
		// int count = 0;
		// DoubleListNode temp = first;
		//
		// while (temp != null) {
		// count++;
		// temp = temp.next;
		// }
		//
		// return count;

		DoubleListIterator iter = this.iterator();
		int size = 0;

		while (iter.hasNext()) {
			size++;
			iter.next();
		}
		return size;
	}

	public void clear() {
		first = null;
		last = null;
	}

	public String toString() {
		DoubleListIterator iter = this.iterator();
		String res = "[";

		while (iter.hasNext()) {
			res += iter.next().toString() + ", ";
		}

		return res + "]";
	}

	public DoubleListIterator iterator() {
		return new DoubleListIterator();
	}

}
