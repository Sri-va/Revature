package com.lambdaexpression;

public class CalculatorTest {

	public static void main(String[] args) {
	
		Calulator cal= (a, b, c) -> {
			switch(c) {
			case "+": return a+b;
			case "-": return a-b;
			case "*": return a*b;
			case "/": return a/b;
			default: return 0;
			}
			};
		System.out.print(cal.calculate(10, 5, "*"));
	}
}
