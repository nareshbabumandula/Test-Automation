package test.com.practice;

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
	//8march 2023 practice
	void breakandContinue() {
		for (int z = 2; z< 8; z++) {
			System.out.println(z);
			if(z==2) {
				continue;
			}if(z==7) {
				break;
			}
		}	
	}
	void forloop() {
		for(int e=3;e<=5;e++) {
			for(int f =3;f<=5;f++) {
				System.out.println(e+""+f);
			}
		}
		//second example
		for(int x=1;x<=6;x++) {
			System.out.println(x);
		}
	}
	void foreach() {
		String[]subjects = {"maths","science",};
		for (String str : subjects) {
			System.out.println(str);
		}
	}
	void whileLoop() {
		int m=1;
		while (m<=15) {
			System.out.println(m);
			m=m+2;
		}
	}
	void dowhileLoop() {
		int i=17;
		do {
			System.out.println(i);
			i=i+1;
		} while (i<=18);
	}
	//assignments8/3/2023
	//program to print numbers like 1,4,7,10,13,16,19
	void printnumbers() {
		int k=1;
		while(k<=20) {
			System.out.println(k);
			k=k+3;
		}
	}
	//program to print 100 to 1 in reverse order
	void reverseorder() {
		for(int r=100;r>0;r--) {
			System.out.println(r);
		}
	}
	//program to print prime numbers between 1 and 100
	void primenumbers() {
		int number = 100, count = 0;;
		for (int i = 1; i <= number; i++) {
			count = 0;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}
			if (count == 0) {
				System.out.println(i);
			}
		}
	}
	//program to check whether it is a prime number or not
	void verifyprimenumber() {
		int number=89;
		boolean flag = false;
		for(int i=2;i<=number/2;++i) {
			if(number%i==0) {
				flag=true;
			}
		}
		if(!flag)
			System.out.println(number+"is a prime number");
		else
			System.out.println(number+"is not a prime number");
	}
	void verifynonprimenumber() {
		int number=58;
		boolean flag = false;
		for(int i=2;i<=number/2;++i) {
			if(number%i==0) {
				flag=true;
			}
		}
		if(!flag)
			System.out.println(number+"is a prime number");
		else
			System.out.println(number+"is not a prime number");
	}
	//program to find the factorial of a given number
	void findfactorialnumber() {
		int n=8,factorial=1;
		for(int i=1;i<=n;++i)
		{
			factorial=factorial*i;}
		System.out.println(factorial);
	}
	public static void main(String[] args) {
		ControlStatmentsTestDemo cstd = new ControlStatmentsTestDemo();
		cstd.ifTest();
		cstd.switchTest();
		cstd.switchTest("        bipc      ");
		cstd.switchTest("mpc");
		cstd.breakandContinue();
		cstd.forloop();
		cstd.foreach();
		cstd.whileLoop();
		cstd.dowhileLoop();
		cstd.printnumbers();
		cstd.reverseorder();
		cstd.primenumbers();
		cstd.verifyprimenumber();
		cstd.verifynonprimenumber();
		cstd.findfactorialnumber();
	}
}