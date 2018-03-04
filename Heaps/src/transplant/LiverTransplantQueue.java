package transplant;

import java.util.Arrays;

public class LiverTransplantQueue {
	
	private int size;
	private Patient[] minHeap;
	
	public LiverTransplantQueue() {
		this.minHeap = new Patient[20];
		this.minHeap[0] = new Patient(null, -100000);
	}
	
	public int size() {
		return size;
	}
	
	public int parent(int child) {
		return child/2;
	}
	
	public void swap(int pos1, int pos2) {
		Patient temp = minHeap[pos1];
		minHeap[pos1] = minHeap[pos2];
		minHeap[pos2] = temp;
	}
	
	public int leftChild(int parent) {
		return parent * 2;
	}
	
	public int rightChild(int parent) {
		return parent * 2 + 1;
	}
	
	public void add(Patient p) {
		
		size++;
		minHeap[size] = p;
		int current = size;
		
		while(minHeap[current] .compareTo( minHeap[parent(current)] ) == -1 ) {
			swap(current, parent(current));
			current = parent(current);
		}

		
	}
	
	
	public Patient poll() {
		Patient temp = minHeap[1];
		
		
		minHeap[1] = minHeap[size];
		minHeap[size] = null;
		size--;

		heapify(1);
		
		return temp;

	}
	
	
	public boolean isLeaf(int n) {
		return leftChild(n) < size;
	}
	
	
	public void heapify(int n) {
		if(leftChild(n) < size) {
			
			int lesserChild = (minHeap[leftChild(n)] .compareTo( minHeap[rightChild(n)] ) == -1) ? leftChild(n): rightChild(n);
			
			if(minHeap[n] .compareTo( minHeap[lesserChild] ) == 1) {
				swap(n, lesserChild);
				heapify(lesserChild);
			}
			
			
		}
	}
	
	
	public String toString() {
		return Arrays.toString(this.minHeap);
	}
	
	
	
}
