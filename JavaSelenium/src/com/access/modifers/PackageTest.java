package com.access.modifers;

public class PackageTest {
	
	String url="https://www.spicejet.com";
	String username="testuser";
	String password="secure*123";
	
	void accessSite() {
		System.out.println("Successfully accessed the spicejet portal with url : " + url);
	}
	
	void login() {
		System.out.println(username + " successfully logged in..!");
	}
	
	PackageTest() {
		System.out.println("This is a package constructor..!");
	}

	public static void main(String[] args) {
		PackageTest pt = new PackageTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
