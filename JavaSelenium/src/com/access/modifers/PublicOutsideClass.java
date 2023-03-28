package com.access.modifers;

public class PublicOutsideClass {

	public static void main(String[] args) {
		System.out.println("Acessing public access modifier outside the class..!");
		PublicTest pt = new PublicTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
