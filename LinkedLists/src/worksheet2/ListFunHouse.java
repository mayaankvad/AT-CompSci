package worksheet2;

import static java.lang.System.*;

public class ListFunHouse {

	// this method will print the entire list on the screen
	public static void print(ListNode list) {

		while (list != null) {
			System.out.print(list.getValue() + ", ");
			list = list.getNext();
		}

	}

	// this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		int count = 0;
		while (list != null) {
			count++;
			list = list.getNext();
		}
		return count;
	}

	// this method will create a new node with the same value as the first node
	// and add this
	// new node to the list. Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) {
		ListNode next = new ListNode(list.getValue(), list.getNext());
		list.setNext(next);
	}

	// this method will create a new node with the same value as the last node
	// and add this
	// new node at the end. Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list) {
		while (list.getNext() != null) {
			list = list.getNext();
		}

		list.setNext(new ListNode(list.getValue(), null));
	}

	// method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
		while (list != null) {
			ListNode next = list.getNext();

			if (next != null) {
				ListNode next2 = next.getNext();
				list.setNext(next2);
			}

			list = list.getNext();
		}
	}

	// this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable<?> value) {
		int count = 1;

		while (list != null) {
			if (count % x == 0) {
				list.setValue(value);
			}
			count++;
			list = list.getNext();
		}
	}

	// this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x) {
		int count = 1;

		while (list != null) {
			ListNode next = list.getNext();

			if (count % x == 0) {
				if (next != null) {
					list.setNext(next.getNext());
				}
			}

			count++;
			list = list.getNext();
		}

	}

}
