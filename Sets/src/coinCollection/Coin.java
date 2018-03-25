package coinCollection;

public class Coin {

	public enum Type {
		PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

		private int value;

		Type(int value) {
			this.value = value;
		}
	}

	private Type type;
	private int year;

	public Coin(Type type, int year) {
		this.type = type;
		this.year = year;
	}

	public Type getType() {
		return this.type;
	}

	public int getYear() {
		return this.year;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		Coin c = (Coin) obj;
		return (this.type == c.type) && isSameDecade(this.year, c.year);
	}

	public String toString() {
		return this.type + ":" + this.year;
	}

	public int hashCode() {
		return Integer.valueOf(Integer.toString(this.type.value) + Integer.valueOf((this.year / 10)));
	}

	private static boolean isSameDecade(int y1, int y2) {
		return (y1 / 10) == (y2 / 10);
	}

}
