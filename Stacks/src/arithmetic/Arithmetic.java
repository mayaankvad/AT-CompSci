package arithmetic;

import java.util.HashMap;
import java.util.Stack;

public class Arithmetic {

	private String exp;

	private Stack<Double> numbers;
	private Stack<String> operators;

	private static HashMap<String, Integer> map;

	static {
		map = new HashMap<String, Integer>();
		map.put("+", 0);
		map.put("-", 0);
		map.put("*", 1);
		map.put("/", 1);
		map.put("^", 2);
	}

	public Arithmetic(String exp) {
		this.exp = exp;
		this.numbers = new Stack<Double>();
		this.operators = new Stack<String>();
	}

	public double solve() {

		exp = exp.replace(" ", "");

		for (String s : this.exp.split("")) {

			if (isNumber(s)) {
				this.numbers.push(Double.valueOf(s));
			}

			else if (isOpen(s)) {
				this.operators.push(s);
			}

			else if (isOperator(s)) {

				if (!this.operators.isEmpty()) {

					try {
						while (!this.operators.isEmpty() && hasHigherPrecedence(this.operators.peek(), s)) {
							evalTop();
						}
					} catch (Exception e) {

					}

				}

				this.operators.push(s);
			}

			else if (isClose(s)) {
				while (!this.operators.peek().equals("(")) {
					evalTop();
				}
				this.operators.pop();
			}

		}

		while (!this.operators.isEmpty()) {
			evalTop();
		}

		return this.numbers.peek();
	}

	public void evalTop() {
		Double n1 = this.numbers.pop();
		Double n2 = this.numbers.pop();
		
		Double res = 0.0;
		switch (this.operators.pop()) {
		case "+":
			res = n1 + n2;
			break;
		case "-":
			res = n2 - n1;
			break;
		case "/":
			res = n1 / n2;
			break;
		case "*":
			res = n1 * n2;
			break;
		case "^":
			res = Math.pow(n2, n1);
			break;
		}

		numbers.push(res);
	}

	public static boolean isNumber(String x) {
		try {
			Double.valueOf(x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isOperator(String s) {
		return s.matches("\\+|\\-|\\/|\\*|\\^");
	}

	public boolean hasHigherPrecedence(String a, String b) {
		return map.get(a) > map.get(b);
	}

	public static boolean isParenthesis(String x) {
		return x.matches("\\(|\\)");
	}

	public static boolean isOpen(String x) {
		return x.equals("(");
	}

	public static boolean isClose(String x) {
		return x.equals(")");
	}

}
