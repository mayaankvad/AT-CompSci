package autoParts;

public class Part implements Comparable<Part> {
	private String make, model, rest;
	private int year;

	public Part(String line) {
		String[] list = line.split(" ");
		
		this.rest = "";
		this.year = Integer.valueOf(list[list.length - 1]);
		this.model = list[list.length - 2].trim();
		this.make = list[list.length - 3].trim();

		for (int i = 0; i < list.length - 3; i++) {
			this.rest += list[i].trim() + " ";
		}

	}

	// have to have compareTo if implements Comparable
	public int compareTo(Part rhs) {

		if (make.compareTo(rhs.make) == 0) {
			if (model.compareTo(rhs.model) == 0) {
				if (year == rhs.year) {
					return rest.compareTo(rhs.rest);
				} else {
					return year - rhs.year;
				}
			} else {
				return model.compareTo(rhs.model);
			}
		} else {
			return make.compareTo(rhs.make);
		}

	}
	
	@Override
	public boolean equals(Object o) {
		Part p = (Part) o;
		return this.make.equals(p.make) && this.model.equals(p.model) && this.rest.equals(p.rest) && this.year == p.year;
	}

	public String toString() {
		return this.make + " " + this.model + " " + this.year + " " + this.rest;
	}
}