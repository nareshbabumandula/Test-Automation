package com.mypractice;

public class Child extends Parent {
	
	String name = "Child";
    int age = 5;
    String gender = "Baby Boy";
	void print() {
		System.out.println("Child class method is called");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creating Parent class object in Child class
		Parent p = new Parent();
		System.out.println(p.name);//calling Parent class variable
		System.out.println(p.age);//calling Parent class variable
		System.out.println(p.noOfChilds);//calling Parent class variable
		//System.out.println(p.gender);
		p.print();//calling Parent class method
		//Overriding
		System.out.println("***Overriding***");
		Child c = new Child();
		System.out.println(c.name);
		System.out.println(c.age);
		System.out.println(c.noOfChilds);
		System.out.println(c.gender);
		c.print();
		//Upcasting
		System.out.println("***Upcasting***");
		Parent p1 = new Child();
		System.out.println(p1.name);//calling Parent class variable
		System.out.println(p1.age);//calling Parent class variable
		System.out.println(p1.noOfChilds);//calling Parent class variable
		//System.out.println(p1.gender);In upcasting Parent class reference object cannot call Child class variables 
		p1.print();//calling Child class method
		//Downcasting
		System.out.println("***Downcasting***");
		Parent p2 = new Child();
		Child c1 = (Child)p2;
		System.out.println(c1.name);//calling Child class variable 
		System.out.println(c1.age);//calling Child class variable
		System.out.println(c1.noOfChilds);//calling Parent class variable because this variable didn't declare in Child class
		System.out.println(c1.gender);
		c1.print();//calling Child class method
		
	}

}