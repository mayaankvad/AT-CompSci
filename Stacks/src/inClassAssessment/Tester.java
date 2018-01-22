package inClassAssessment;

public class Tester {

	public static void main(String[] args) {
		
		SyntaxChecker test = new SyntaxChecker("(abc(*def)");
		System.out.println(test);
		
		SyntaxChecker test2 = new SyntaxChecker("[{}]");
		System.out.println(test2);
		
		SyntaxChecker test3 = new SyntaxChecker("[");
		System.out.println(test3);
		
		SyntaxChecker test4 = new SyntaxChecker("[{<()>}]");
		System.out.println(test4);
		
		SyntaxChecker test5 = new SyntaxChecker("{<html[value=4]*(12)>{$x}}");
		System.out.println(test5);
		
		SyntaxChecker test6 = new SyntaxChecker("[one]<two>{three}(four)");
		System.out.println(test6);
		
		SyntaxChecker test7 = new SyntaxChecker("car(cdr(a)(b)))");
		System.out.println(test7);
		
		SyntaxChecker test8 = new SyntaxChecker("car(cdr(a)(b))");
		System.out.println(test8);

	}

}
