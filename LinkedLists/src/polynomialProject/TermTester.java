package polynomialProject;

public class TermTester {
	public static void main(String[] args) throws Exception {
		Term p = new Term(3, 5);
		Term q = new Term(2, 5);
		Term r = new Term(4, 6);

		// System.out.println(p.add(q));
		//System.out.println(q.multiply(r));

		//System.out.println(p.compareTo(r));

		Polynomial one = new Polynomial();
		one.addTerm(1, 2);
		one.addTerm(2, 1);
		one.addTerm(3, 0);
		
		Polynomial two = new Polynomial();
		two.addTerm(1, 2);
		two.addTerm(2, 1);
		two.addTerm(3, 0);
		
//		one.addTerm(7, 8);
//		one.addTerm(4, 7);
//		one.addTerm(4, 6);
//		one.addTerm(2, 5);
//		one.addTerm(3, 5);
//		
//		one.addTerm(4, 6);
//		one.addTerm(4, 6);
//		one.addTerm(3, 6);
//		one.addTerm(1, 6);
		
		//System.out.println(one);
		
		System.out.println(one.multiply(two));

	}
}
