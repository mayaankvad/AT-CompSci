package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class HashSet implements Collection, Iterable {

	private LinkedList<Object>[] data;
	private int size;

	public HashSet() {
		this(100);
	}

	public HashSet(int capacity) {
		this.data = new LinkedList[capacity];
	}

	public HashSet(Collection c) {
		this();
		this.addAll(c);
	}

	private static int hash(Object o) {
		// if the object declares its own hashCode, use it
		// (not the one from object)
		try {
			o.getClass().getDeclaredMethod("hashCode");
			return o.hashCode();
		} catch (Exception e) {

		}

		// use this only if object does not have its own hashCode method
		String s = o.toString();

		int seed = s.length();
		Random r = new Random(seed);

		int hash = 0;
		for (char c : s.toCharArray()) {
			hash += (((int) c) * r.nextInt(150)) % 31;
		}
		return hash;
	}

	public boolean contains(Object o) {
		int h = hash(o);
		LinkedList x = this.data[h % this.data.length];
		if (x == null) {
			return false;
		}
		return x.contains(o);
	}

	public boolean add(Object o) {
		resize();

		if (this.contains(o)) {
			return false;
		}

		int h = hash(o);

		if (this.data[h % this.data.length] == null) {
			this.data[h % this.data.length] = new LinkedList();
		}

		this.data[h % this.data.length].add(o);
		return true;
	}

	public boolean remove(Object o) {
		if (!this.contains(o)) {
			return false;
		}

		int h = hash(o);
		LinkedList x = this.data[h % this.data.length];

		this.size--;
		return x.remove(o);
	}

	public void resize() {

		if ((((double) this.size) / this.data.length) < 0.75) {
			return;
		}

		HashSet n = new HashSet(this.data.length * 2);

		for (LinkedList ll : this.data) {
			for (Object o : ll) {
				n.add(o);
			}
		}

		this.size = n.size;
		this.data = n.data;
	}

	public String toString() {
		String res = "";
		for (LinkedList ll : this.data) {
			if (ll != null) {
				for (Object o : ll) {
					res += o + ", ";
				}
			}
		}
		return res;
	}

	@Override
	public void clear() {
		this.data = new LinkedList[100];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		ArrayList<Object> li = new ArrayList<Object>();
		for (Object o : this) {
			li.add(o);
		}
		return li.toArray();
	}

	// ===

	public boolean addAll(Collection c) {
		for (Object o : c) {
			this.add(o);
		}
		return true;
	}

	/*
	 * removes from this collection all of its elements that are not contained in
	 * the specified collection.
	 */
	public boolean retainAll(Collection c) {
		for (Object o : this) {
			if (!c.contains(o)) {
				this.remove(o);
			}
		}
		return true;
	}

	/*
	 * Removes from this set all of its elements that are contained in the specified
	 * collection
	 */
	public boolean removeAll(Collection c) {
		for (Object o : this) {
			if (c.contains(o)) {
				this.remove(o);
			}
		}
		return true;
	}

	// ===

	@Override
	public Iterator iterator() {

		ArrayList<Object> li = new ArrayList<Object>();

		for (LinkedList ll : this.data) {
			if (ll != null) {
				for (Object o : ll) {
					li.add(o);
				}
			}
		}

		return li.iterator();
	}

	// === unchecked methods

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return a;
	}

}
