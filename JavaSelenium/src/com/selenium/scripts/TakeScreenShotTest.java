package com.selenium.scripts;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TakeScreenShotTest{

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	
	@Test(groups = {"smoke"})
	public void captureScreenshot() throws InterruptedException {
		boolean bFlag=false;
				
		try {
			TakesScreenshot srcShot = (TakesScreenshot)driver;
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		    File destFile = new File("./screenshots/Failed.png");
		    Files.copy(srcFile, destFile);
			
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bFlag){
				test.log(LogStatus.PASS, "Successfully captured the screenshot");
			}else{
				test.log(LogStatus.FAIL, "Failed to capture the screenshot");
			}
		}
		
	}
	
	

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("TakesScreenshot Methods");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}

}
