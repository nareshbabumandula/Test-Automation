package practice;

public class ControlStatmentsTestDemo {
	// first example for ifTest statement
	int bikespeed = 45;

	void ifTest() {
		if(bikespeed<40) {
			System.out.println("Slow");
		}else if(bikespeed>=40&&bikespeed<70) {
			System.out.println("Normal");
		}else if(bikespeed>=70&&bikespeed<100) {
			System.out.println("Fast");
		}else {
			System.out.println("Invalid");
		}
		//second example
		int priyaage =45;
		int riyaage=35;
		if(priyaage>riyaage) {
			System.out.println("45 is greater than 35");
		}
		//third example
		int niharikamarks=90;
		int harikamarks=95;
		if(niharikamarks>harikamarks) {
			System.out.println("90 is greater than 95");
		}else if(niharikamarks==harikamarks) {
			System.out.println("90 is equal to 95");
		}else {
			System.out.println("90 is less than 95");
		}
		//fourth example
		int girl=18;
		int boy=23;
		if(girl>=18) {
			if(boy>=21) {
				System.out.println("Eligible for the marriage");
			}else {
				System.out.println(" Not eligible for the marriage");
			}
		}
	}
	//switch statements
	// first example 
	void switchTest() {
		char books=1;
		switch (books) {
		case 1:
			System.out.println("Plain");
		case 2:
			System.out.println("Rough");
		default:
			System.out.println("Invalid");
			break;
		}
		//second example
		int Number=22;

		switch(Number) {
		case 2:
			System.out.println("Even");
			break;
		case 14:
			System.out.println("Even");
			break;
		case 17:
			System.out.println("Odd");
			break;
		case 22:
			System.out.println("Even");
			break;
		case 25:
			System.out.println("Odd");
			break;
		case 24:
			System.out.println("Even");
			break;
		case 29:
			System.out.println("Odd");
			break;
		case 23:
			System.out.println("Odd");
			break;
		}			
		//third example
		int year=1;
		switch(year){
		case 1:
			System.out.println("Pharmacy");
			break;
		case 2:
			System.out.println("Pharmacology");
			break;
		case 3:
			System.out.println("Biopharmaceutics");
			break;
		case 4:
			System.out.println("Pharmaceutical analysis");
			break;
		}
	}
	// fourth example
	void switchTest(String groups) {
		switch (groups.trim()){
		case "mpc":
			System.out.println("Maths");
			break;
		case "bipc":
			System.out.println("Science");
			break;
		default:
			System.out.println("Enter a valid group..!");
			break;
		}		
	}
	public static void main(String[] args) {
		ControlStatmentsTestDemo cstd = new ControlStatmentsTestDemo();
		cstd.ifTest();
		cstd.switchTest();
		cstd.switchTest("        bipc      ");
		cstd.switchTest("mpc");
	}
}