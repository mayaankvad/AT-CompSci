package studentGradeMap.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGrades {

	private static final Scanner scn = new Scanner(System.in);

	/**
	 * Prints the options menu and returns the letter that the user types does
	 * not check for invalid selection
	 * 
	 * @return the next token on the input stream
	 */
	public static String printMenuAndGetChoice() {

		System.out.println("\n\n----- Menu -----\n" + "1) print grades \n" + "2) modify student \n"
				+ "3) remove student \n" + "4) add student \n");

		System.out.print("Choice: ");
		return scn.nextLine();
	}

	/**
	 * Prints the students and grades
	 * 
	 * @param gradeMap
	 *            the map to print
	 */
	public static void printGrades(Map<String, String> gradeMap) {
		for (Map.Entry<String, String> o : gradeMap.entrySet()) {
			System.out.println(o.getKey() + " : " + o.getValue());
		}
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid
	 * student is modified
	 * 
	 * @param gradeMap
	 *            the map to modify
	 */
	public static void modifyStudent(Map<String, String> gradeMap) {

		System.out.print("Enter name: ");
		String name = scn.next();

		if (!gradeMap.containsKey(name)) {
			System.err.println(name + " not found");
			return;
		}

		System.out.println("Current Grade: " + gradeMap.get(name));
		System.out.print("Change to: ");
		String grade = scn.next().toUpperCase();

		if (!grade.matches("A|A+|A-|B|B+|B-|C|C+|C-|D|D+|D-|F")) {
			System.err.println(grade + ": Invalid grade");
			return;
		}

		gradeMap.put(name, grade);
		System.out.println("Grade Changed");

	}

	/**
	 * Removes a student from the map based on user input
	 * 
	 * @param gradeMap
	 *            the map to remove the student from
	 */
	public static void removeStudent(Map<String, String> gradeMap) {

		System.out.print("Enter name: ");
		String name = scn.next();

		if (gradeMap.remove(name) != null) {
			System.out.println("Student Removed");
		} else {
			System.out.println("Student Does Not Exist");
		}

	}

	/**
	 * Adds a student based on user input. Prints an error if a student is added
	 * that already exists in the map.
	 * 
	 * @param gradeMap
	 *            the map to add the student to
	 */
	public static void addStudent(Map<String, String> gradeMap) {

		System.out.print("Enter name: ");
		String name = scn.nextLine();

		if (gradeMap.get(name) != null) {
			System.err.println("Student Already Exists");
			return;
		}

		System.out.print("Enter grade: ");
		String grade = scn.nextLine().toUpperCase();

		if (!grade.matches("A|A+|A-|B|B+|B-|C|C+|C-|D|D+|D-|F")) {
			System.err.println(grade + ": Invalid grade");
			return;
		}

		gradeMap.put(name, grade);

	}

	public static void main(String[] args) {

		HashMap<String, String> data = new HashMap<String, String>();

		for (;;) {
			String s = printMenuAndGetChoice();

			switch (s) {
			case "1":
				printGrades(data);
				break;
			case "2":
				modifyStudent(data);
				break;
			case "3":
				removeStudent(data);
				break;
			case "4":
				addStudent(data);
				break;
			default:
				System.err.println("Invalid Choice");
				break;
			}
		}

	}

}
