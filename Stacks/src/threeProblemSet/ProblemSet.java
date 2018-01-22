package threeProblemSet;

import java.util.Scanner;
import java.util.Stack;

public class ProblemSet {

	public static void reverseDigits(int number) {
		Stack<Integer> s = new Stack<Integer>();

		while (number > 0) {
			s.push(number % 10);
			number = number / 10;
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		System.out.println();

	}

	public static void reverseSentences(String line) {
		String[] sentences = line.toLowerCase().split("\\.");

		for (String sentence : sentences) {

			String[] words = sentence.trim().split(" ");
			Stack<String> s = new Stack<String>();

			for (String word : words) {
				s.add(word);
			}

			System.out.print(" " + s.peek().substring(0, 1).toUpperCase() + s.pop().substring(1) + " ");
			while (!s.isEmpty()) {
				System.out.print(s.pop());
				
				if (!s.isEmpty()) {
					System.out.print(" ");
				} else {
					System.out.print(".");
				}
			}

		}

		System.out.println();
	}

	public static void driveway() {
		final Scanner scn = new Scanner(System.in);

		Stack<Integer> street = new Stack<Integer>();
		Stack<Integer> driveway = new Stack<Integer>();

		int license;
		
		System.out.println("\n\nPositive numbers add cars, negitive numbers remove, 0 stops the sim.\n");

		do {
			
			System.out.println("driveway: " + driveway);
			System.out.print("Enter Licence #: ");
			license = scn.nextInt();
			
			if(driveway.contains(license)) {
				System.out.println(" Car already exists. ");
				continue;
			}

			// add car
			if (license > 0) {
				driveway.add(license);
			}

			// remove car
			if (license < 0) {
				
				if(!driveway.contains(-license)) {
					System.out.println(" Car does not exist. ");
					continue;
				}

				// find car
				while (!driveway.isEmpty()) {

					if (driveway.peek() == -license) {
						driveway.pop();
						break;
					} else {
						street.add(driveway.pop());
					}
					System.out.println("street: " + street);
					System.out.println("driveway: " + driveway);
				}

				while (!street.isEmpty()) {
					driveway.add(street.pop());
					System.out.println("street: " + street);
					System.out.println("driveway: " + driveway);
				}

			}


		} while (license != 0);

		System.out.println("- END -");
		scn.close();
	}

	public static void main(String[] args) {
		reverseDigits(123456);
		reverseSentences("Marry had a little lamb. Its fleece was white as snow.");
		reverseSentences("My name is Yoda. I am hungry. You are ugly.");
		System.out.println();
		driveway();
	}

}
