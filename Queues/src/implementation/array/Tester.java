package implementation.array;

public class Tester {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		for (int k = 1; k <= 5; k++)
			queue.offer(new Integer(k));
		
		ArrayQueue queue2 = new ArrayQueue();
		for (int k = 11; k <= 15; k++)
			queue2.offer(new Integer(k));
		
		ArrayQueue queue3 = new ArrayQueue();
		for (int k = 21; k <= 27; k++)
			queue3.offer(new Integer(k));
		
		System.out.println(queue2);
		System.out.println(queue3);
//		
//		queue.append(queue3);
//		System.out.println(queue);
//		
//		
//		while (!queue.empty()) {
//			System.out.print(queue.poll() + " ");
//		}
//		System.out.println();
//		
		
		ArrayQueue queue4 = queue3.alternate(queue2);
		System.out.println("Alternate");
		System.out.println(queue4);
		ArrayQueue queue5 = queue3.alternate(queue2);
		System.out.println("Alternate");
		System.out.println(queue4);
	}

}
