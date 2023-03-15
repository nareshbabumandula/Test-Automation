package com.oops;

public class IMAX extends Theatre{

	
	@Override
	void parking() {
		System.out.println("Parking facility is available to park 200 cars and 400 bikes");
	}

	@Override
	void cafeteria() {
		System.out.println("Cafeteria facility is available");
	}

	@Override
	void emergencyExit() {
		System.out.println("12 emergency exists are available");
	}
	
	public static void main(String[] args) {
		IMAX im = new IMAX();
		im.parking();
		im.cafeteria();
		im.emergencyExit();
		im.onlineticketBooking();
	}


}
