package com.selenium.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserTest {

	WebDriver driver;

	// The annotated method will be run before the first test method in the current class is invoked.
	@BeforeClass 
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		System.out.println("Launched the browser..!");
	}
	
	@Test
	public void browserMethods() throws InterruptedException {
		driver.manage().window().maximize();
		System.out.println("Browser title is : " + driver.getTitle());
		System.out.println("Brwoser current url is : " + driver.getCurrentUrl());
		driver.navigate().to("https://www.mycontactform.com/samples.php");
		Thread.sleep(3000);
		System.out.println("Browser title is : " + driver.getTitle());
		System.out.println("Brwoser current url is : " + driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("Successfully performed the actions on a browser..!");
	}

	// The annotated method will be run after all the test methods in the current class have been run.
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Closed the browser..!");
	}


}
