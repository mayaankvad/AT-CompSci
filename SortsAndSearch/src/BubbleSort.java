
public class BubbleSort extends Sortable{

	public BubbleSort() {
		super();
	}
	
	public BubbleSort(int[] temp) {
		super(temp);
	}
	
	public BubbleSort(int count, int range, long seed) {
		super(count, range, seed);
	}
	
	public BubbleSort(int count, boolean ordered) {
		super(count, ordered);
	}
	
	@Override
	public void sort() {
		// Consecutive values are compared and swapped if necessary
		steps = 0;
		boolean swapped = true;
		steps++;
		int lastSwap = nos.length - 1;

		steps++;
		int temp = 0;
		steps++;
		steps++; // initialize for loop

		for (int i = 0; i < nos.length; i++) {
			steps += 3; // boundary check, increment,if

			if (swapped) {
				swapped = false;
				steps++;
				steps++; // initialize for loop

				for (int j = 0; j < lastSwap; j++) {
					steps += 3; // boundary check, increment,if
					if (nos[j] > nos[j + 1]) {
						swap(j, j + 1);
						swapped = true;
						steps++;
						temp = j;
						steps++;
					}

				}
				lastSwap = temp;
				steps++;
			}

		}

	}
	
	public void swap(int x, int y) {
		int temp = nos[x];
		nos[x] = nos[y];
		nos[y] = temp;
		steps += 3;
	}

}
