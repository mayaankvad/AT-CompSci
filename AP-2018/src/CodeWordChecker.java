
public class CodeWordChecker implements StringChecker{

	private int min;
	private int max;
	private String exclude;

	public CodeWordChecker(String e) {
		this(6, 20, e);
	}

	public CodeWordChecker(int a, int b, String e) {
		min = a;
		max = b;
		exclude = e;
	}

	@Override
	public boolean isValid(String str) {
		int l = str.length();
		return !str.contains(exclude) && l  >= min && l <= max;
	}
	
	
	

}
