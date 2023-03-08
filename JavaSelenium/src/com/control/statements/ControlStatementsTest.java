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
		boolean bFlag=false;
		if (a>b) {
			bFlag=true;
			System.out.println("a is greater than b");
			if (bFlag) {
				System.out.println("a is greater..!");
			}
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
	
	
	void forLoopExample() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Iteration is : " + i);
		}
	}
	
	void evenOrOdd(int num) {
		for (int i = 0; i < num; i++) {
			if(i%2==0) {
				System.out.println(i + " : is an even number");
			}else {
				System.out.println(i + " : is an odd number");
			}
		}
	}

	void forEachExample() {
		String[] students = {"padma", "keerthana", "pruthvi", "nirmala", "nandini", "satya"};
		
		for (String string : students) {
			System.out.println(string);
		}
	}

	void whileLoopExample() {
		int i=0;
		
		while (i<=20) {
			System.out.println("Iteration in while loop is : " +i);
			i=i+1;
		}
	}
	
	void dowhileLoopExample() {
		int i=0;
		
		do {
			System.out.println("Iteration in do while loop is : " +i);
			i=i+1;
		} while (i<=20);
	}
	
	void breakandContinueExample() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Iteration is : " +i);
			
			if(i==4) {
				continue;
			}
			if(i==6) {
				break;
			}
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
		cst.forLoopExample();
		cst.evenOrOdd(20);
		cst.forEachExample();
		cst.whileLoopExample();
		cst.dowhileLoopExample();
		cst.breakandContinueExample();
		

	}

}
