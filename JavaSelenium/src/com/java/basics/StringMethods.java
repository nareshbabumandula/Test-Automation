package com.java.basics;

public class StringMethods {

	public static void main(String[] args) {
		
		String str ="hello";
		System.out.println(str.hashCode());
		String sText= "HELLO";
		System.out.println(sText.hashCode());
		String strText = "Make meaningful connections with meetings, team chat, whiteboard, phone, and more in one offering.";
		System.out.println(strText.hashCode());
		// Using in-built or Built-in String class methods for String manipulation. In Java, strings are stored in the heap area.
		System.out.println(str.toUpperCase());
		System.out.println(sText.toLowerCase());
		System.out.println(str.length()); // Returns the string length
		System.out.println(sText.charAt(1));  // Returns the char value at the specified index
		System.out.println(sText.indexOf('H')); // Returns the index value at the specified character
		System.out.println(strText.replace("Make", "Make the"));
		System.out.println(str.equals("hello")); // We can use .equals() method for content comparison
		String s = "hello";
		System.out.println(str.hashCode() + " " + s.hashCode());
		String st = new String("hello"); // Creating object reference (st) for String class
		System.out.println(str==st); // We can use == operators for reference comparison (address comparison)
		System.out.println(str.contains("l"));
		System.out.println(strText.contains("meetings"));
		System.out.println(strText.endsWith("offering."));
		System.out.println(str.equalsIgnoreCase(sText));
		System.out.println(str.equals(sText.toLowerCase()));
	}

}
