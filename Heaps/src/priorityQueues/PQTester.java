package priorityQueues;

import java.util.Queue;
import java.util.PriorityQueue;

public class PQTester {
	private Queue<String> pQueue;

	public PQTester() {
		setPQ("");
	}

	public PQTester(String list) {
		this.pQueue = new PriorityQueue<String>();
		
		for(String s: list.split(" ")) {
			this.pQueue.add(s);
		}
	}

	public void setPQ(String list) {
		this.pQueue = new PriorityQueue<String>();
		for(String s : list.split(" ")){
			this.pQueue.add(s);
		}
	}

	public Object getMin() {
		return pQueue.peek();
	}

	public String getNaturalOrder() {
		String output="";
		while(!pQueue.isEmpty()) {
			output+=pQueue.remove()+ ", ";
		}
		return output;	
	}

	// write a toString method
	public String toString() {
		return this.pQueue.toString();
	}
}
