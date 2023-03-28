package com.oops;

public class MethodOverloadTest extends MethodOverrideTest{
	
	int a=10;
	int b=20;
	
	// Method overloading or compile-time polymorphism or static polymorphsim
	void addition() {
		int c=a+b;
		System.out.println("Addition of a and b is : " +c);
	}
	
	// Method overloading
	void addition(int a, int b) {
		int c=a+b;
		System.out.println("Addition of a and b with arguments is : " +c);
	}
	
	// Method overloading
	void addition(double a, double b) {
		double c=a+b;
		System.out.println("Addition of double a and b is : " +c);
	}
	
	void test() {
		super.addition();
		this.addition();
	}
		

	public static void main(String[] args) {
		MethodOverloadTest mot = new MethodOverloadTest();
		mot.addition();
		mot.addition(30,40);
		mot.addition(123.233423, 423.2343242);
		mot.test();

	}

}
