package com.access.modifers;

public class PrivateTest {
	
	private String url="https://www.spicejet.com";
	private String username="testuser";
	private String password="secure*123";
	
	private void accessSite() {
		System.out.println("Successfully accessed the spicejet portal with url : " + url);
	}
	
	private void login() {
		System.out.println(username + " successfully logged in..!");
	}
	
	private PrivateTest() {
		System.out.println("This is a private constructor..!");
	}

	public static void main(String[] args) {
		PrivateTest pt = new PrivateTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
