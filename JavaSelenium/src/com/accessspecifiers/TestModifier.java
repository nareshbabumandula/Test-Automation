package com.accessspecifiers;

public class TestModifier {

	public static void main(String[] args) {
		//we cannot access the Private-methods,variables outside of the class
		/*PrivateModifier pm=new PrivateModifier();
		pm.privateMethod();
		System.out.println("Access Modifier is : "+pm.str);
		*/
		PublicModifier pub=new PublicModifier();
		pub.publicMethod();
		System.out.println("Access Modifier is : "+pub.str);
		
		ProtectedModifier pro=new ProtectedModifier();
		pro.protectedMethod();
		System.out.println("Access Modifier is : "+pro.str);
		
		DefaultModifier dm=new DefaultModifier();
		dm.defaultMethod();
		System.out.println("Access Modifier is : "+dm.str);

	}
}