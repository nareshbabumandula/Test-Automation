package practice;

public class StringMethodsPractice {

	public static void main(String[] args) {
		System.out.println("Hello");
		String str = "HELLO WORLD";
		String strs=  "HELLO WORLD";
		String st = "hello world";
		String s = "If you cannot make your mind peaceful, making the world peaceful is out of the question.";
		System.out.println(st.hashCode());
		System.out.println(s.endsWith("question."));
		System.out.println(s.charAt(0));
		System.out.println(s.toUpperCase());
		System.out.println(str.length());
		System.out.println(str.toLowerCase());
		System.out.println(s.contains("mind"));
		System.out.println(st.replace("hello world", "Wonderfull world"));
		System.out.println(st.equals(str));
		System.out.println(str.matches(s));
		System.out.println(str.hashCode());
		System.out.println(strs.hashCode());
				
		
	}

}