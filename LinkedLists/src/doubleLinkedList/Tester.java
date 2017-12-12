package doubleLinkedList;

public class Tester {

	public static void main(String[] args) {
		
		/*java.util.LinkedList<Integer> l = new java.util.LinkedList<Integer>();
		
		l.add(1);l.add(3);l.add(5);l.add(7);
		System.out.println(l);
		
		java.util.ListIterator<Integer> li = l.listIterator();
		li.next();
		li.add(100);
		System.out.println(li.next());*/
		
		
		
		
		
		
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		System.out.println(list.isEmpty());
		
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(1);
		list.addLast(10);
		list.addLast(21);
		list.addLast(31);
		list.addLast(12);
		
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		list.removeFirst();
		list.removeLast();
		System.out.println(list.size());
		System.out.println(list);
		
		
	
		
		list.removeFirst();
		list.removeFirst();
		list.removeLast();

		System.out.println(list);
		System.out.println(list.size());

		ListIterator ite = list.iterator();
		ite.next();
		ite.remove();
		
		ite.set(99889);
		
		
		System.out.println("> " + list);
//		list.addLast(1001001);  //  ..doesnt work... too lazy
		// System.out.println(list); //  ..doesnt work... too lazy
		

	}

}