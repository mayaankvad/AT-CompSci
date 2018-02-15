package palindrome;

public class Tester {
	public static void main(String[] args) {
		System.out.println(new Palindrome("one two three two one"));
		System.out.println(new Palindrome("1 2 3 4 5 one two three four five"));
		System.out.println(new Palindrome("a b c d e f g x y z g f h"));
		System.out.println(new Palindrome("racecar is racecar"));
		System.out.println(new Palindrome("1 2 3 a b c c b a 3 2 1"));
		System.out.println(new Palindrome("chicken is a chicken"));
	}
}
