package practice.selenium;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Browser {
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	
	@Test
	public void f() throws InterruptedException {
		driver.navigate().forward();
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(500);
		Set<String> str=driver.getWindowHandles();
		System.out.println(str);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://www.macys.com/");
		System.out.println("Browser current URL is :"+driver.getCurrentUrl());
		driver.findElement(By.id("globalSearchInputField")).sendKeys("Glass bowls");
		driver.findElement(By.id("globalSearchInputField")).submit();
		Thread.sleep(4000);
		String strresults= driver.findElement(By.id("resultsFoundMessage")).getText();
		if(strresults.contains("We found")) {
			System.out.println("Successfully found items");
			test.log(LogStatus.PASS, "Successfully found items");
		}else {
			System.out.println("No items found");
			test.log(LogStatus.FAIL, "No items found");
		}
	}

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("macys001");
		driver.get("https://www.walmart.com/");
		driver.manage().window().maximize();
		System.out.println("Browser current URL is :"+driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getTitle());
		System.out.println("Launch the browser");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}

}
