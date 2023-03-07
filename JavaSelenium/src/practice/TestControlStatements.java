package practice;

public class TestControlStatements {

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
	String str = "month";
	String st = "week";

	void sample(String sText) {
		if (sText.equals(str)) {
			System.out.println("Selected Month : ");

			for(int i=1; i<=12; i++) {
				switch(i) {
				case 1:
					System.out.println("January");
					break;
				case 2:
					System.out.println("February");
					break;
				case 3:
					System.out.println("March");
					break;
				case 4:
					System.out.println("April");
					break;
				case 5:
					System.out.println("May");
					break;
				case 6:
					System.out.println("June");
					break;
				case 7:
					System.out.println("July");
					break;
				case 8:
					System.out.println("August");
					break;
				case 9:
					System.out.println("September");
					break;
				case 10:
					System.out.println("October");
					break;
				case 11:
					System.out.println("November");
					break;
				case 12:
					System.out.println("December");
					break;
				default:
					System.out.println("Enter a valid Month..!");
					break;
				}
			}
		}else if(sText.equals(st)){
			System.out.println("Selected Week : ");
			
			for(int i=0; i<7; i++) {
				switch(i) {
				case 0:
					System.out.println("Sunday");
					break;
				case 1:
					System.out.println("Monday");
					break;
				case 2:
					System.out.println("Tuesday");
					break;
				case 3:
					System.out.println("Wednesday");
					break;
				case 4:
					System.out.println("Thursday");
					break;
				case 5:
					System.out.println("Friday");
					break;
				case 6:
					System.out.println("Saturday");
					break;
				default:
					System.out.println("Enter a valid Week..!");
					break;
				}
			}
		}else {
			System.out.println("Enter valid Details...");
		}
	}

		public static void main(String[] args) {

		TestControlStatements tcs = new TestControlStatements();
		System.out.println("Enter you want to Display Month/Week...?");
		tcs.sample("week");
	}
}