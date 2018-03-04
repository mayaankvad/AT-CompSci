import java.util.Arrays;

public class MinHeapPQ {

	private int size;
	private int[] minHeap;
	
	public MinHeapPQ() {
		this.minHeap = new int[20];
		this.minHeap[0] = -1000000;
	}
	
	
	public int parent(int child) {
		return child/2;
	}
	
	public void swap(int pos1, int pos2) {
		int temp = minHeap[pos1];
		minHeap[pos1] = minHeap[pos2];
		minHeap[pos2] = temp;
	}
	
	public int leftChild(int parent) {
		return parent * 2;
	}
	
	public int rightChild(int parent) {
		return parent * 2 + 1;
	}
	
	public void insert(int newNumber) {
		
		size++;
		minHeap[size] = newNumber;
		int current = size;
		
		while(minHeap[current] < minHeap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

		
	}
	
	
	public int remove() {
		int temp = minHeap[1];
		
		
		minHeap[1] = minHeap[size];
		minHeap[size] = 0;
		size--;

		heapify(1);
		
		return temp;

	}
	
	
	public boolean isLeaf(int n) {
		return leftChild(n) < size;
	}
	
	
	public void heapify(int n) {
		if(leftChild(n) < size) {
			
			int lesserChild = (minHeap[leftChild(n)] < minHeap[rightChild(n)]) ? leftChild(n): rightChild(n);
			
			if(minHeap[n] > minHeap[lesserChild]) {
				swap(n, lesserChild);
				heapify(lesserChild);
			}
			
			
		}
	}
	
	
	public String toString() {
		return Arrays.toString(this.minHeap);
	}
	
	
	
	
	public static void main(String[] args) {
		MinHeapPQ one = new MinHeapPQ();
		//System.out.println(Arrays.toString(one.minHeap));
		one.insert(5);
		one.insert(9);
		one.insert(12);
		

		
		System.out.println(Arrays.toString(one.minHeap));
		one.remove();

		System.out.println(Arrays.toString(one.minHeap));
		
	}
	
	
}

