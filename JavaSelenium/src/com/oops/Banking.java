package com.oops;

public interface Banking extends FederalReserve{
	int minBalance=1000;
	String accountType="personal";
	
	void creditCard();

}
