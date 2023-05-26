package com.selenium.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserTest {

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
		test = report.startTest("TC001");
	}

	@Test
	public void browserMethods() throws InterruptedException {

		try {
			driver.manage().window().maximize();
			System.out.println("Browser title is : " + driver.getTitle());
			System.out.println("Browser current url is : " + driver.getCurrentUrl());
			driver.navigate().to("https://www.mycontactform.com/samples.php");
			Thread.sleep(1000);
			System.out.println("Browser title is : " + driver.getTitle());
			System.out.println("Browser current url is : " + driver.getCurrentUrl());
			driver.navigate().back();
			Thread.sleep(1000);
			driver.navigate().forward();
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			String mainwindow = driver.getWindowHandle();
			System.out.println("Session ID is : " + mainwindow);

			List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='header']/ul/li/a"));
			tabs.forEach(tab->System.out.println(tab.getText()));

			System.out.println(driver.getPageSource());
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("https://www.firstcry.com/");
			driver.findElement(By.id("search_box")).clear();
			driver.findElement(By.id("search_box")).sendKeys("pampers");
			driver.findElement(By.className("search-button")).click();
			Thread.sleep(3000);
			System.out.println("Successfully performed the actions on a browser..!");
			String heading = driver.findElement(By.xpath("//h1[contains(text(),'Pampers')]")).getText();
			if(heading.contains("Pampers")){
				test.log(LogStatus.PASS, "Successfully searched the product");
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to search the product since - " + errorMsg[0]);
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
