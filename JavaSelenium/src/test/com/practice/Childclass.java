package test.com.practice;

public class Childclass extends  Parentclass{

	String name;
	void display() {
		System.out.println();
	}
	String colour;
	void colour() {
		System.out.println();
	}
	String st= "beautiful";
	void word(){
		System.out.println(st.toUpperCase());
		System.out.println(st.length());
		System.out.println(st.contains("t"));
		System.out.println(st.charAt(0));
		System.out.println(st.charAt(3));
		System.out.println(st.hashCode());
	}
	byte a=22;
	byte b=67;
	byte c=19;
	byte d=68;
	byte e=88;
	byte f=92;

	void addition() {
		int Z=a+b;
		System.out.println("Addition of a and b="+Z);
	}
	void division() {
		int Z = e/a;
		System.out.println("Division of e/a = " +Z );
	}
	void modulus(){
		int Z =f%a;
		System.out.println("modulus of f/a = " +Z);
	}
	public static void main(String[] args) {
		//object forchildclass
		Childclass cc=new Childclass();
		cc.addition();
		cc.division();
		System.out.println(cc.a);
		cc.name= "keerthana";
		System.out.println("Name:"+cc.name);
		//upcasting
		Parentclass pc=new Childclass();//upcasting
		cc.name= "keerthana";
		System.out.println("Name:"+cc.name);
		pc.name= "divya";
		System.out.println("Name:"+pc.name);
		cc.colour="white";
		System.out.println("colour:"+cc.colour);
		cc.addition();
		pc.addition();
		pc.division();
		cc.division();
		pc.multiplication();
		cc.multiplication();
		System.out.println(pc.a);
		System.out.println(cc.a);

		Parentclass pc1=cc;
		//downcasting
		Childclass cc1=(Childclass)pc1;
		cc.name= "rakshitha";
		System.out.println("Name:"+cc.name);
		cc.word();
		cc1.addition();
		System.out.println(cc1.f);
		cc1.modulus();

	}
}





