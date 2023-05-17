package com.access.modifers;

public class SingletonClass {  

	private static SingletonClass instance = null;  
	public String str;  

	private SingletonClass() {

	}

	// static method which returns the object of this class
	public static SingletonClass getInstance() {  
		if (instance == null){  
			instance = new SingletonClass();  
		}  
		return instance;  
	}  

	public static void main(String[] args) {  
		// TODO Auto-generated method stub  
		SingletonClass single1 = SingletonClass.getInstance();  
		single1.str = "Hi I am the singleton class string";  
		SingletonClass single2 = SingletonClass.getInstance();  
		single2.str = "Hi I am the other string";  
		SingletonClass single3 = SingletonClass.getInstance();  
		single3.str = "I am some other string";  
		System.out.println("first reference: "+single1.str);  
		System.out.println("second reference: "+single2.str);  
		System.out.println("third reference: "+single3.str);  
		System.out.println(single1.hashCode());
		System.out.println(single2.hashCode());
		System.out.println(single3.hashCode());

	}  
}  
