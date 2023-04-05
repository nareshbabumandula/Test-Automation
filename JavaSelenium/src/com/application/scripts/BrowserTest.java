package com.application.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserTest {

	WebDriver driver;

	@Test
	public void BrowserMethod() throws InterruptedException {
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.mycontactform.com/samples.php");
		driver.navigate().to("https://www.mycontactform.com/features.php");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String mainWindow=driver.getWindowHandle();
		System.out.println("session id"+mainWindow);
		System.out.println(driver.getPageSource());
		System.out.println("successfully opend browser");

	}
	@BeforeClass
	public void Openbrower() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");

		System.out.println("open the browser");
	} 

	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit(); 
		System.out.println("close  the browser");
	}

}


