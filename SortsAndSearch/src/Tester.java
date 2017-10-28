
public class Tester {
	
	public static void main(String[] args) {
	
		
		for(int i = 0; i < 1000; i++) {
			BubbleSort one = new BubbleSort(i, true);
			one.sort();
			System.out.println(i + "\t" + one.getSteps());
		}
		

		
		
	}

}
