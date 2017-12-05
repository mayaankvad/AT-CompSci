package worksheet1;

import java.util.LinkedList;
import java.util.ListIterator;

public class JavaLinkedList {

	private LinkedList<Integer> list;

	public JavaLinkedList() {
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums) {
		list = new LinkedList<Integer>();
		for (int num : nums) {
			list.add(num);
		}
	}

	public double getSum() {
		double total = 0;

		ListIterator<Integer> iter = list.listIterator();
		while (iter.hasNext()) {
			total += iter.next();
		}

		return total;
	}

	public double getAvg() {
		return ((double) getSum()) / size();
	}

	public Integer getLargest() {
		if (size() == 0) {
			return null;
		}

		ListIterator<Integer> iter = list.listIterator();
		int largest = iter.next();

		while (iter.hasNext()) {
			int test = iter.next();
			largest = (test > largest) ? test : largest;
		}

		return largest;
	}

	public Integer getSmallest() {
		if (size() == 0) {
			return null;
		}

		ListIterator<Integer> iter = list.listIterator();
		int smallest = iter.next();

		while (iter.hasNext()) {
			int test = iter.next();
			smallest = (test < smallest) ? test : smallest;
		}

		return smallest;
	}

	public int size() {
		int counter = 0;

		ListIterator<Integer> iter = list.listIterator();
		while (iter.hasNext()) {
			counter++;
			iter.next();
		}

		return counter;
	}

	public String toString() {
		return ("SUM:: " + getSum() + "\n" + "AVERAGE:: " + getAvg() + "\n" + "SMALLEST:: " + getSmallest() + "\n"
				+ "LARGEST:: " + getLargest() + "\n");
	}

}