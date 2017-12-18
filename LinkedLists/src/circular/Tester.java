package circular;

// http://www.geeksforgeeks.org/circular-singly-linked-list-insertion/

public class Tester {

	public static void main(String[] args) {
		CircularLinkedList li = new CircularLinkedList();
		li.addLast("5");
		li.addFirst("1");
		li.addFirst("2");
		li.addFirst("3");
		li.addFirst("4");

		CircularLinkedList.Iterator ii = li.iterator();

		System.out.println(ii.next());
		System.out.println(ii.next());
		System.out.println(ii.next());

		//
		System.out.println(li.toString());
	}

	
}
