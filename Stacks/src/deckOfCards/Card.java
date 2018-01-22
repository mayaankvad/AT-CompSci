package deckOfCards;

public class Card implements Comparable<Card> {
	private int suit;
	private int value;

	/**
	 * Constructor for objects of class Card
	 */
	public Card() {
		suit = 1;
		value = 2;
	}

	public Card(int mySuit, int myValue) {
		suit = mySuit;
		value = myValue;
	}

	public int suit() {
		return suit;
	}

	public int value() {
		return value;
	}

	public String getValue() {
		String output = "";
		switch (value) {
		case 2:
			output = "2";
			break;
		case 3:
			output = "3";
			break;
		case 4:
			output = "4";
			break;
		case 5:
			output = "5";
			break;
		case 6:
			output = "6";
			break;
		case 7:
			output = "7";
			break;

		case 8:
			output = "8";
			break;
		case 9:
			output = "9";
			break;
		case 10:
			output = "10";
			break;
		case 11:
			output = "J";
			break;
		case 12:
			output = "Q";
			break;
		case 13:
			output = "K";
			break;
		case 14:
			output = "A";
			break;
		default:
			output = "Unknown type: " + value + " ";
			break;
		}
		return output;
	}

	public String getSuit() {
		String output = "";
		switch (suit) {
		case 1:
			output = "Clubs";
			break;
		case 2:
			output = "Diamonds";
			break;
		case 3:
			output = "Hearts";
			break;
		case 4:
			output = "Spades";
			break;
		default:
			output = output + "Unknown type: " + suit;
			break;
		}
		return output;
	}

	public String toString() {
		return (getValue() + " of " + getSuit());
	}

	public int compareTo(Card other) {
		return value - other.value;
	}
}