package com.java.oops;

public class Car extends Vehicle{
	static int maxSpeed=300;

	public static void main(String[] args) {
		
		System.out.println("maxSpeed:" +maxSpeed);
		
		Vehicle V1=new Car();
		System.out.println(V1.maxSpeed);
		
		Car c=new Car();
		Vehicle V2= c;
		Car car= (Car)V2;;
		System.out.println(car.maxSpeed);
	
	}

}

