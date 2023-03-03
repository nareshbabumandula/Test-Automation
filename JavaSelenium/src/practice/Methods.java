package practice;

public class Methods {
	int x=20;
	int y=30;
	public void addition() {
		int z=x+y;
		System.out.println("Addition value of z: "+z);
	}
	
	public void subtraction() {
		int z=x-y;
		System.out.println("subtraction value of z:"+z);
	}
	
	public int multiplication(int a,int b) {
		int c=a*b;
		return c;
	}
	
	public int division(int a,int b) {
		int c=a/b;
		return c;
	}
	
	public int modulus( int a,int b) {
		int c=a%b;
		return c;
	}
	public static void main(String[] args) {
		Methods meth = new Methods();
		meth.addition();
		meth.subtraction();
		System.out.println("Multiplication value of c:"+meth.multiplication(10, 5));
		System.out.println("Division value of c:"+ meth.division(20,5));
		System.out.println("modulus value of c:"+ meth.modulus(20,5));
		
	}

}
