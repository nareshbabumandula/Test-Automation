package practice;

public class DataTypesDemo {

	public static void main(String[] args) {
		// Primitive data types - 8 types (byte, short, int, long, float, double, char, boolean)
		byte b = 85;
		System.out.println("Byte value is : " + b);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		short s = 32566;
		System.out.println("Short value is : " + s);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		int i = 34444;
		System.out.println("Integer value is : " + i);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		long l=245888;
		System.out.println("Long value of l:"+l);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		float f=(float) 110.98;
		System.out.println("float value of f:"+f);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		double d=478.668;
		System.out.println("Double value of d:"+d);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		// Non primitive data types
		String str = "hello world";
		System.out.println(str);
		// primitive data types 23 feb
		char c = 'b';
		System.out.println("Character value of c is : " + b);
		// Non primitive data types
		System.out.println("Hai..");
		System.out.println("How are you?");
		System.out.println("Fine");
		System.out.println("Where are you..");
		System.out.println("In eclipse");
		//
		String str1 ="Something";
		System.out.println(str1.hashCode());
		String str1Text ="As your wish we can type anything";
		System.out.println(str1Text.hashCode());
		System.out.println(str1.toLowerCase());
		System.out.println(str1Text.toLowerCase());
		System.out.println(str1.length());
		System.out.println(str1Text.length());
		System.out.println(str1.contains("something"));
		System.out.println(str1.contains("Something"));
		System.out.println(str1.replace("Something","Anything"));
		System.out.println(str.endsWith(str1Text));
		System.out.println(str1.equals(str1Text));
		String str2="Something";
		System.out.println(str1.equals(str2));	
		

		System.out.println(str1.isBlank());
		System.out.println(str2.isEmpty());
		System.out.println(str1Text.concat(str1));
		System.out.println(str1.concat("    ").concat(str2));
		String asText[] =str1Text.split(" ");
		System.out.println(asText[0]);
		System.out.println(asText[1]);
		System.out.println(asText[2]);
		System.out.println(asText[3]);
		System.out.println(asText[4]);
		System.out.println(asText[5]);
		System.out.println(asText[6]);
	
		
		
		

				
		
	}
}
