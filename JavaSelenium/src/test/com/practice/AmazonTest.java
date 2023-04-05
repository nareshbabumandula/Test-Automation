package test.com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AmazonTest {
	WebDriver browser;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void methods() throws InterruptedException {
		try {
			browser.navigate().to("https://www.amazon.in/");
			browser.manage().window().maximize();
			browser.findElement(By.id("searchDropdownBox")).sendKeys("Amazon Pharmacy");
			String fliter= browser.findElement(By.id("searchDropdownBox")).getText();
			if (fliter.contains("Amazon Pharmacy")); {
				System.out.println("Test passed");
				test.log(LogStatus.PASS, "Successfully changed the option using id locator :Amazon Pharmacy");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to apply the option");
		}
		try {
			browser.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).sendKeys("toys");
			browser.findElement(By.cssSelector("input[id=nav-search-submit-button]")).click();
			Thread.sleep(3500);
			browser.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).clear();
			browser.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).sendKeys("wallet");
			browser.findElement(By.cssSelector("input[id=nav-search-submit-button")).click();
			Thread.sleep(1500);
			browser.findElement(By.cssSelector("input[id=twotabsearchtextbox")).clear();
			String product= browser.findElement(By.cssSelector("input[id=twotabsearchtextbox")).getText();
			if(product.contains("toys"));{
				test.log(LogStatus.PASS, "Successfully searched the product using cssSelector :Toys");
			}if(product.contains("wallet"));{
				test.log(LogStatus.PASS, "Successfully searched the product using cssSelector:Wallet");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to search the product");
		}
		try {
			browser.findElement(By.className("hm-icon-label")).click();
			Thread.sleep(3500);
			browser.navigate().back();
			String header= browser.findElement(By.className("hm-icon-label")).getText();
			if(header.contains("all"));{
				test.log(LogStatus.PASS, "Displayed the options using className locator");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to display the options");
		}
		try {
			browser.findElement(By.id("nav-link-accountList-nav-line-1")).click();
			browser.findElement(By.name("email")).sendKeys("keerthana@gmail.com");
			Thread.sleep(1000);
			browser.navigate().back();
			String text=browser.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
			if(text.contains("signin"));{
				test.log(LogStatus.PASS, "Successfully entered the mail using name locator");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to enter the mail");
		}

		try {
			browser.findElement(By.xpath("/html/body/div/header/div/div/div[2]/div/form/div[2]/div/input")).sendKeys("watch");
			browser.findElement(By.cssSelector("input[id=nav-search-submit-button]")).click();
			Thread.sleep(1000);
			browser.navigate().back();
			String product=browser.findElement(By.xpath("/html/body/div/header/div/div/div[2]/div/form/div[2]/div/input")).getText();
			if(product.contains("watch"));{
				test.log(LogStatus.PASS, "Searched the product using xpath locator:Watch");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to search the product");
		}
	}
	@BeforeClass
	public void beforeMethod() {
		WebElement samplelink;
		browser=new EdgeDriver();
		browser.get("https://www.amazon.in/");
		browser.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
	}
	@AfterClass
	public void afterMethod() {
		browser.quit();
		report.endTest(test);
		report.flush();
		browser.quit();
	}
}
