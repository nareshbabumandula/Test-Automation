package com.java.oops;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class Locators {
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	@Test
	public void locatorstesting() throws InterruptedException {
		try {
			driver.manage().window().maximize();
			driver.findElement(By.className("query-with-image-text--border")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//Using # write CSS locator with ID and css selector starts with
			driver.findElement(By.cssSelector("input#global-enhancements-search-query")).clear();
			driver.findElement(By.cssSelector("input#global-enhancements-search-query")).sendKeys("shoes");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[id^='global']")).clear();

			//Using . write CSS locator with Class 
			driver.findElement(By.cssSelector("div.query-with-image-text--border")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//xpath with /..
			driver.findElement(By.xpath("//li[3][@role='presentation']/../li[2]")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			driver.findElement(By.xpath("//li[3][@role='presentation']/..")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//XPath using starts-with and contains function
			driver.findElement(By.xpath("//input[starts-with(@id,'global')]")).sendKeys("watches");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@id,'-enhancements-')]")).clear();

			//css selector  contains attribute and ends-with attribute
			driver.findElement(By.cssSelector("input[id*='enhancements']")).sendKeys("earrings");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[id$='search-query']")).clear();

			//xpath to find the number of links in a web page
			List<WebElement> links = driver.findElements(By.xpath("//child::a"));
			System.out.println("The number of links is " + links.size());

			List<WebElement> link = driver.findElements(By.xpath("//a"));
			System.out.println("The number of link is " + link.size());

			//xpath to find the number of text boxes in a web page
			List<WebElement> textboxes = driver.findElements(By.xpath("//following::input"));
			System.out.println("The number of textboxes is " + textboxes.size());

			//xpath to find the number of text boxes in a web page
			List<WebElement> buttons = driver.findElements(By.xpath("//button"));
			System.out.println("The number of buttons is " + buttons.size());

			// xpath to find any object based on its index
			driver.findElement(By.xpath("//ul[@role='menubar']/li[8]")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//preceding, following sibling write xpath for any object
			driver.findElement(By.xpath("//li[4][@role='presentation']/following-sibling::*")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[4][@role='presentation']/preceding-sibling::*")).click();

			test.log(LogStatus.PASS, "Successfully closed the browser");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "failed to closed the browser");
		}
	}
	@BeforeClass
	public void browserlaunching() {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver,chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get("https://www.etsy.com/in-en/");
		report=new ExtentReports("./ExtentReportResults.html");
		test=report.startTest("locators test");
	}

	@AfterClass
	public void browserclosing() throws InterruptedException {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}

