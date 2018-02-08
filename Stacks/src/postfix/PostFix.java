// Mayaank Vadlamani

package postfix;

import java.util.Stack;

public class PostFix {
	
	private String exp;
	private Stack<String> symbols;
	
	public PostFix(String s) {
		exp = s;
		symbols = new Stack<String>();
	}

	
	public double solve() {
		
		
		for(String s: exp.split(" ")) {
			
			if(isNumber(s)) {
				symbols.push(s);
			}
			else {
				
				double n1 = Double.valueOf(symbols.pop());
				double n2 = Double.valueOf(symbols.pop());
				
				if(s.equals("+")) {
					symbols.push(Double.toString(n1 + n2));
				} else if(s.equals("-")) {
					symbols.push(Double.toString(n2 - n1));
				} else if(s.equals("*")) {
					symbols.push(Double.toString(n1 * n2));
				} else if(s.equals("/")) {
					symbols.push(Double.toString(n2 / n1));
				}
				
			}
			
		}
		return Double.valueOf(symbols.pop());
		
	}
	
	public boolean isNumber(String s) {
		try {
			Double.valueOf(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		PostFix test = new PostFix("2 7 + 1 2 + +");
		System.out.println(test.exp + " = " +test.solve());
		PostFix test2 = new PostFix("1 2 3 4 + + +");
		System.out.println(test2.exp + " = " +test2.solve());
		PostFix test3 = new PostFix("9 3 * 8 / 4 + ");
		System.out.println(test3.exp + " = " +test3.solve());
		PostFix test4 = new PostFix("3 3 + 7 * 9 2 / +");
		System.out.println(test4.exp + " = " +test4.solve());
		PostFix test5 = new PostFix("9 3 / 2 * 7 9 * + 4 -");
		System.out.println(test5.exp + " = " +test5.solve());
		PostFix test6 = new PostFix("5 5 + 2 * 4 / 9 +");
		System.out.println(test6.exp + " = " +test6.solve());

	}

}
