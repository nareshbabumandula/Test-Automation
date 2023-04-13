package com.selenium.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DropdownListboxTest {

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
		test = report.startTest("Dropdown listbox Methods");
	}

	@Test
	public void dropdownListboxMethods() throws InterruptedException {
		boolean bFlag=false;
		try {
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sample Forms")).click();
			WebElement predefinedCountries = driver.findElement(By.id("q9"));
			
			Select select = new Select(predefinedCountries);
			String selectedCountryBefore = select.getFirstSelectedOption().getText();
			System.out.println("By default the couontry selected is : " +selectedCountryBefore);
			select.selectByIndex(0);
			Thread.sleep(2000);
			select.selectByIndex(1);
			Thread.sleep(2000);
			
			List<WebElement> dropdownitems = select.getOptions();
			System.out.println("No of countries displayed in the country dropdown are : " + dropdownitems.size());
			for (int i = 0; i < dropdownitems.size(); i++) {
				String value = dropdownitems.get(i).getText();
				System.out.println(value);
				if (value.equals("India")) {
					break;
				}
			}
			System.out.println("Looping through lambda expression");
			dropdownitems.forEach(country-> System.out.println(country.getText()));
			
			select.selectByVisibleText("India");
			System.out.println(select.isMultiple());
			
			String selectedCountry = select.getFirstSelectedOption().getText();

			if(selectedCountry.equals("India")){
				test.log(LogStatus.PASS, "Successfully selected value from a dropdown");
				System.out.println("Successfully selected value from a dropdown");
				bFlag=true;	
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to select value from a dropdown since - " + errorMsg[0]);
			System.out.println("Failed to select value from a dropdown since - " + errorMsg[0]);
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
