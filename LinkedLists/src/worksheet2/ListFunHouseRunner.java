package worksheet2;

import java.util.*;
import static java.lang.System.*;

public class ListFunHouseRunner {
	public static void main(String[] args) {
		
		ListNode z = new ListNode("cheese",
				new ListNode("pepperoni", 
				new ListNode("onions", 
				new ListNode("peppers", 
				new ListNode("bacon",
				new ListNode("pineapple", 
				new ListNode("sausage", 
				new ListNode("garlic", null))))))));

		out.println("Worksheet LL#2 Runner\n\n");

		out.println("Original list values\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println("\n");

		out.println("\t num nodes = " + ListFunHouse.nodeCount(z));

		out.println("\nList values after calling nodeCount\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.doubleFirst(z);
		out.println("\nList values after calling doubleFirst\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.doubleLast(z);
		out.println("\nList values after calling doubleLast\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.removeXthNode(z, 2);
		out.println("\nList values after calling removeXthNode(2)\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.setXthNode(z, 2, "PIZZA!");
		out.print("\t");
		out.println("\nList values after calling setXthNode(2,PIZZA!)\n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();
		
		ListFunHouse.skipEveryOther(z);
		out.print("\t");
		out.println("\nList values after calling skipEveryOther() \n");
		out.print("\t");
		ListFunHouse.print(z);
		out.println();
		
	}
}