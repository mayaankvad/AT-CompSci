package exercises;

import java.util.LinkedList;
import java.util.ListIterator;

public class Fruits2017 {

	LinkedList<String> bowl; 

	
	public Fruits2017() {
		this.bowl = new LinkedList<String>();
		
		bowl.addLast("apples");
		bowl.addLast("bananas");
		bowl.addLast("cherry");
		
		bowl.addLast("lime");
		bowl.addLast("lemon");
		
		bowl.addLast("orange");
		
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		
		
		bowl.addLast("stuff");
	}
	
	public void displayFruit() {
		System.out.println(bowl);
	}
	
	
	
	public void addAlphabetically(String newFruit) {
		ListIterator<String> iter = bowl.listIterator();
		
		while(iter.hasNext()) {
			if(newFruit.compareTo(iter.next()) < 0) {
				iter.previous();
				iter.add(newFruit);
				return;
			}
		}
	}
	
	
	public void removeLetter(String letter) {
		ListIterator<String> iter = bowl.listIterator();
		
		while(iter.hasNext()) {
			if(iter.next().startsWith(letter)) {
				iter.remove();
			}
		}
	}
	
	public String locate(String word) {
		ListIterator<String> iter = bowl.listIterator();
		
		while(iter.hasNext()) {
			if(iter.next().equalsIgnoreCase(word)) {
				return word + " is indeed in list";
			}
		}
		return word + " is not in list";
	}
	
	
	public LinkedList<String> reverse() {
		ListIterator<String> iter = bowl.listIterator();
		LinkedList<String> rev = new LinkedList<String>();
		
		while(iter.hasNext()) {
			rev.addFirst(iter.next());
		}
		return rev;
		
	}
	
	
	
	
	
	public void displayFruit2() {
		for(String t: bowl) {
			System.out.println(t);
		}
	}
	
	public void displayFruit3() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	public void displayEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			if(iter.hasNext()) iter.next();
		}
	}
	
	public void removeEveryOtherFruit() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
			if(iter.hasNext()) iter.next();
		}
	}
	
	
	public void displayReverse() {
		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Fruits2017 one = new Fruits2017();
		
		//one.removeEveryOtherFruit();	
		//one.displayFruit();
		one.displayFruit();
		//one.addAlphabetically("baz");
		//one.removeLetter("l");
		//one.displayFruit();
		
		//System.out.println(one.locate("stuff"));
		
		System.out.println(one.reverse());
		
		
	}
	
	
}



/* Finding Nodes:

ListNode list = front;
while ( there are more nodes to check  ) {
	if( a node containing the value was found ) {
		return true;
	}
	mode to the next node;
}
return false;

*/

/* Removing Nodes:

current = front;
previous = current;
current = current.getNext();
previous.setNext(current.getNext());

*/

/*
 
what if the linked list is null?
What if I need to remove the first Node?
How do I process the remaining Nodes?
Do I remove more than one occourance of the same value or just the first one?
*/






