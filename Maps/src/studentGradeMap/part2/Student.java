package studentGradeMap.part2;

public class Student implements Comparable<Student>{

	private String firstName;
	private String lastName;
	private Integer id;
	
	public Student(String firstName, String lastName, Integer id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	public Integer getId() {
		return this.id;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.id + " ";
	}
	
	@Override
	public int compareTo(Student arg0) {
		if(this.lastName.compareTo(arg0.lastName) == 0) {
			return this.firstName.compareTo(arg0.firstName);
		}
		return this.lastName.compareTo(arg0.lastName);
	}
	
}
