package schoolClub;

public class Student implements Comparable<Student> {

	private String first;
	private String last;
	private String id;

	
	public Student(String first, String last, String id) {
		this.first = first;
		this.last = last;
		this.id = id;
	}
	
	
	
	
	@Override
	public int compareTo(Student o) {
		if(this.last.equalsIgnoreCase(o.last)) {
			return this.first.toLowerCase().compareTo(o.first.toLowerCase());
		}
		return this.last.toLowerCase().compareTo(o.last.toLowerCase());
	}

	
	
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
