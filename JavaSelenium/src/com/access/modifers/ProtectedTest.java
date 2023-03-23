package com.access.modifers;

public class ProtectedTest {
	
	protected String url="https://www.spicejet.com";
	protected String username="testuser";
	protected String password="secure*123";
	
	protected void accessSite() {
		System.out.println("Successfully accessed the spicejet portal with url : " + url);
	}
	
	protected void login() {
		System.out.println(username + " successfully logged in..!");
	}
	
	protected ProtectedTest() {
		System.out.println("This is a protected constructor..!");
	}

	public static void main(String[] args) {
		ProtectedTest pt = new ProtectedTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
