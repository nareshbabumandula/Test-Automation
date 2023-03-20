package com.accessspecifiers;

public class PublicModifier {

	public String str="Public";
	public void publicMethod() {
		System.out.println("This is a Public method..");
	}
	public static void main(String[] args) {

		PublicModifier pbm=new PublicModifier();
		System.out.println("Access Modifier is : "+pbm.str);
		pbm.publicMethod();
	}
}
