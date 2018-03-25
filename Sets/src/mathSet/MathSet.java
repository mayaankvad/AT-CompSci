package mathSet;

import java.util.Set;
import java.util.TreeSet;

public class MathSet {
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet() {
		this(null, null);
	}

	public MathSet(String o, String t) {
		this.one = new TreeSet<Integer>();
		this.two = new TreeSet<Integer>();

		for (String s : o.split(" ")) {
			this.one.add(Integer.valueOf(s));
		}
		
		for (String s : t.split(" ")) {
			this.two.add(Integer.valueOf(s));
		}

	}

	public Set<Integer> union() {
		TreeSet<Integer> union = new TreeSet<Integer>();
		union.addAll(this.one);
		union.addAll(this.two);
		return union;
	}

	public Set<Integer> intersection() {
		TreeSet<Integer> in = new TreeSet<Integer>(this.one);
		in.retainAll(this.two);
		return in;
	}

	public Set<Integer> differenceAMinusB() {
		TreeSet<Integer> diff = new TreeSet<Integer>(this.one);
		diff.removeAll(this.two);
		return diff;
	}

	public Set<Integer> differenceBMinusA() {
		TreeSet<Integer> diff = new TreeSet<Integer>(this.two);
		diff.removeAll(this.one);
		return diff;
	}

	public Set<Integer> symmetricDifference() {
		TreeSet<Integer> sym = new TreeSet<Integer>();

		for (Integer i : one) {
			if (!two.contains(i)) {
				sym.add(i);
			}
		}
		
		for (Integer i : two) {
			if (!one.contains(i)) {
				sym.add(i);
			}
		}

		return sym;
	}

	public String toString() {
		return "Set one " + one + "\n" + "Set two " + two + "\n";
	}
}
