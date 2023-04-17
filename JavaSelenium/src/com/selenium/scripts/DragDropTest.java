package com.selenium.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DragDropTest {

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
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("Drag and Drop Methods from Actions Class");
	}

	@Test
	public void draganddropMethods() throws InterruptedException {
		boolean bFlag=false;
		try {
			driver.findElement(By.linkText("Draggable")).click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement source = driver.findElement(By.id("draggable"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(source, 390, 100).perform();
			driver.switchTo().defaultContent();
			driver.findElement(By.linkText("Droppable")).click();
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			
			WebElement src = driver.findElement(By.id("draggable"));
			WebElement dest = driver.findElement(By.id("droppable"));
			action.dragAndDrop(src, dest).perform();
			// Hard Assertion
			//Assert.assertEquals(dest.getText(), "Dropped", "Failed to drop the webelement");
			SoftAssert softassert = new SoftAssert();
			// Soft Assertion
			softassert.assertEquals(dest.getText(), "Dropped", "Failed to drop the webelement");
			bFlag=true;
			if(bFlag){
				test.log(LogStatus.PASS, "Successfully performed drag and drop operations");
				System.out.println("Successfully performed drag and drop operations");
				bFlag=true;	
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to peform drag and drop since - " + errorMsg[0]);
			System.out.println("Failed to perform drag and drop since - " + errorMsg[0]);
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
