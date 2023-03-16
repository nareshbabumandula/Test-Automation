package com.oops;

abstract class Theatre {
	
	// abstract method or method without body
	abstract void parking();
  
    abstract void cafeteria();
    
    abstract void emergencyExit();
    
    
    // non abstract method or method with body
    void onlineticketBooking() {
    	System.out.println("Online ticket booking facility..!");
    }
    
    static void soundSystem() {
    	System.out.println("Dolby digital sound system..!");
    }
    
    // Constructor
    public Theatre() {
		System.out.println("This is a no argument constructor..!");
	}
      

	public static void main(String[] args) {
		// Theatre t = new Theatre();
		soundSystem();

	}

}
