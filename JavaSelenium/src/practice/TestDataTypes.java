package practice;

public class TestDataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Byte Type:");
		System.out.println("-----------");
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println("Short Type:");
		System.out.println("-----------");
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println("Integer Type:");
		System.out.println("-----------");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println("Long Type:");
		System.out.println("-----------");
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println("Float Type:");
		System.out.println("-----------");
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println("Double Type:");
		System.out.println("-----------");
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println("-----------");
		System. out.println("STRING Methods :");
		System.out.println("-----------");
		String str1 ="hello";
		System.out.println(str1.hashCode());
		String str2= "HELLO";
		System.out.println(str2.hashCode());
		// Using in-built or Built-in String class methods for String manipulation. In Java, strings are stored in the heap area.
		System.out.println(str1.toUpperCase());
		System.out.println(str2.toLowerCase());
		System.out.println(str1.length()); // Returns the string length
		System.out.println(str2.charAt(3));  // Returns the char value at the specified index
		System.out.println(str2.indexOf('O')); // Returns the index value at the specified character

		System.out.println(str1.equals("hello")); // We can use .equals() method for content comparison
		String st = "hello";
		System.out.println(str1.hashCode() + " " + st.hashCode());
		String strng = new String("HELLO"); // Creating object reference strng for String class
		System.out.println(str2==strng); // We can use == operators for reference comparison (address comparison)
		System.out.println(str1.contains("l"));

		System.out.println(str2.endsWith("LO"));
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(st.equals(str2.toLowerCase()));

		System.out.println(str1.codePointBefore(2));
		System.out.println(st.concat(str2));
		System.out.println(st.compareToIgnoreCase(str2));
	}

}
