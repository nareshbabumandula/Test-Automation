package com.oops;

public class ICICI implements RBI{

	@Override
	public void accountType() {
		System.out.println(accountType);
		System.out.println("Account type is personal");
	}

	@Override
	public void minBalance() {
		//minBalance=1000;
		System.out.println(minBalance);
		//System.out.println("Minimum balance is : " + minBalance);
	}
	
	@Override
	public void minDeposit() {
		System.out.println("Min deposit balance is 100 rupees");
	}

	@Override
	public void loans() {
		System.out.println("Personal, Home, Auto and Commercial loans facility is available");
	}

	@Override
	public void maxDeposit() {
		System.out.println("Max deposit amount is 2 lakhs per day");
	}

	@Override
	public void maxWithDrawl() {
		System.out.println("Maximum withdrawl amount is 1 lakh per day");
	}

	@Override
	public void KYC() {
		System.out.println("KYC for every customer is mandatory");
	}
	
	@Override
	public void minWithDrawl() {
		System.out.println("Maximum withdrawl amount is 100 rupees per transaction");
	}

	public static void main(String[] args) {
		ICICI icici = new ICICI();
		icici.minBalance();
		icici.maxDeposit();
		icici.minDeposit();
		icici.KYC();
		icici.loans();
		icici.maxWithDrawl();
		icici.minWithDrawl();
		icici.accountType();
		icici.mutualFunds(); // default method
		RBI.retirementPlan(); // static method
		System.out.println(icici.minBalance);
		icici.creditCard();
	}

	@Override
	public void creditCard() {
		System.out.println("Credit card facility is available");
		
	}
	
}
