package deckOfCards;

import java.util.Stack;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck() {
		for (int suit = 1; suit <= 4; suit++) {
			for (int value = 2; value <= 14; value++) {
				deck.push(new Card(suit, value));
			}
		}
	}

	// Print the stack - for uniformity,
	// make 13 rows in four columns, filling
	// in each row from left to right
	public String toString() {
		String res = "";

		int i = 0;
		for (Card c : deck) {
			res += c + ", \t";
			i++;

			if (i == 3) {
				res += "\n";
				i = 0;
			}
		}

		return res + "\n";
		// System.out.println(deck);return null;
	}

	// Return and remove the top card
	public Card deal() {

		return deck.pop();

	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {

		int mid = deck.size() / 2;

		Stack<Card> top = new Stack<Card>();
		for (int i = 0; i < mid; i++) {
			top.push(deck.pop());
		}
		top = reverse(top);

		Stack<Card> res = new Stack<Card>();

		while (!top.isEmpty()) {
			res.push(top.pop());
			res.push(deck.pop());
		}

		deck = reverse(res);
	}

	// Split the deck at a random split. Put the stack of cards above the random
	// split below the other cards
	public void cut() {
		int split = new java.util.Random().nextInt(this.deck.size() - 1);

		Stack<Card> res = new Stack<Card>();
		
		for (int i = 0; i < split; i++) {
			res.push(deck.pop());
		}
		res = reverse(res);
		
		deck = reverse(deck);
		while (!deck.isEmpty()) {
			res.push(deck.pop());
		}
		
		deck = res;
	}

	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
		for (int i = 0; i < 7; i++) {
			bridgeShuffle();
			cut();
		}
	}

	// Reverse the order of the cards in the deck
	public void reverse() {
		deck = reverse(deck);
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {

		Stack<Card> rev = new Stack<Card>();

		while (!x.isEmpty()) {
			rev.push(x.pop());
		}
		return rev;
	}

	// Combine two decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
		while (!other.isEmpty()) {
			deck.push(other.pop());
		}
	}

}