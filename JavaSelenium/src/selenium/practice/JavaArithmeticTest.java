package selenium.practice;

public class JavaArithmeticTest {
	int a = 10;
	int b = 20;
	int c = 30;

	void Addition() {	
		int d = a+b+c;
		System.out.println(d);
	}
	
	void Subtraction() {	
		int d = c-a;
		System.out.println(d);
	}
	
	void Multiplication() {	
		int d = a*b*c;
		System.out.println(d);
	}
	
	void Division() {	
		int d = c/a;
		System.out.println(d);
	}

	public static void main(String[] args) {
		JavaArithmeticTest arthm = new JavaArithmeticTest();
		arthm.Addition();
		arthm.Subtraction();
		arthm.Multiplication();
		arthm.Division();
		

	}

}
