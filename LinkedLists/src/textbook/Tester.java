package textbook;

public class Tester {

	public static void main(String[] args) {
		LinkedList<String> a = new LinkedList<String>();
		a.add("one");
		a.add("two");
		a.add("three");
		a.add("four");
		a.add("five");
		System.out.println(a);

		System.out.println(a.get(2));
		a.set(2, "243523452435");
		System.out.println(a);
		//
		// System.out.println(a.size());
		// System.out.println(a.contains("one"));
		// System.out.println(a.contains("c"));
		//
		// //a.clear();
		//
		// System.out.println(a);
		// a.add(3, "Hi");
		// System.out.println(a);
		// a.addLast("var");
		// a.addFirst("11");
		// System.out.println(a);
		//
		// System.out.println(a.get(2));
		// System.out.println(a.getFirst());
		// System.out.println(a.getLast());
		//
		// a.remove("var");
		// System.out.println(a.removeLast());
		// System.out.println(a);
		//
		//

		// ======

		LinkedList<String> names = new LinkedList<String>();
		names.addFirst("Tom");
		names.addFirst("Romeo");
		names.addFirst("Harry");
		names.addFirst("Dick");

		// //names.reverse();
		// ListIterator iter = names.listIterator();
		// while (iter.hasNext())
		// System.out.print(iter.next() + " ");
		// System.out.println();
		// //System.out.println("Expected: Tom Romeo Harry Dick");

	}

}
