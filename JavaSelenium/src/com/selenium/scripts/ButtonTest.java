package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ButtonTest {

	static ExtentTest test;
	static ExtentReports report;

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
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("Button Methods");
	}

	@Test
	public void buttonMethods() throws InterruptedException {
		boolean bFlag=false;
		try {
			driver.manage().window().maximize();
			WebElement login = driver.findElement(By.name("btnSubmit"));
			System.out.println(login.getAttribute("type"));
			System.out.println(login.getAttribute("name"));
			System.out.println(login.getAttribute("value"));
			System.out.println(login.getAttribute("class"));
			System.out.println(login.getAttribute("tabindex"));
			System.out.println(login.getTagName());
			//login.click(); // Click on button
			
			// Using JavaScriptExecutor to click
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", login);
			//js.executeScript("document.getElementsByName('btnSubmit')[0].click()");
				
			String errMsg = driver.findElement(By.id("right_col_top_err")).getText();
			if(errMsg.contains("Enter you login details.")){
				test.log(LogStatus.PASS, "Successfully clicked on login button");
				System.out.println("Successfully clicked on login button");
				bFlag=true;	
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to click on login button since - " + errorMsg[0]);
			System.out.println("Failed to click on login button since - " + errorMsg[0]);
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Test Case Executed Successfully..!");
				System.out.println("Test Case Executed Successfully..!");
			} else {
				test.log(LogStatus.FAIL, "Test Case Failed..!");
				System.out.println("Test Case Failed..!");
			}
		}
	}

	// The annotated method will be run after all the test methods in the current class have been run.
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}


}
