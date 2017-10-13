package application;

/**
 *
 * @author mayaankvad
 * @author Bharath Hegde
 */
public class Rational implements Comparable<Rational> {

	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) { 
		
		if(denominator == 0) {
			System.err.println("Denominator cannot be 0. Changed to 1");
			denominator = 1;
		}
		
		if(denominator < 0) {
			denominator *= -1;
			numerator *= -1;
		}
		
		this.denominator = denominator;
		this.numerator = numerator;
		
		this.reduce();
		
	}
	
	public Rational add(Rational r2) {
		
		int cd = r2.getDenominator() * this.denominator;
		
		int n1 = this.numerator * r2.getDenominator();
		int n2 = r2.getNumerator() * this.denominator;
		
		return new Rational(n1 + n2, cd);
		
	}
	
	public Rational subtract(Rational r2) {
			
		int cd = r2.getDenominator() * this.denominator;
			
		int n1 = this.numerator * r2.getDenominator();
		int n2 = r2.getNumerator() * this.denominator;
			
		return new Rational(n1 - n2, cd);
			
	}
	
	public Rational multiply(Rational r2) {
		return new Rational(this.numerator * r2.getNumerator(), this.denominator * r2.getDenominator());
	}
	
	public Rational divide(Rational r2) {
		r2 = r2.getReciprocal();
		return multiply(r2);
	}
	
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	
	public Rational getReciprocal() {
		return new Rational(denominator, numerator);
	}

	private void reduce() {
		int gcd = gcd(numerator, denominator);
		
		if(gcd != 1) {
			
			
			if(gcd  > 1) {
				denominator = denominator/gcd;
				numerator = numerator/gcd;
			}
		}
	}
	
	private int gcd(int num1, int num2) {
		if (num2 == 0) 
			return num1;
		return gcd(num2, num1 % num2);	
	}
	
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	
	public double toDecimal() {
		return ((double) numerator) / denominator; 
	}

	@Override
	public int compareTo(Rational r2) {
		
		if(this.equals(r2)) {
			return 0;
		}
		else {
			if(this.toDecimal() > r2.toDecimal()) {
				return 1;
			}
			else {
				return -1;
			}
				
		}
	}
	
	public boolean equals(Rational r2) {
		return this.denominator == r2.getDenominator() && this.numerator == r2.getNumerator();
	}
	
	
	
}
