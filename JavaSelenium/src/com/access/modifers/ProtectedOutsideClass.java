package com.access.modifers;

public class ProtectedOutsideClass {

	public static void main(String[] args) {
		System.out.println("Acessing protected access modifier outside the class..!");
		ProtectedTest pt = new ProtectedTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
