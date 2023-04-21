package test.com.practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DropDown {
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	@Test
	public void DropdownTest() throws InterruptedException {
		try {
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sample Forms")).click();
			driver.findElement(By.linkText("Business Contact Form")).click();
			WebElement subject = driver.findElement(By.id("subject"));
			Select select = new Select(subject);
			//Count of dropdown items
			List<WebElement> dropdownitems = select.getOptions();
			System.out.println("No of subject : " + dropdownitems.size());
			//default value 
			String start=select.getFirstSelectedOption().getText();
			System.out.println("Default value is: " +start);
			//select nth item by index
			select.selectByIndex(1);
			Thread.sleep(1000);
			//select by visibletext
			select.selectByVisibleText("Price Quote");
			//All the dropdown items name
			for(int i= 0;i<dropdownitems.size();i++) {
				String all = dropdownitems.get(i).getText();
				System.out.println(all);
			}
			//To select the option with its value we have to use the selectByValue method
			select.selectByValue("Contact Request");
			//last but one value
			System.out.println("Last But ONE value: "+dropdownitems.get(dropdownitems.size()-2).getText());
			//checking the dropdownvalues are sorted or not
			List<String> originalList=new ArrayList<String>();
			for(WebElement wb:select.getOptions()){
				originalList.add(wb.getText());
				System.out.println(originalList);
			}
			List<String>TemporaryList=originalList;
			System.out.println("Before sorting TemporaryList :"+TemporaryList);
			Collections.sort(TemporaryList);
			System.out.println("After sorting TemporaryList :"+TemporaryList);
			if (originalList == TemporaryList) {
				System.out.println("Dropdown sorted");
			} else {
				System.out.println("Dropdown Not sorted");
			}
			test.log(LogStatus.PASS, "Test Passed");
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL,"Test Failed");
		}
	}
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
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}
}
