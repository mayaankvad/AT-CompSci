package transplant;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class LiverTransplantQueue {

	
	private LinkedList<Patient> queue;
	
	public LiverTransplantQueue() {
		this.queue = new LinkedList<Patient>();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
	
	public void add(Patient o) {
		
//		if(this.isEmpty()) {
//			this.queue.add(o);
//			return;
//		}
//		
//		ListIterator<Patient> iter = this.queue.listIterator();
//		
//		while( iter.hasNext() && o.compareTo(iter.next()) == -1 ) {
//
//			
//		}
//		iter.add(o);
		
		queue.add(o);
		Collections.sort(this.queue);
		
	}
	
	public Patient peek() {
		return this.queue.getFirst();
	}
	
	public Patient poll() {
		return this.queue.removeFirst();
	}
	
	public int size() {
		return this.queue.size();
	}
	
	public String toString() {
		return this.queue.toString();
	}
	
	
}
