package com.java.oops;

public class NimitsCamera extends Machine {
	public void start() {
		System.out.println("nimits camera started..");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Machine m1=new NimitsCamera();
		m1.start();
		m1.snap();
		
		NimitsCamera nim=new NimitsCamera();
		Machine m=nim;
		NimitsCamera n=(NimitsCamera)m;
		n.start();

}
}