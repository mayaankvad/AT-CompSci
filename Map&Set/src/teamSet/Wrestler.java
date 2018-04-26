package teamSet;

public class Wrestler {
	
	private String name;
	private int weight;
	private int group;
	
	public Wrestler(String theName, int theWeight)
	{
		name = theName;
		weight = theWeight;
		group = group(weight);
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}
	
	public int getGroup() {
		return group;
	}
	
	public void changeGropup(int g) {
		group = g;
	}
	
	@Override
	public boolean equals(Object o) {
		Wrestler w = (Wrestler) o;
		
		return this.weight == w.weight && this.name.equals(w.name);
	}
	
	@Override
	public String toString() {
		return "(" + name + " " + weight + ")";
	}
	
	public static int group(int weight) {
		if(weight >= 190) {
			return 9;
		}
		if(weight >= 180) {
			return 8;
		}
		if(weight >= 170) {
			return 7;
		}
		if(weight >= 160) {
			return 6;
		}
		if(weight >= 150) {
			return 5;
		}
		if(weight >= 140) {
			return 4;
		}
		if(weight >= 130) {
			return 3;
		}
		if(weight >= 120) {
			return 2;
		}
		if(weight >= 110) {
			return 1;
		}
		return 0;
	}
	
}
