package priorityQueues;

public class PQTestRunner {

	public static void main(String[] args) {
		String test = "one two three four five six seven";
		String test2 = "1 2 3 4 5 one two three four five";
		String test3 = "a p h j e f m c i d k l g n o b";
		
		PQTester pq = new PQTester(test);
		System.out.println(pq.toString());
		System.out.println(pq.getMin());
		System.out.println(pq.getNaturalOrder());
		System.out.println("----------------------------------------------");
		
		PQTester pq2 = new PQTester(test2);
		System.out.println(pq2.toString());
		System.out.println(pq2.getMin());
		System.out.println(pq2.getNaturalOrder());
		System.out.println("----------------------------------------------");
		
		PQTester pq3 = new PQTester(test3);
		System.out.println(pq3.toString());
		System.out.println(pq3.getMin());
		System.out.println(pq3.getNaturalOrder());
	}

}
