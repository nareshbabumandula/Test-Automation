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
		System.out.println("String starts with status is : " + strText.startsWith("Make"));
		System.out.println(strText.endsWith("offering."));
		System.out.println(str.equalsIgnoreCase(sText));
		System.out.println(str.equals(sText.toLowerCase()));
		System.out.println(strText.substring(0, 6));
		System.out.println(str.concat(" ").concat(sText));
		System.out.println(str + " " + sText);
		System.out.println(str.isBlank());
		System.out.println(str.isEmpty());
		String string = "";
		System.out.println(string.isBlank());
		System.out.println(string.isEmpty());
		String ss = null;
		//System.out.println(ss.isBlank());
		//System.out.println(ss.isEmpty());
		
		String asText[] = strText.split(" ");
		System.out.println(asText[0]);
		System.out.println(asText[1]);
		System.out.println(asText[2]);
		System.out.println(asText.length);
		// System.out.println(asText[50]);  // java.lang.ArrayIndexOutOfBoundsException
		
		for(int i=0; i<asText.length;i++) {
			String value = asText[i];
			System.out.println(value);
		}
		System.out.println("Foreach loop started..!");
		for (String element : asText) {
			System.out.println(element);
		}
	}

}
