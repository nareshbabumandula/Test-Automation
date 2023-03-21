package com.accessspecifiers;

class DefaultModifier {
	String str="Default";
	void defaultMethod() {
		System.out.println("This is a Default Method..");
	}
	public static void main(String[] args) {

		DefaultModifier dm=new DefaultModifier();
		System.out.println("Access Modifier is : "+dm.str);
		dm.defaultMethod();
	}
}
