package palindrome;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

	private Collection<Object> phrase;
	private Stack<Object> stack;
	private Queue<Object> queue;
	private boolean isValid;

	public Palindrome(Collection<Object> phrase) {
		this.phrase = phrase;

		this.stack = new Stack<Object>();
		this.queue = new LinkedList<Object>();

		for (Object p : phrase) {
			this.stack.push(p);
			this.queue.offer(p);
		}

		this.isValid = this.check();
	}

	public Palindrome(Object[] phrase) {
		this(Arrays.asList(phrase));
	}
	
	public Palindrome(String phrase) {
		this(phrase.trim().replace(",", "").split(" "));
	}

	private boolean check() {
		while (!this.queue.isEmpty()) {
			if (!this.stack.pop().equals(this.queue.poll())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid() {
		return this.isValid;
	}

	public String toString() {
		return this.phrase + (this.isValid() ? " is a palinlist." : " is not a palinlist.");
	}

}
