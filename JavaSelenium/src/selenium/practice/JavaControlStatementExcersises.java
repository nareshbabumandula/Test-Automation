package selenium.practice;

public class JavaControlStatementExcersises {

	void reverseOrder() {

		for(int i=10; i>0; i--) {
			System.out.println(i);
		}
	}

	void primeOrNot(int a) {
		/* Number should be greater than 1
		 * Divisible by 1 and itself
		 */
		int count=0;
		if(a>1) {
			for(int i=1;i<=a;i++) {
				if(a%i==0) {
					count++;
				}
			}
			if(count==2) {
				System.out.println(a +" : is a Prime Number.");
			}
			else {
				System.out.println(a +" : is not a Prime Number.");
			}
		}
		if(a<=1) {
			System.out.println(a +" : is not a Prime Number.");
		}
	}

	void printPrimeNums(int num) {
		for(int i=2;i<num;i++) {
			int count=0;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if (count==0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	void factorialOfNum(int n) {
		int s=1;
		for (int i=n;i>0;i--) {
			s = s*i;
		}
		System.out.println("The Factorial of " + n + " is : "+ s);
	}
	void numSequence() {
		int num = 1; 
		System.out.println("The Numbers are : ");
		for(int i=1;i<10;i++) {
			num = num + 3;
			System.out.print(num + " ");
		}
	}

	public static void main(String[] args) {
		JavaControlStatementExcersises cse = new JavaControlStatementExcersises();
		cse.reverseOrder();
		cse.primeOrNot(51);
		cse.printPrimeNums(100);
		cse.factorialOfNum(6);
		cse.numSequence();
	}

}
