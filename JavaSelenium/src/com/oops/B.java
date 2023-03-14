package com.oops;

public class B extends A{
	
	int a=100;
	int b=200;
	
	public B() {
		super();
		//super(1,2);
	}
	
	void subtraction() {
		int c=a-b;
		System.out.println("Subtraction of a and b is : "+c);
	}

	public static void main(String[] args) {
		B b = new B();
		b.addition();
	    b.subtraction();
	    System.out.println(b.a);
	    System.out.println(b.b);
	}

}
