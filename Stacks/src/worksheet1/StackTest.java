package worksheet1;

import java.util.Stack;

public class StackTest
{
	private Stack<String> stack;

	public StackTest()
	{
		this("");
	}

	public StackTest(String line)
	{
		stack = new Stack<String>();
		setStack(line);
	}
	
	public void setStack(String line)
	{
		for(int i = 0; i < line.length(); i++) {
			stack.push(line.substring(i, i + 1));
		}
	}

	public void popEmAll()
	{
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + ", ");
		}
		System.out.println();
	}

	//add a toString
	
	public String toString() {
		return stack.toString();
	}
}