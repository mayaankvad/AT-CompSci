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
			for (int value = 1; value <= 14; value++) {
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
		for(Card c: deck) {
			res += c + ", ";
			i++;
			
			if(i == 3) {
				res += "\n";
				i = 0;
			}
		}
		
		
		return res + "\n";
		//System.out.println(deck);return null;
	}

	// Return and remove the top card
	public Card deal() {
		
		return deck.pop();
		
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		
		Stack<Card> top = new Stack<Card>();
		Stack<Card> bottom = new Stack<Card>();
		int mid = deck.size() / 2;
		
		// split stack
		for(int i = 0; i <= mid; i++) {
			top.push(deck.pop());
		}
		while(!deck.isEmpty()) {
			bottom.push(deck.pop());
		}
		top = reverse(top);
		bottom = reverse(bottom);
		
		// add cards
		while(deck.size() != (mid *2) ) {
			
			if(!top.isEmpty()) {
				deck.push(top.pop());
			}
			if(!bottom.isEmpty()) {
				deck.push(bottom.pop());
			}
		}
		
		
	}

	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		int rand = new java.util.Random().nextInt(this.deck.size() -1);
		
		// lazy
		
	}

	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
	}

	// Reverse the order of the cards in the deck
	public void reverse() {
		deck = reverse(deck);
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	private Stack<Card> reverse(Stack<Card> x) {
		
		Stack<Card> rev = new Stack<Card>();
		
		while(!x.isEmpty()) {
			rev.push(x.pop());
		}
		return rev;
	}

	// Combine two decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {
		while(!other.isEmpty()) {
			deck.push(other.pop());
		}
	}

	public static void main(String[] args) {
		// example method calls - you should make your own

		Deck a = new Deck();
		System.out.println(a.getDeck());
		System.out.println(a);
		a.bridgeShuffle();
		System.out.println(a);
		a.cut();
		a.completeShuffle();

		System.out.println("After 1 bridge shuffle");
		System.out.println(a);
		a.reverse();
		for (int i = 1; i <= 5; i++)
			System.out.println(a.deal());
	}
}