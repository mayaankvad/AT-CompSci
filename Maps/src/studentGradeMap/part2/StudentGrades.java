package studentGradeMap.part2;

import java.util.TreeMap;
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
	public static void printGrades(Map<Student, String> gradeMap) {
		for (Map.Entry<Student, String> o : gradeMap.entrySet()) {
			System.out.println(o.getKey() + " : " + o.getValue());
		}
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid
	 * student is modified
	 * 
	 * @param gradeMap
	 *            the map to modify
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void modifyStudent(Map<Student, String> gradeMap, Map<Integer, Student> idToStudentMap) {
		
		System.out.print("Enter id: ");
		Integer id = Integer.valueOf(scn.nextLine());

		if (!idToStudentMap.containsKey(id)) {
			System.err.println(id + " not found");
			return;
		}
		
		Student key = idToStudentMap.get(id);
		
		System.out.println("Student: \n" + key);
		System.out.println("Current Grade: " + gradeMap.get(key));
		System.out.print("Enter new grade: ");
		String grade = scn.next().toUpperCase();

		if (!grade.matches("A|A+|A-|B|B+|B-|C|C+|C-|D|D+|D-|F")) {
			System.err.println(grade + ": Invalid grade");
			return;
		}
		
		gradeMap.put(key, grade);
		System.out.println("Grade Changed");
	}

	/**
	 * Removes a student from the map based on user input
	 * 
	 * @param gradeMap
	 *            the map to remove the student from
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void removeStudent(Map<Student, String> gradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.print("Enter id: ");
		Integer id = Integer.valueOf(scn.nextLine());

		if (!idToStudentMap.containsKey(id)) {
			System.err.println(id + " not found");
			return;
		}
		
		Student key = idToStudentMap.get(id);
		
		gradeMap.remove(key);
		idToStudentMap.remove(id);
		System.out.println("Student Deleted");
	}

	/**
	 * Adds a student based on user input. Prints an error if a student is added
	 * that already exists in the map.
	 * 
	 * @param idToGradeMap
	 *            the map to add the student to
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void addStudent(Map<Student, String> idToGradeMap, Map<Integer, Student> idToStudentMap) {

		System.out.print("Enter id: ");
		int id = Integer.valueOf(scn.nextLine());
		System.out.print("Enter first name: ");
		String first = scn.nextLine();
		System.out.print("Enter last name: ");
		String last = scn.nextLine();
		
		Student s = new Student(first, last, id);
		
		if(idToStudentMap.containsKey(id)) {
			System.out.println("Student Already Exists");
			return;
		}
		
		idToStudentMap.put(id, s);
		
		System.out.print("Enter Grade: ");
		String grade = scn.nextLine().toUpperCase();

		if (!grade.matches("A|A+|A-|B|B+|B-|C|C+|C-|D|D+|D-|F")) {
			System.err.println(grade + ": Invalid grade");
			return;
		}

		idToGradeMap.put(s, grade);
		
		System.out.println("Student Added");
	}

	public static void main(String[] args) {

		Map<Student, String> data = new TreeMap<Student, String>();
		Map<Integer, Student> ids = new TreeMap<Integer, Student>();

		for (;;) {
			String s = printMenuAndGetChoice();

			switch (s) {
			case "1":
				printGrades(data);
				break;
			case "2":
				modifyStudent(data, ids);
				break;
			case "3":
				removeStudent(data, ids);
				break;
			case "4":
				addStudent(data, ids);
				break;
			default:
				System.err.println("Invalid Choice");
				break;
			}
		}

	}

}
