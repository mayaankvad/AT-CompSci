package transplant;

public class Patient implements Comparable<Patient> {
	
	private String name;
	private int priority;
	
	public Patient(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	
	@Override
	public int compareTo(Patient o) {
		if(this.priority == o.priority) {
			return 0;
		}
		if(o.priority < this.priority) {
			return -1;
		}
		return 1;
	}

	
	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}
	
	public String toString() {
		return this.name + ":" + this.priority;
	}

}
