package textbook;

public class Tester {
	
	public static void main(String[] args) {
		LinkedList<String> a = new LinkedList<String>();
		a.add("one");
		a.add("two");
		a.add("three");
		a.add("four");
		a.add("five");
		
		
		System.out.println(a.size());
		System.out.println(a.contains("one"));
		System.out.println(a.contains("c"));
		
		//a.clear();
		
		System.out.println(a);
		a.add(3, "Hi");
		System.out.println(a);
		a.addLast("var");
		a.addFirst("11");
		System.out.println(a);
		
		System.out.println(a.get(2));
		System.out.println(a.getFirst());
		System.out.println(a.getLast());
		
		a.remove("var");
		System.out.println(a.removeLast());
		System.out.println(a);
		
		
		
		
	}

}
