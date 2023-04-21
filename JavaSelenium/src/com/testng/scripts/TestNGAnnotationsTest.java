package com.testng.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsTest {

	@BeforeSuite
	public void verifyAccessSite(){
		System.out.println("Successfully accessed the amazon portal..!");
	}
	
	@BeforeTest
	public void verifyRegistration(){
		System.out.println("Successfully registered the user..!");
	}
	
	@BeforeClass
	public void verifyLogin(){
		System.out.println("Successfully logged in..!");
	}

	@Test(priority = 0)
	public void searchProduct(){
		System.out.println("Successfully searched the product..!");
	}

	@Test(priority = 1, invocationCount = 2)
	public void verifyAddToCart(){
		System.out.println("Successfully added the product to the cart..!");
	}

	@Test(priority = 2)
	public void verifyCheckout(){
		System.out.println("Successfully checked out the product..!");
	}
	
	@Test(priority = 3)
	public void verifyProceedToPay(){
		System.out.println("Successfully proceeded for the payment..!");
	}

	@Test
	public void verifyPayment(){
		System.out.println("Successfully done the payment for the product..!");
	}
	
	@Test(dependsOnMethods = {"verifyPayment"})
	public void verifyCancelOrder(){
		System.out.println("Successfully cancelled the order..!");
	}
	
	@AfterClass
	public void verifyRefunds(){
		System.out.println("Successfully refunded the amount for the product..!");
	}
	
	@AfterTest
	public void verifyLogout(){
		System.out.println("Successfully logged out from the application..!");
	}
	
	@AfterSuite
	public void closeBrowser(){
		System.out.println("Closed the browser..!");
	}

}
