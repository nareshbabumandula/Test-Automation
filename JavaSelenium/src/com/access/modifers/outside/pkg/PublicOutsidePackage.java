package com.access.modifers.outside.pkg;

import com.access.modifers.PublicTest;

public class PublicOutsidePackage {

	public static void main(String[] args) {
		System.out.println("Accessing public access modifier outside the package..!");
		PublicTest pt = new PublicTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();

	}

}
