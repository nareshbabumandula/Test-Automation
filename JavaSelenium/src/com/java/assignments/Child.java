package com.java.assignments;

public class Child extends Parent {
	String str="Child";
	int i=10;
	
	void show() {
		System.out.println("This is Child Class - Show() method");
	}
	static void printData() {
		System.out.println("printData() is the Static Method of Child Class");
	}
	void test() {
		System.out.println("This is Child Class Method...");
	}
}
