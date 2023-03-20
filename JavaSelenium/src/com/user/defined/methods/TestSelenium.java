package com.user.defined.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	WebDriver driver = new ChromeDriver();

	void siteAccess() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println(" Site Accessed...");
	}
	void loginAccess(String username) {
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nirmala@gmail.com");
		System.out.println("Successfully logged in with the user : " + username);
	}
	void logout() throws InterruptedException {
		System.out.println("Successfully logged out from the application");
		Thread.sleep(3000);
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		TestSelenium TS = new TestSelenium();
		TS.siteAccess();
		TS.loginAccess("Nirmala");
		TS.logout();
	}
}

