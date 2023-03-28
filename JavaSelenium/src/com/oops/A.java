package com.oops;

public class A {
	
	// State or Characteristic or attributes
	int a=10; // Data members
	int b=20;
	
	// Action or Behavior
	void addition() {
		int c=a+b;
		System.out.println("Addition of a and b is : "+c);
	}
	
	
	void modulus() {
		int c=b%a;
		System.out.println("Modulus of and b is : " +c);
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.addition();

	}

}
