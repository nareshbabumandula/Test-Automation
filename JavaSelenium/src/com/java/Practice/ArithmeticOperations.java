package com.java.Practice;

public class ArithmeticOperations {
	byte a = 20;
	byte b = 10;
	int c;
	
	/**
	 * @author Nirmala
	 * @Desc Perform Addition of Two Numbers
	 * @ReturnType void
	 * @Date 02-mar-2023
	 */
	void addition() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		c = a + b;
		System.out.println("Addition of a + b =" + c);
	}
	
	void subtraction(int a, int b) {
		c = a - b;
		System.out.println("Subtraction of a - b = "+ c);
	}
	
	int multiplication(int x, int y) {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		int d = x * y;
		return(d);
	}
	
	void Division() {
		float c = a/b;
		System.out.println("Division of a/b = " + c);
	}
	
	int modulus(int a) {
		int D = a%3;
		return(D);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArithmeticOperations arth = new ArithmeticOperations();
		
		arth.addition();
		
		arth.subtraction(50, 20);
		
		int m = arth.multiplication(50, 3);
		System.out.println("multiplication of x * y = " + m );
		System.out.println("m = " + m);
		
		arth.Division();
		
		System.out.println("Modulus of m%3 = " + arth.modulus(m));
		
	}

}
