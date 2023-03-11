package selenium.practice;

public class JavaStringMethods {

	public static void main(String[] args) {
		/*String s = "hello";
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
		System.out.println(s + " " + st + " " + str );  */
		JavaStringMethods sm = new JavaStringMethods();
		sm.stringMethodsPractice();
		sm.printLetters();
	}
	//Practice
	void stringMethodsPractice() {
		String country = "India";
		String launguage = "Telugu Hindi Tamil Malayalam Kannada";
		String state = "Andhra Pradesh, Telangana, Kerala, Tamil Nadu, Karnataka";
		String ex = "    Trim Method    ";
		System.out.println(country.contains("a"));
		System.out.println(launguage.charAt(3));
		System.out.println(state.concat(" states in india"));
		System.out.println(ex.trim());
		System.out.println(launguage.indexOf('a'));
		String split[] = state.split(", ");
		System.out.println(split[3]);	
		System.out.println(launguage.startsWith("Telugu"));
		String sp[] = launguage.split(" ");
		System.out.println(sp[0].concat(" " + split[0]));
		System.out.println(country.hashCode());
		System.out.println(launguage.hashCode());
		System.out.println(state.hashCode());
		System.out.println(split.hashCode());
		System.out.println(state.replace("Telangana", "Andhra Pradesh"));
		System.out.println(ex.substring(10,15));
	}
	void printLetters() {
		String l = "Automation";
		int n = l.length();
		for(int i=0;i<n;i++) {
			System.out.println(l.charAt(i));
		}
	}
}
