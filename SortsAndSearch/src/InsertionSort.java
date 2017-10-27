
public class InsertionSort extends Sortable {

	public InsertionSort() {
		super();
	}
	
	public InsertionSort(int[] temp) {
		super(temp);
	}
	
	public InsertionSort(int count, int range, long seed) {
		super(count, range, seed);
	}
	
	public InsertionSort(int count, boolean ordered) {
		super(count, ordered);
	}
	
	@Override
	public void sort() {
		steps = 0;
		steps++;
		for (int i = 0; i < nos.length - 1; i++) {
			int index = i;
			steps++;
			steps++;
			for (int j = i + 1; j < nos.length; j++) {
				steps++;
				if (nos[j] < nos[index]) {
					steps++;
					index = j;// searching for lowest index
				}
			}
			int smallerNumber = nos[index];
			steps++;
			nos[index] = nos[i];
			steps++;
			nos[i] = smallerNumber;
			steps++;
		}

	}

}
