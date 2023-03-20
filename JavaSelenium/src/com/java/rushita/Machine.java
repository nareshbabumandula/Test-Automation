package com.java.rushita;

public class Machine {
	public static String method;



	public void start() {
		// TODO Auto-generated method stub

		System.out.println("tims camera started...");
	}
	public void snap() {
		// TODO Auto-generated method stub
		System.out.println("tims snap captured..");
	}
	public static void main(String[] args) {
		Machine mac=new Machine();
		mac.start();
		mac.snap();
	}

}