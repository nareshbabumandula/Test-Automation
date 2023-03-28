package com.access.modifers;

public class PackageOutsideClass {

	public static void main(String[] args) {
		System.out.println("Acessing package access modifier outside the class..!");
		PackageTest pt = new PackageTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
