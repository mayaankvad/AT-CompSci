package swimmers;

import java.util.Scanner;

public class SwimmerPQRunner {
	public static void main(String[] args) {
		SwimmerPQ test = new SwimmerPQ();

		Scanner keyboard = new Scanner("8 1 1 1 2 2 2 1 2 3 3 2 1 2 1 3 2 3 1 3 1 2 3 3 3");
		int size = 0;
		System.out.print("How many swimmers did you wish to enter? :: ");
		size = keyboard.nextInt();

		for (int i = 0; i < size; i++) {
			int ht, wt, age;
			System.out.print("\nEnter the ht :: ");
			ht = keyboard.nextInt();
			System.out.print("Enter the wt :: ");
			wt = keyboard.nextInt();
			System.out.print("Enter the age :: ");
			age = keyboard.nextInt();
			test.add(new Swimmer(ht, wt, age));
			System.out.print("\n");
		}

		System.out.println("--------------------------");
		System.out.println();
		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());
		System.out.println();

		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());
		System.out.println();
		System.out.println(test);
	}
}
