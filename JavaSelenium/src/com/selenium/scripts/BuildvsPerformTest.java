package com.selenium.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BuildvsPerformTest {

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
		driver.get("http://www.edureka.co/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("Drag and Drop Methods from Actions Class");
	}

	@Test
	public void draganddropMethods() throws InterruptedException {
		boolean bFlag=false;
		try {
			/*build() method in Actions class is use to create chain of action or operation you want to perform.
			  perform() this method in Actions Class is use to execute chain of action which are build using Action build method.
			  build().perform() = create chain of actions + execute
		    */
			Actions builder = new Actions(driver);
			driver.findElement(By.xpath("//input[@placeholder='Enter Course, Category or keyword']")).click();
			WebElement act = driver.findElement(By.id("search-input"));
			Action seriesOfActions = builder.sendKeys(act, "Selenium").keyDown(act, Keys.SHIFT).build();
			Thread.sleep(3000);
			seriesOfActions.perform();
			Thread.sleep(3000);
			String title = driver.getTitle();
	
			if(title.contains("Selenium")){
				test.log(LogStatus.PASS, "Successfully built and performed chain of actions");
				System.out.println("Successfully built and performed chain of actions");
				bFlag=true;	
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to build and performed chain of actions since - " + errorMsg[0]);
			System.out.println("built and performed chain of actions since - " + errorMsg[0]);
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
