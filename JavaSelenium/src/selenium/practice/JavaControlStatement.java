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

	public static void main(String[] args) {
		JavaControlStatement cs =new JavaControlStatement();
		cs.ifTest();
		cs.switchTest("sat");
		cs.switchTest("SaTu");

	}

}
