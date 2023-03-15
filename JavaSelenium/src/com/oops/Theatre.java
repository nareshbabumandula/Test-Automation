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
      

	public static void main(String[] args) {
		// Theatre t = new Theatre();
	}

}
