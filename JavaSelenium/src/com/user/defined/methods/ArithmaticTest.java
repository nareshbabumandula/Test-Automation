package com.user.defined.methods;

public class ArithmaticTest {
	//Java is statically-typed, so it expects its variables to be declared before they can be assigned values.
	byte a=10;  // State or characteristics or data members
	byte b=20;
	
	/**
	 * @author naresh
	 * @Desc This method is used to perform addition of two numbers
	 * @ReturnType void
	 * @Date 02-Mar-2023
	 */
	// Behavior or action or functionality 
	void addition() {
		// implementation
		int c=a+b; // implicit/up casting
		System.out.println("Addition is a and b is : " +c);
	}
	
	void subtraction(int a, int b) {
		int c=a-b; 
		System.out.println("Subtraction is a and b is : " +c);
	}
	
	int multiplication() {
		int c=a*b; 
		return c;
	}
	
	int division(int a, int b) {
		int c=b/a;
		return c; 
	}
	
	int modulus(int a, int b) {
		int c=b%a;
		return c; 
	}

	public static void main(String[] args) {
		// Classname objRef = new ConstructorName();
		ArithmaticTest arth = new ArithmaticTest();
		arth.addition();
		arth.subtraction(40, 70);
		int r = arth.multiplication();
		System.out.println("Multiplication of a and b is : " +r);
		int res = arth.division(40,10);
		System.out.println("Division of a and b is : " +res);
		int op = arth.modulus(20,5);
		System.out.println("Modulus of a and b is : " +op);

	}

}
