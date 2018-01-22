package inClassAssessment;

import java.util.Stack;

public class SyntaxChecker {

	private static String regexOpen = "\\(|\\{|\\<|\\["; 
	private static String regexClose = "\\)|\\}|\\>|\\]";
	
	private String exp;
	private Stack<String> symbols;
	private boolean check;
	
	public SyntaxChecker(String s) {
		this.exp = s;
		this.symbols = new Stack<String>();
		check = true;
		
		String[] list = s.split("");
		for(String c: list) {
			
			if(c.matches(regexOpen)) {
				this.symbols.push(c);
			}
			else if(c.matches(regexClose)) {
				
				if(!this.symbols.isEmpty()) {
					String val = this.symbols.pop();
					
					boolean x = (val.equals("(") && c.equals(")")) ||
					(val.equals("{") && c.equals("}")) ||
					(val.equals("[") && c.equals("]")) ||
					(val.equals("<") && c.equals(">")) ;
					
					if(!x) {
						check = false;
						break;
					}
					
					
				} else {
					check = false;
					break;
				}
				
			}
				
		}
		
		if(!this.symbols.isEmpty()) {
			check = false;
		}
		
	}
	
	public String toString() {
		return this.exp + ": " + (this.check ? " Correct": "Incorrect") ;//""+ this.symbols; 
	}
	

}
