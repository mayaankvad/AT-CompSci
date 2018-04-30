package teamSet;

import java.util.HashMap;

@SuppressWarnings("unused")
public class TeamMap {

	private HashMap<Integer, TeamSet> data;

	public TeamMap() {
		this.data = new HashMap<Integer, TeamSet>();
	}

	public boolean add(Wrestler w) {
		int group = w.getGroup();

		if (!this.data.containsKey(group)) {
			this.data.put(group, new TeamSet());
		}
		return this.data.get(group).add(w);
	}

	public boolean add(String name, int weight) {
		return this.add(new Wrestler(name, weight));
	}

	public int getGroup(Wrestler w) {
		return w.getGroup();
	}

	public void changeWeightGroup(Wrestler w, int g) {
		this.data.get(w.getGroup()).remove(w);
		w.changeGropup(g);
		this.add(w);
	}

	public String toString() {
		//this.removeEmpty();
		this.showEmpty();
		return this.data.toString();
	}

	/**
	 * Adds empty groups from {min} to {max} if they 
	 * do not exist. 
	 */
	private void showEmpty() {
		final int min = 0;
		final int max = 9;
		
		for(int i = min; i <= max; i++) {
			if (!this.data.containsKey(i)) {
				this.data.put(i, new TeamSet());
			}
		}
	}
	
	/**
	 * removes all groups that are either null or empty
	 */
	private void removeEmpty() {

		java.util.HashSet<Integer> keys = new java.util.HashSet<Integer>();

		for (Integer k : this.data.keySet()) {
			TeamSet s = this.data.get(k);

			if (s != null) {
				if (s.isEmpty()) {
					keys.add(k);
				}
			} else {
				keys.add(k);
			}
		}

		for (Integer k : keys) {
			this.data.remove(k);
		}

	}

}