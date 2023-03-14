package com.oops;

public class A {
	
	// State or Characteristic or attributes
	int a=10; // Data member
	int b=20;
	
	// Action or Behavior
	void addition() {
		int c=a+b;
		System.out.println("Addition of a and b is : "+c);
	}
	
	// No argument Constructor
	public A() {
		System.out.println("This is a no argument constructor..!");
	}
	
	// Parameterized Constructor
	public A(int a, int b) {
		System.out.println(this.a);
		System.out.println(this.b);
		this.a=a;
		this.b=b;
		System.out.println("This is a parameterized constructor..!");
	}
	
	public static void main(String args[]) {
		A a = new A(100, 200);
		a.addition();
	}

}
