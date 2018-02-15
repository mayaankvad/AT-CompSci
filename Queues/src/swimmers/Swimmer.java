package swimmers;

public class Swimmer implements Comparable<Swimmer> {

	private int height;
	private int weight;
	private int age;
	
	public Swimmer() {
		this(0, 0, 0);
	}
	
	public Swimmer(int ht, int wt, int age) {
		this.setHeight(ht);
		this.setWeight(wt);
		this.setAge(age);
	}

	
	public boolean equals(Swimmer o) {
		return this.height == o.height && this.weight == o.weight && this.age == o.age;
	}
	
	
	@Override
	public int compareTo(Swimmer o) {
		if(o.equals(this)) {
			return 0;
		}
		
		return 0;
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
