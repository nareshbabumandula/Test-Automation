package com.selenium.scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class BrowserTest {
	static  ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		System.out.println("Launch the Browser");
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("TC001");
	}
	@Test
	public void browserMethod() throws InterruptedException {
		try {
			driver.manage().window().maximize();
			String strTitle = driver.getTitle();
			System.out.println("Current url is "+driver.getCurrentUrl());
			System.out.println("Title is "+strTitle);
			driver.navigate().to("https://tinyurl.com/527wzfyf");
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().forward();
			Thread.sleep(3000);
			driver.navigate().refresh();
			String mainWindow = driver.getWindowHandle();
			System.out.println("Session Id is "+mainWindow);
			// Opens a new window and switches to new window
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("https://www.firstcry.com/");
			driver.findElement(By.id("search_box")).clear();
			driver.findElement(By.id("search_box")).sendKeys("pampers");
			driver.findElement(By.className("search-button")).click();
			System.out.println("Perform the task");
			String heading = driver.findElement(By.xpath("//h1[contains(text(),'Pampers')]")).getText();
			if(heading.contains("Pampers")) {
				test.log(LogStatus.PASS,"successfully");
			}
		}catch(Exception e)
		{
			String message = e.getMessage();
			String errorMsg[]=message.split("}");
			test.log(LogStatus.FAIL,"Failed" + errorMsg[0]);
		}
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("closed the browser");
	}

}
