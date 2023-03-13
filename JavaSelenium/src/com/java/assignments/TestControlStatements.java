package com.java.assignments;

public class TestControlStatements {

	void reverseOrder() {
		int i,n=100;
		System.out.println("Reverse Order of 1 to 100 : ");
		/*for(i=1;i<=n;n--) {
			System.out.println( n );
		}*/
		for(i=n;i>=1;i--) {
			System.out.print(i+" ");
		}
	}

	void primeOrNot(int n) {
		System.out.println("Given number is Prime or not ?");
		System.out.println("Enter number : " +n);
		if(n==1)
			System.out.println(n+" is a Prime number");
		int c=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0)
				c++;
		}
		if(c==2)
			System.out.println(n+" is a Prime number");
		else
			System.out.println(n+" is not a Prime number");
	}
	void primeSeries() {
		int i,j,n=100;
		System.out.println("Prime numbers upto "+n);
		for(i=1;i<=n;i++) {
			if(i==1)
				System.out.print(i+" ");
			int c=0;
			for(j=1;j<=i;j++) {
				if(i%j==0) {
					c++;
				}
			}
			if(c==2)
				System.out.print(i+" ");
		}
	}
	void factorial(int n) {
		System.out.println(" Factorial of " + n);
		int f = 1;
		for(int i=1;i<=n;i++) {
		System.out.print(i+" * ");
		f = f * i;
		}
		System.out.println("Factorial of "+n+" = "+f);
	}
	void printNumbers(int n) {
		int c=1;
		System.out.println("Given Ordered List : ");
		System.out.print(c+" ");
		for(int i=1;i<=n;i++) {
			c = c + 3;
			System.out.println(c+" ");
		}
	}
	
	public static void main(String[] args) {

		TestControlStatements tcs = new TestControlStatements();
		tcs.reverseOrder();
		tcs.primeOrNot(31);
		tcs.primeSeries();
		tcs.factorial(10);
		tcs.printNumbers(10);
	}

}