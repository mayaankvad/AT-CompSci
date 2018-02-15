package transplant;

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
		
		if(this.isEmpty()) {
			this.queue.add(o);
			return;
		}
//		
//		ListIterator<Patient> iter = this.queue.listIterator();
//		
//		while(iter.hasNext()) {
//			
//			Patient p = iter.next();
//			
//			if (o.compareTo(p) == 0) {
//				this.queue.addFirst(o);
//				return;
//			}
//			
//			if(o.compareTo(p) == -1) {
//				iter.previous();
//				this.queue.add(o);
//				
//				return;
//			}
//			
//			
//			
//		}
		
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
