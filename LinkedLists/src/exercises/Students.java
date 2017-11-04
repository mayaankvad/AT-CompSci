package exercises;

import java.util.LinkedList;

public class Students {

	
	public static void main(String[] args) {
		LinkedList<String> roster = new LinkedList<String>();
		
		roster.addLast("Priya");
		roster.addLast("Dan"); 
		roster.addFirst("Jason");
		roster.add("Vishal");
		roster.addLast("Teja");
		
		System.out.println(roster);
		
		roster.add("Ashay");
		System.out.println(roster);
		
		roster.remove();
		System.out.println(roster);
		
		System.out.println( ("a").compareTo("b") );
		
		
	}
	
}
