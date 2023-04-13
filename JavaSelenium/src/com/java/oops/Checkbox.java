package com.java.oops;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class Checkbox {
	static ExtentTest test;
	static ExtentReports report;

	WebDriver driver;
	@Test
	public void CheckBox() throws InterruptedException {
		try {
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Mobiles")).click();
			Thread.sleep(2000);
			WebElement checkboxBefore=driver.findElement(By.xpath("//span[@class='a-list-item']/a/span[contains(text(),'OnePlus')]/preceding-sibling::div"));
			checkboxBefore.click();
			WebElement checkboxAfter=driver.findElement(By.xpath("//span[@class='a-list-item']/a/span[contains(text(),'OnePlus')]/preceding-sibling::div"));
			Thread.sleep(2000);
			if(checkboxAfter.isEnabled()){
				test.log(LogStatus.PASS, "Successfully selected the checkbox");
			}
		}catch(Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, "failed to select the checkbox");
		}	
	}

	@BeforeClass
	public void BrowserLaunching() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver,chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report=new ExtentReports("./ExtentReportResults.html");
		test=report.startTest("Checkbox test");
	}
	@AfterClass
	public void BrowserCloseing() throws InterruptedException {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}

