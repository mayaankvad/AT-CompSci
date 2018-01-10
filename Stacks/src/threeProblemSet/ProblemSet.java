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
		String[] sentences = line.split("\\.");

		for (String sentence : sentences) {

			String[] words = sentence.split(" ");
			Stack<String> s = new Stack<String>();

			for (String word : words) {
				s.add(word);
			}

			while (!s.isEmpty()) {
				System.out.print(" " + s.pop());
			}
			System.out.print(".");
		}

		System.out.println();
	}

	public static void driveway() {
		final Scanner scn = new Scanner(System.in);

		Stack<Integer> street = new Stack<Integer>();
		Stack<Integer> driveway = new Stack<Integer>();

		int license;
		
		do {

			System.out.print("Enter Licence #: ");
			license = scn.nextInt();

			// add car
			if (license > 0) {
				driveway.add(license);
			}

			// remove car
			if (license < 0) {

				// find car
				while (!driveway.isEmpty()) {

					if (driveway.peek() == -license) {
						driveway.pop();
						break;
					} else {
						street.add(driveway.pop());
					}

				}

				while (!street.isEmpty()) {
					driveway.add(street.pop());
				}

			}

			System.out.println("Driveway: " + driveway);

		} while (license != 0);

		System.out.println("- END -");
		scn.close();
	}

	public static void main(String[] args) {
		reverseDigits(123456);
		reverseSentences("Marry had a little lamb. Its fleece was white as snow.");
		System.out.println();
		driveway();
	}

}
