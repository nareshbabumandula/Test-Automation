package com.user.defined.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Generic {
	
	WebDriver driver;
	
	void accessSite() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(); // Launches chrome browser
		driver.get("https://www.firstcry.com/");
		driver.manage().window().maximize();
		System.out.println("accessed Site");
	}
	
	void login(String username) {
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("keerthana@gmail.com");
		System.out.println("Successfully logged in with the user : " + username);
	}
	
	void searchProduct(String product) {
		System.out.println("Successfully searched the product : " + product);
	}
	
	boolean addToCart() {
		System.out.println("Successfully added the product to the cart");
		return true;
	}

	void logout() throws InterruptedException {
		System.out.println("Successfully logged out from the application");
		Thread.sleep(4000);
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		Generic gen = new Generic();
		gen.accessSite();
		gen.login("padma");
		gen.searchProduct("iPhone");
		System.out.println(gen.addToCart());
		gen.logout();

	}

}
