package com.accessspecifiers;

public class PrivateModifier {
	private String str="Private";
	private void privateMethod() {
		System.out.println("This is a Private method..");
	}

	public static void main(String[] args) {

		PrivateModifier pm=new PrivateModifier();
		System.out.println("Access Modifier is : "+pm.str);
		pm.privateMethod();
	}
}
