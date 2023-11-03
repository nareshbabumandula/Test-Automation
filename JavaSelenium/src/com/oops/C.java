package com.oops;

public class C extends B{
	
	void Multiplication() {
		int c=a*b;
		System.out.println("Multiplication of a and b is : "+c);
	}


	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.a);
		System.out.println(c.b);
		c.addition();
		c.subtraction();
		c.Multiplication();
		
		
	}

}
