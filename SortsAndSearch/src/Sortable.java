import java.util.Random;

public abstract class Sortable {

	protected int[] nos;
	protected int steps;

	/** Constructs a default array of size 10 */
	public Sortable() {
		nos = new int[10];
		nos[0] = -10001;
		nos[1] = 3;
		nos[2] = 7;
		nos[3] = 19;
		nos[4] = 15;
		nos[5] = 19;
		nos[6] = 7;
		nos[7] = 3;
		nos[8] = 19;
		nos[9] = -100;

	}

	public Sortable(int[] temp) {
		nos = temp;
	}

	/** Constructs an array with size random Sorts from [0,range) */
	public Sortable(int size, int range) {
		this(size, range, new Random().nextInt());
	}

	/** Constructs an array of random Sorts [0-range) array of size count with a
	 * seed
	 * The seed allows you to use the same set of random numbers */
	public Sortable(int count, int range, long seed) {
		nos = new int[count];
		Random r = new Random(seed);
		
		for(int i =0; i < count; i++) {
			nos[i] = r.nextInt(range);
		}
	}

	/** This constructor will create an ordered array of consecutive integers
	 *  true will yield ascending order
	 *  false will yield descending order */
	public Sortable(int count, boolean ordered) {
		nos = new int[count];
		
		for(int i = 0; i < count; i++) {
			if(ordered) {
				nos[i] = i;
			}
			else {
				nos[i] = count -i;
			}
		}
	
	}

	public int getSteps() {
		return steps;
	}

	public void display() {
		for (int x : nos)
			System.out.print(x + " ");
		System.out.println();
	}

	public int[] getNos() {
		return nos;
	}

	public abstract void sort();

}
