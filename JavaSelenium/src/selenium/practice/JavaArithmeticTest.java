package selenium.practice;

public class JavaArithmeticTest {
	int a = 10;
	int b = 20;
	int c = 30;

	void Addition() {	
		int d = a+b+c;
		System.out.println("Addition of three numbers:" + d);
	}
	
	void Subtraction() {	
		int d = c-a;
		System.out.println(d);
	}
	
	void Multiplication(int a, int b, int c) {	
		int d = a*b*c;
		String s = "Multiplication of three numbers :"; 
		System.out.println(s + d);
	}
	
	int Division() {	
		int d = c/a;
		return d;
	}

	public static void main(String[] args) {
		JavaArithmeticTest arthm = new JavaArithmeticTest();
		arthm.Addition();
		arthm.Subtraction();
		arthm.Multiplication(1,10,100);
		System.out.println("Division of two numbers: " + arthm.Division());
	}

}
