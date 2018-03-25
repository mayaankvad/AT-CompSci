package mathSet;

import implementation.HashSet;

public class MathSetUsingCustomSet {
	private HashSet one;
	private HashSet two;

	public MathSetUsingCustomSet() {
		this(null, null);
	}

	public MathSetUsingCustomSet(String o, String t) {
		this.one = new HashSet();
		this.two = new HashSet();

		for (String s : o.split(" ")) {
			this.one.add(Integer.valueOf(s));
		}
		
		for (String s : t.split(" ")) {
			this.two.add(Integer.valueOf(s));
		}

	}

	public HashSet union() {
		HashSet union = new HashSet();
		union.addAll(this.one);
		union.addAll(this.two);
		return union;
	}

	public HashSet intersection() {
		HashSet in = new HashSet(this.one);
		in.retainAll(this.two);
		return in;
	}

	public HashSet differenceAMinusB() {
		HashSet diff = new HashSet(this.one);
		diff.removeAll(this.two);
		return diff;
	}

	public HashSet differenceBMinusA() {
		HashSet diff = new HashSet(this.two);
		diff.removeAll(this.one);
		return diff;
	}

	public HashSet symmetricDifference() {
		HashSet sym = new HashSet();

		for (Object i : one) {
			if (!two.contains(i)) {
				sym.add(i);
			}
		}
		
		for (Object i : two) {
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
