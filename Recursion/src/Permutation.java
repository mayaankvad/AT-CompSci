
public class Permutation {
	
	private String orig;
	private String list;

	public Permutation(String word) {
		orig = word;
		list = "";
	}

	public void permutation() {
		System.out.println("\nPERMUTATION OF WORD :: " + orig);
		permutation(orig, "");
	}

	private void permutation(String orig, String sent) {
		
		if(orig.length() == sent.length()) {
			System.out.println(sent);
		}
		else {
			
			for(char c: orig.toCharArray()) {
				if (!sent.contains(Character.toString(c))) {
					permutation(orig, sent + c);
				}
			}
			
		}
		
	}

	public String toString() {
		return list;
	}
	
	
	public static void main(String[] args) {
		Permutation p = new Permutation("123");
		p.permutation();
	}
	
	
}