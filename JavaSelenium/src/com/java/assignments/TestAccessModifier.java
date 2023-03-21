package com.java.assignments;
import com.accessspecifiers.*;

public class TestAccessModifier extends ProtectedModifier {

	public static void main(String[] args) {
		//we cannot access the Private-methods,variables outside of the class and Package
		/*PrivateModifier pm=new PrivateModifier();
		pm.privateMethod();
		System.out.println("Access Modifier is : "+pm.str);
		*/
		
		PublicModifier pub=new PublicModifier();
		pub.publicMethod();
		System.out.println("Access Modifier is : "+pub.str);
		
		//we cannot access the Protected-methods,variables outside of the Package
		/*ProtectedModifier pro=new ProtectedModifier();
		pro.protectedMethod();
		System.out.println("Access Modifier is : "+pro.str);
		*/
		
		//we cannot access the default-methods,variables outside of the Package
		/*DefaultModifier dm=new DefaultModifier();
		dm.defaultMethod();
		System.out.println("Access Modifier is : "+dm.str);
		*/
	}
}
