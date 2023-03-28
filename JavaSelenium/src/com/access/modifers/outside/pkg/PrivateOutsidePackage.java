package com.access.modifers.outside.pkg;

import com.access.modifers.ProtectedTest;

public class PrivateOutsidePackage extends ProtectedTest{

	public static void main(String[] args) {
		System.out.println("Accessing protected access modifer outside the package..!");
//		ProtectedTest pt = new ProtectedTest();
//		System.out.println(pt.url);
//		System.out.println(pt.username);
//		System.out.println(pt.password);
//		pt.accessSite();
//		pt.login();
		
		PrivateOutsidePackage pop = new PrivateOutsidePackage();
		System.out.println(pop.url);
		System.out.println(pop.username);
		System.out.println(pop.password);
		pop.accessSite();
		pop.login();
	}
}
