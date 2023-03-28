package com.java.assignments;

public class UpCasting {

	public static void main(String[] args) {
		// This is one way of UpCasting...1
		/*Parent p=new Parent();
		  p=new Child();
		 */
		// This is another way of UpCasting...2
		/*Parent p;
		  p=new Child();
		 */
		Parent p=new Child();	//This is Overridden method
		p.test();	
		//Directly we cannot call Child Class Methods and Variables.. 
		//p.show();	// Child Class Method
		//System.out.println("i = "+i);	// Child Class Variable-i
		Child.printData();	//we can call Child Class Static Methods by using child class ClassName..
		System.out.println("Class = "+p.str);	//we can access only Parent Class Variables
	}

}
