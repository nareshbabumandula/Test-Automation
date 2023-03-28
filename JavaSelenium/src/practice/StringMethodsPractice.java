package practice;

import java.util.Iterator;

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
		
		System.out.println(st.isEmpty());
		System.out.println(str.isBlank());
		String p=" ";
		System.out.println(p.isEmpty());
		System.out.println(p.isBlank());
		System.out.println(s.length());
		
		
		
		  for(int i=0; i<s.length(); i++) { 
			  System.out.println(s.charAt(i)); }
			 
		String wordsofs[] = s.split(" ");
		System.out.println(wordsofs[0]);
		//System.out.println(wordsofs[50]);
		
		for(int i=0; i<wordsofs.length; i++) {
			System.out.println(wordsofs[i]);
			
		}
		
		
	
	}

}