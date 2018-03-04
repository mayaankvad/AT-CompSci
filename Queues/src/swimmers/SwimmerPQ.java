package swimmers;

import java.util.PriorityQueue;

public class SwimmerPQ {
	private PriorityQueue<Swimmer> pQueue;

	public SwimmerPQ() {
		this.pQueue = new PriorityQueue<Swimmer>();
	}

	public void add(Swimmer obj) {
		this.pQueue.offer(obj);
	}

	public Object getMin() {
		return this.pQueue.peek();
	}

	public Object removeMin() {
		return this.pQueue.poll();
	}

	public String getNaturalOrder() {
		PriorityQueue<Swimmer> q = new PriorityQueue<Swimmer>(pQueue);

		String output = "";

		while (!q.isEmpty())
			output += q.remove() + ",  ";
		return output;
	}

	// write a toString method
	public String toString() {
		return this.pQueue.toString();
	}

}
