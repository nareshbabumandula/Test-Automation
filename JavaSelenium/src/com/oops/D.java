package com.oops;

public class D extends A{
	int a=4;
	int b=8;
	int d=18;
	
	void addition() {
		int c=a+b;
		System.out.println("Addition of and b is : " +c);
	}
		

	public static void main(String[] args) {
		
		A a = new D(); // Upcasting Converting the sub type to its super type
		System.out.println(a.a);
		System.out.println(a.b);
		a.addition();
		a.modulus();
		
		D d = new D();  // Creating object for D class
		A a1 = d; // Upcasting
		D d1 = (D)a1;; // Downcasting
		d1.addition();
		System.out.println(d1.a); // access only child class variables
		System.out.println(d1.b);
		d1.modulus();
		
		D d2 = (D) new A(); // Downcasting - no compile time error
		
	}

}
