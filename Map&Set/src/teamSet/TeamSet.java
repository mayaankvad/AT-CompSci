package teamSet;

import java.util.HashSet;

public class TeamSet {

	private HashSet<Wrestler> data;

	public TeamSet() {
		this.data = new HashSet<Wrestler>();
	}

	public boolean add(Wrestler w) {
		return this.data.add(w);
	}

	public boolean add(String name, int weight) {
		return this.add(new Wrestler(name, weight));
	}

	public boolean remove(Wrestler w) {
		return this.data.remove(w);
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	public double averageWeight() {
		double sum = 0;
		for (Wrestler w : this.data) {
			sum += w.getWeight();
		}
		return sum / this.data.size();
	}

	public HashSet<Wrestler> lightweights() {
		HashSet<Wrestler> res = new HashSet<Wrestler>();

		for (Wrestler w : this.data) {
			if (w.getWeight() < 120) {
				res.add(w);
			}
		}

		return res;
	}

	public String toString() {
		return this.data.toString();
	}

}
