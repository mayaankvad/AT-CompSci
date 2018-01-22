package deckOfCards;

public class Main {

	public static void main(String[] args) {

		Deck a = new Deck();
		System.out.println("Display after DECK CONSTRUCTION \n" + a + "\n\n");
		//a.cut();
		//a.reverse();
		a.bridgeShuffle();
		System.out.println("Display after CUT \n" + a + "\n\n");
		//a.completeShuffle();
		System.out.println("Display after COMPLETE SHUFFLE \n" + a + "\n\n");

	}

}
