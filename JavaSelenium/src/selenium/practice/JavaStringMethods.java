package selenium.practice;

public class JavaStringMethods {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s.hashCode());
		String st = "HELLO";
		System.out.println(st.hashCode());
		String str = "Hello World.";
		System.out.println(str.hashCode());
		System.out.println(s.toUpperCase());
		System.out.println(st.toLowerCase());
		System.out.println(str.length());
		System.out.println(str.charAt(8));
		System.out.println(s.indexOf('l'));
		System.out.println(str.replace("World", "My World"));
		System.out.println(st.equals("Hello"));
		System.out.println("Contains " + str.contains("Hello"));
		System.out.println("Starts with "+ str.startsWith("Hello"));
		System.out.println("Ends with " + str.endsWith("World."));
		System.out.println(st.equals(s.toUpperCase()));
		System.out.println(str.substring(6,12));
		String ss[] = str.split(" "); 
		System.out.println(str.concat(" ").concat(ss[0]));
		System.out.println(s + " " + st + " " + str );
	}

}
