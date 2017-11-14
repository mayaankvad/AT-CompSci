package polynomialProject;

public class Term implements Comparable<Term> {

	private int coefficient;
	private int power;

	public Term(int coefficient, int power) {
		this.setCoefficient(coefficient);
		this.setPower(power);
	}

	public Term add(Term o) {
		return new Term(this.coefficient + o.coefficient, this.power);
	}

	public Term subtract(Term o) {
		return new Term(this.coefficient - o.coefficient, this.power);
	}

	public Term multiply(Term o) {
		int constant = this.coefficient * o.coefficient;
		int power = this.power + o.power;
		return new Term(constant, power);
	}

	public Term derivative() {
		int constant = this.coefficient * this.power;
		int power = this.power - 1;
		return new Term(constant, power);
	}

	public String toString() {
		return "" + this.coefficient + "x^" + this.power;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int compareTo(Term t) {
		if (this.power > t.power) {
			return -1;
		}
		if (this.power == t.power) {
			if (this.coefficient < t.coefficient) {
				return -1;
			}
		}
		return 1;
	}

}
