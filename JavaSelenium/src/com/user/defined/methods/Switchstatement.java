package com.user.defined.methods;

public class Switchstatement {

	// Generate and send coupons from outlet mall

	public static void main(String[] args) {
		int brand = 4;
		String name;

		switch(brand){
		case 1: 
			name = "Nike";
			break;

		case 2:
			name = "Guess";
			break;

		case 3:
			name = "Prada";
			break;

		case 4:
			name = "Louis Vuitton";
			break;
			
		case 5:
			name =" GAP";
			break;
			
		default:
			name = "Invalid name";
			break;

		}

		System.out.println("Generate and send coupons for: " + name);
		

	} 

}

