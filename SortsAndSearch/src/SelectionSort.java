
public class SelectionSort extends Sortable {

	public SelectionSort() {
		super();
	}
	
	public SelectionSort(int[] temp) {
		super(temp);
	}
	
	public SelectionSort(int count, int range, long seed) {
		super(count, range, seed);
	}
	
	public SelectionSort(int count, boolean ordered) {
		super(count, ordered);
	}
	
	@Override
	public void sort() {
		steps= 0;
	 	steps++;
        for (int i = 0; i < nos.length - 1; i++) {  
            int index = i;  steps++;
            steps++;
            for (int j = i + 1; j < nos.length; j++){  
            	steps++;
            	if (nos[j] < nos[index]){  
            		steps++;
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = nos[index];   steps++;
            nos[index] = nos[i];  steps++;
            nos[i] = smallerNumber;  steps++;
        }  
		
	}

}
