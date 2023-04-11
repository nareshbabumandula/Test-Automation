package com.java.oops;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class CssSelectors {
	static ExtentTest test;
	static ExtentReports report;

	WebDriver driver;
	@Test
	public void CssSelector() {
		try {
			driver.manage().window().maximize();

			//css selector-Absolute Path
			driver.findElement(By.cssSelector("ul>li>a>span")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//css selector-non absolute path and ending text of an attribute
			driver.findElement(By.cssSelector("input#global-enhancements-search-query")).sendKeys("bags");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[id$='search-query']")).clear();

			//css selector non absolute path  Tag and Class
			driver.findElement(By.cssSelector("span.wt-text-black")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//css selector -tagname,attribute and value
			driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']")).sendKeys("shoes");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']")).clear();

			//css selector -contains and start text of an attribute
			driver.findElement(By.cssSelector("input[id*='enhancements']")).sendKeys("watches");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[id^='global']")).clear();

			//css selector -Comma Operator to Implement OR Operation
			driver.findElement(By.cssSelector("li.top-nav-item wt-pb-xs-2 wt-mr-xs-2 wt-display-flex-xs wt-align-items-center,span#catnav-primary-link-10923")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//css selector-Tag and ID
			driver.findElement(By.cssSelector("input#global-enhancements-search-query")).sendKeys("cups");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input#global-enhancements-search-query")).clear();

			//css selector-first-of-type and last-of-type
			driver.findElement(By.cssSelector(".wt-grid>ul>li:first-of-type.top-nav-item")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".wt-grid>ul>li:last-of-type.top-nav-item")).click();
			Thread.sleep(1000);
			driver.navigate().back();

			//css selector- *:last-of-type
			driver.findElement(By.cssSelector(".wt-grid>ul>*:last-of-type.top-nav-item")).click();
			Thread.sleep(1000);
			driver.navigate().back();

			//css selector- nth-of-type and nth-child
			driver.findElement(By.cssSelector(".wt-grid>ul>li:nth-of-type(7)")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".wt-grid>ul>li:nth-child(6)")).click();
			Thread.sleep(1000);
			driver.navigate().back();

			//css selector-Sibling “+” Operator
			driver.findElement(By.cssSelector(".wt-grid>ul>li:nth-child(6)+li+li ")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			test.log(LogStatus.PASS, "Successfully closed the browser");

		}catch(Exception e){
			test.log(LogStatus.FAIL, "failed to closed the browser");
		}
	}
	@BeforeClass
	public void BrowserLaunching() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver,chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get("https://www.etsy.com/in-en/");
		report=new ExtentReports("./ExtentReportResults.html");
		test=report.startTest("CssSelectors");
	}

	@AfterClass
	public void BrowserClosing() throws InterruptedException {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
