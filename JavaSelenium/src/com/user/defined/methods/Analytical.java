package com.user.defined.methods;

public class Analytical {

	private static Object elseif;

	// Validate logical operations 

	public static void main(String[] args) {
		// assign values to variables 

		int a = 10, b = 20, c = 60, d = 40;

		// Print a, b, c
		System.out.println("Var1 = " + a);
		System.out.println("Var2 = " + b);
		System.out.println("Var3 = " + c);

		// verify greater than and equal to operations 
		if ((a < b) && (b == c)) {
			d = a + b + c;
			System.out.println("The sum is: " + d);
		}
		else if ((a<b) && (c>d)) {

			d= a +b +c;
			System.out.println("The sum is: " + d);


		}
		else {
			System.out.println(" None of the statement satifies its a False conditions");

		}

	}
}
