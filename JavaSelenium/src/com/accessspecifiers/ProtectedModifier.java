package com.accessspecifiers;

public class ProtectedModifier {
	protected String str="Protected";
	protected void protectedMethod() {
		System.out.println("This is a Protected method..");
	}
	public static void main(String[] args) {

		ProtectedModifier prm=new ProtectedModifier();
		System.out.println("Access Modifier is : "+prm.str);
		prm.protectedMethod();
	}
}
