package com.oops;

public class PVR extends Theatre{


	@Override
	void parking() {
		System.out.println("Parking facility is available to park 100 cars and 300 bikes");
	}

	@Override
	void cafeteria() {
		System.out.println("Cafeteria facility is available");
	}

	@Override
	void emergencyExit() {
		System.out.println("8 emergency exists are available");
	}
	
	public PVR() {
		super.onlineticketBooking();
		//super(1,2);
	}

	
	public static void main(String[] args) {
		PVR p = new PVR();
		p.parking();
		p.cafeteria();
		p.emergencyExit();
		p.onlineticketBooking();
		soundSystem(); // static method of an abstract class

	}

}
