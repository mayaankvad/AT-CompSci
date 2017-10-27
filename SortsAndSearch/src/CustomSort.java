// based off Cycle Sort

// If the element is already at the correct position, do nothing.
// If it is not,write it to its intended position. 
// That position is inhabited by a different element b, which we then have to move to its correct position. 
// This process of displacing elements to their correct positions continues until an element is moved to the original position of nos. 
// This completes a cycle.

public class CustomSort extends Sortable {

	public CustomSort() {
		super();
	}
	
	public CustomSort(int[] temp) {
		super(temp);
	}
	
	public CustomSort(int count, int range, long seed) {
		super(count, range, seed);
	}
	
	public CustomSort(int count, boolean ordered) {
		super(count, ordered);
	}
	
	@Override
	public void sort() {
		
        for (int cycleStart = 0; cycleStart < nos.length - 1; cycleStart++) {
            int val = nos[cycleStart];
 
            // count the number of values that are smaller than val
            // since cycleStart
            int pos = cycleStart;
            for (int i = cycleStart + 1; i <nos.length; i++)
                if (nos[i] < val)
                    pos++;
 
            // there aren't any
            if (pos == cycleStart)
                continue;
 
            // skip duplicates
            while (val == nos[pos])
                pos++;
 
            // put val into final position
            int tmp = nos[pos];
            nos[pos] = val;
            val = tmp;
 
            // repeat as long as we can find values to swap
            // otherwise start new cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < nos.length; i++)
                    if (nos[i] < val)
                        pos++;
 
                while (val == nos[pos])
                    pos++;
 
                tmp = nos[pos];
                nos[pos] = val;
                val = tmp;
            }
        }

	}

}
