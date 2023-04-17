package com.selenium.scripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleWindowsTest {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		/**
		 * What is same-origin policy in Selenium Webdriver?
           First of all “Same Origin Policy” is introduced for security reason, and it ensures that content of your site
           will never be accessible by a script from another site.
		 */
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	void multipleWindowExample() throws InterruptedException {
		String mainwindow = driver.getWindowHandle();
		System.out.println("Main window session ID is : " + mainwindow);
		driver.findElement(By.xpath("//ul[contains(@class,'nav navbar-nav lp-navbar-advanced-root normal-main-header')]/li[2]/a")).sendKeys(Keys.CONTROL,Keys.ENTER);
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator<String> iter = windows.iterator();
		
		while (iter.hasNext()) {
			String childwindow = iter.next();
			if (!mainwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.id("search-chatInput")).sendKeys("NRI Banking Services");
				Thread.sleep(2000);
				driver.close();
			}
			
		}
		driver.switchTo().window(mainwindow);
		driver.findElement(By.id("search-chatInput")).sendKeys("Home loan Services");
		
	}
	
	@AfterClass
	void closeBroswer() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
