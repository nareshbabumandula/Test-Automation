package test.com.practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	@Test
	public void Verifyproduct() {
		try {
			driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).sendKeys("keyboard");
			driver.findElement(By.cssSelector("input[id=nav-search-submit-button]")).click();
			Thread.sleep(3500);
			String product= driver.findElement(By.cssSelector("input[id=twotabsearchtextbox")).getText();
			if(product.contains("keyboard"));
			test.log(LogStatus.PASS, "Successfully searched the product:keyboard");
			System.out.println("Test passed");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to search the product");
		}
	}
	@BeforeMethod
	public void beforeMethod() {
		try {
			driver.findElement(By.id("searchDropdownBox")).sendKeys("Amazon Fresh");
			String fliter= driver.findElement(By.id("searchDropdownBox")).getText();
			if (fliter.contains("Amazon Fresh")); {
				test.log(LogStatus.PASS, "Successfully changed the option:Amazon Fresh");
				System.out.println("Beforemethod : Successfully changed the option ");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to apply the option");
		}
	}
	@AfterMethod
	public void afterMethod() {
		try {
			driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).clear();
			test.log(LogStatus.PASS, "Successfully cleared");
			System.out.println("Aftermethod : Successfully cleared ");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to clear ");
		}
	}
	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		System.out.println("Beforeclass : Successfully maximize the window ");
	}
	@AfterClass
	public void afterClass() {
		driver.manage().window().minimize();
		System.out.println("Afterclass : Successfully minimize the window ");
	}
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chromedriver.driver","./drivers/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		System.out.println("BeforeTest : launched the Browser");
	}
	@AfterTest
	public void closeBrowser() {
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("AfterTest : Closed the Browser.");
	}
	@BeforeSuite
	public void beforeSuite() {
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
		System.out.println("Beforesuite : Successfully created the extent report");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Aftersuite : Successfully generated the extent report");
	}
}
