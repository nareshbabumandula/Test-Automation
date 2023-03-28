package com.access.modifers;

public class PublicTest {
	
	public String url="https://www.spicejet.com";
	public String username="testuser";
	public String password="secure*123";
	
	public void accessSite() {
		System.out.println("Successfully accessed the spicejet portal with url : " + url);
	}
	
	public void login() {
		System.out.println(username + " successfully logged in..!");
	}
	
	public PublicTest() {
		System.out.println("This is a public constructor..!");
	}

	public static void main(String[] args) {
		PublicTest pt = new PublicTest();
		System.out.println(pt.url);
		System.out.println(pt.username);
		System.out.println(pt.password);
		pt.accessSite();
		pt.login();
	}

}
