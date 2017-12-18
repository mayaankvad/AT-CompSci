package doubleLinkedList;

public class Tester {

	public static void main(String[] args) {
		
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		
		System.out.println("empty?: ");
		System.out.println(list.isEmpty());
		
		list.addFirst("1");
		list.addFirst("2");
		list.addFirst("3");
		list.addLast("4");
		list.addLast("5");
		list.addLast("6");
		list.addLast("7");
		
		System.out.println("list: ");
		System.out.println(list);
		
		System.out.println("size: ");
		System.out.println(list.size());
		
		
		System.out.println("Remove First:");
		System.out.println(list.removeFirst() + " " + list);
		System.out.println("Remove last:");
		System.out.println(list.removeLast() + " " + list);
		System.out.println("size:");
		System.out.println(list.size());
		System.out.println("list:");
		System.out.println(list);

		ListIterator ite = list.iterator();
		ite.next();
		
		System.out.println("adding to middle and replacing:");
		ite.add("add");
		ite.next();
		
		ite.next();
		ite.set("replace");
		System.out.println("list:");
		System.out.println(list + "\nclear");
		
		list.clear();
		
		System.out.println("list:");
		System.out.println(list);
	}

}