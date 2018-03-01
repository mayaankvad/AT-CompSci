package transplant;

import java.util.ArrayList;


public class LiverTransplantQueue {

	
	private ArrayList<Patient> heap;
	private int size;
	
	public LiverTransplantQueue() {
		this.heap = new ArrayList<Patient>(90);
	}
	
	public boolean isEmpty() {
		return this.heap.isEmpty();
	}
	
	public void add(Patient o) {
		
		
		size++;
		heap.add(o);

		this.heapify(0);
		
	}
	
	public Patient peek() {
		return this.heap.get(0);
	}
	
	public Patient poll() {
		Patient temp = this.heap.get(0);
		size--;

		//System.out.println(size);
		this.heap.set(0, this.heap.remove(size));
		
		
		
		heapify(0);
		
		return temp;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		return this.heap.toString();
	}
	
	
	public void swap(int a, int b) {
		Patient temp = this.heap.get(a);
		this.heap.set(a, this.heap.get(b));
		this.heap.set(b, temp);
	}
	
	public void heapify(int n) {
		if(size() > 1){
			int min = 0;
			for (int i = 1; i < heap.size(); i++) {
				if (heap.get(i).compareTo( heap.get(min)) < 0)
					min = i;
			}
			heap.add(0, heap.remove(min));
		}
	}
	
	
}
