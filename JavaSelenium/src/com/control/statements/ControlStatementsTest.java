package com.control.statements;

public class ControlStatementsTest {

	int a=20;
	int b=30;

	/**
	 * Java provides three types of control flow statements.
		Decision Making statements
			if statements
			switch statement
		Loop statements
			do while loop
			while loop
			for loop
			for-each loop
		Jump statements
			break statement
			continue statement
	 */
	void ifTest() {
		if (a>b) {
			System.out.println("a is greater than b");
		}else if(a==b){
			System.out.println("a is equal to b");
		}else {
			System.out.println("a is less than b");
		}
	}

	void switchTest(String strDay) {
		switch (strDay.toLowerCase().trim()) {
		case "sun": case "sund":
			System.out.println("Sunday");
			break;
		case "mon":
			System.out.println("Monday");
			break;
		case "tue":
			System.out.println("Tuesday");
			break;
		case "wed":
			System.out.println("Wednesday");
			break;
		case "thu":
			System.out.println("Thursday");
			break;
		case "fri":
			System.out.println("Friday");
			break;
		case "sat":
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Enter a valid day..!");
			break;
		}
	}


	public static void main(String[] args) {
		//Using the new keyword is the most popular way to create an object or instance of the class. 
		//When we create an instance of the class by using the new keyword, it allocates memory (heap)
		//for the newly created object and also returns the reference of that object to that memory. 
		//The new keyword is also used to create an array. The syntax for creating an object is:
		ControlStatementsTest cst = new ControlStatementsTest();
		cst.ifTest();
		cst.switchTest("SUN");
		cst.switchTest("sund ");
		

	}

}
