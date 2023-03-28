package com.java.assignments;

public class DownCasting {

	public static void main(String[] args) {
		//Child c=new Parent(); // we can't perform implicit DownCasting.. it gives compile time error

		Parent p=new Child();
		Child c=(Child)p;
		c.test();	//This is overridden method
		//p.test();	// This is overridden method
		c.show();	// This is Child Class method
		System.out.println("i = "+c.i);	//This is Child Class variable
		//c.printData();	//This is Static method of Child Class
		System.out.println("Class = "+c.str);
		System.out.println("Class = "+p.str);
	}

}
