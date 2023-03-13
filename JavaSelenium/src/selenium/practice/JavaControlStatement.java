package selenium.practice;

public class JavaControlStatement {

	int a=20;
	int b=10;

	void ifTest() {

		if(a>b) {
			System.out.println("a is greater than b.");
		} 
		else if(a==b) {
			System.out.println("a is equal to b.");
		}
		else {
			System.out.println("a is less than b.");
		}
	}

	void switchTest(String wkday) {
		switch(wkday.toLowerCase()) {
		case "sun":
			System.out.println("Sunday");
			break;
		case "mon":
			System.out.println("Monday");
			break;
		case "wed":
			System.out.println("wednesday");
			break;
		case "thur":
			System.out.println("Thursday");
			break;
		case "fri":
			System.out.println("Friday");
			break;
		case "sat": case "satu":
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Enter a valid day.");
			break;
		}
	}

	void switchTestMonth(String mnth) {
		switch (mnth.trim()) {
		case "jan" :
			System.out.println("January");
			break;
		case "feb" :
			System.out.println("February");
			break;
		case "mar" :
			System.out.println("     Month    March     ");
			break;
		case "apr" :
			System.out.println("April");
			break;
		case "may" :
			System.out.println("May");
			break;
		case "jun" :
			System.out.println("June");
			break;
		case "jul" :
			System.out.println("July");
			break;
		case "aug" :
			System.out.println("August");
			break;
		case "sep" :
			System.out.println("September");
			break;
		case "oct" :
			System.out.println("October");
			break;
		case "nov" :
			System.out.println("November");
			break;
		case "dec" :
			System.out.println("Dcember");
			break;
		default :
			System.out.println("Enter a Valid Month.");
			break;
		}
	}
	
		void forLoopTest() {
			for(int i=0; i<10;i++) {
				System.out.println("Iteration number :" + i);
			}
		}
		
		void oddOrEven(int num) {
			for(int i=0; i<num; i++) {
				if(i%2==0) {
					System.out.println(i + ": is Even Number.");
				}
				else {
					System.out.println(i + ": is Odd Number.");
				}	
			}
		}
		
		void whileLoopTest() {
			int i=0;
			while(i<10) {
				System.out.println("Iteration in Whileloop is : " + i);
				i=i+2;
			}
		}
		
		void doWhileLoopTest() {
			int i=0;
			
			do {
				
				System.out.println("In Do While Loop, First Executed and then it will check the Condition.\nIteration Number is : " + i );
				i=i+3;
				
			}while(i<5);
		}

	public static void main(String[] args) {
		JavaControlStatement cs =new JavaControlStatement();
		cs.ifTest();
		cs.switchTestMonth("mar");
		cs.switchTest("sat");
		cs.forLoopTest();
		cs.oddOrEven(5);
		cs.whileLoopTest();
		cs.doWhileLoopTest();

	}

}
