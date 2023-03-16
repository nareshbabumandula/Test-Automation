package com.oops;

public interface RBI extends Banking, FederalReserve{
	
	int minBalance=5000;  // by default variable in an interface will be final and abstract (we can't assign any other value to minBalance variable)
	
	// By default all the methods and variables in am interface are abstract and final
	void accountType();
	void minBalance();
	void minDeposit();
	void loans();
	void maxDeposit();
	void minWithDrawl();
	void maxWithDrawl();
	void KYC();
	
	/**
	 * default method
	 * Default methods enable you to add new functionality to the interfaces of your libraries and ensure
	   binary compatibility with code written for older versions of those interfaces.
	 */
	default void mutualFunds() {
		System.out.println("This is a default method in an interface..!");
	}
	
	/**
	 * static method
	 * A static method is a method that is associated with the class in which it is defined rather than with any object.
	 * Java interface static method helps us in providing security by not allowing implementation classes to override them
	 */
	public static void retirementPlan() {
		System.out.println("This is a static method in an interface..!");
	}
	
	public static void main(String[] args) {
		// RBI r = new RBI();
		retirementPlan();
	}

}
