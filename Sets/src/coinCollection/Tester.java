package coinCollection;


public class Tester {
	public static void main(String[] args) throws Exception {
		
		Coin[] coins = new Coin[] {
			new Coin(Coin.Type.PENNY, 1941),
			new Coin(Coin.Type.DIME, 2010),
			new Coin(Coin.Type.QUARTER, 2009),
			new Coin(Coin.Type.NICKEL, 1954),				
			new Coin(Coin.Type.DIME, 1987),
			new Coin(Coin.Type.PENNY, 1949),
			new Coin(Coin.Type.DIME, 1982),
			new Coin(Coin.Type.PENNY, 1955),				
			new Coin(Coin.Type.QUARTER, 2002),
			new Coin(Coin.Type.QUARTER, 2008),
			new Coin(Coin.Type.NICKEL, 1952),				
			new Coin(Coin.Type.PENNY, 1931),
			new Coin(Coin.Type.DIME, 1989),
		};
		
		implementation.HashSet collection = new implementation.HashSet();
		
		for(Coin c: coins) {
			collection.add(c);
		}

		for(Object a: collection) {
			System.out.println(a);
		}
		
	}
}
