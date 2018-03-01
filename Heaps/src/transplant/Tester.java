package transplant;

public class Tester {

	public static void main(String[] args) {
		LiverTransplantQueue pq = new LiverTransplantQueue();
		pq.add(new Patient("Smith", 3));
		pq.add(new Patient("Chen", 2));
		pq.add(new Patient("Jones", 3));
		pq.add(new Patient("Wong", 3));
		pq.add(new Patient("Gupta", 2));
		pq.add(new Patient("Garcia", 1));
		pq.add(new Patient("Brown", 5));
		System.out.println("The list is");
		System.out.println(pq);
		while (pq.size() > 0) {
			System.out.println("The next patient for the liver transplant is");
			System.out.println(pq.poll());
		}

	}

}
