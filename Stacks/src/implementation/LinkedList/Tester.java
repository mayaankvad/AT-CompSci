package implementation.LinkedList;

public class Tester {

	public static void main(String[] args) {
		test();
//Stack x = new Stack();
//x.push(1);x.push(2);x.push(3);
//System.out.println(x);
	}

	static void test() {
		Stack<String> tc = new Stack<String>();
		System.out.println(tc.push("quarter"));
		System.out.println(tc.push("dime"));
		System.out.println(tc.push("nickel"));
		System.out.println(tc.push("penny"));
		System.out.println("toString() " + tc);
		System.out.println("peek() " + tc.peek());
		System.out.println("search for dime " + tc.search("dime"));
		System.out.println("search for euro " + tc.search("euro"));
		System.out.println("Size " + tc.size());
		System.out.println("pop() and isEmpty()");
		while (!tc.isEmpty())
			System.out.println(tc.pop());
	}

}
