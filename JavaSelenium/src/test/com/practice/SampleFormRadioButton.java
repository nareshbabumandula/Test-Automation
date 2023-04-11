package test.com.practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class SampleFormRadioButton {

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	@Test
	public void RadioButtonTest()throws InterruptedException {
		try { 
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sample Forms")).click();
			WebElement radiobutton = driver.findElement(By.id("q4"));
			System.out.println(radiobutton.getAttribute("name"));
			System.out.println(radiobutton.getAttribute("value"));
			System.out.println(radiobutton.getAttribute("type"));
			radiobutton.click();
			Thread.sleep(1000);
			String color = radiobutton.getCssValue("color");
			System.out.println("Color value : " +color);
			if(radiobutton.isDisplayed()){
				test.log(LogStatus.PASS, "Successfully clicked on radio button");
				System.out.println("Successfully clicked on radio button");
			}
		}catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to click on Radio button- " + errorMsg[0]);
			System.out.println("Failed to click on Radio button- " + errorMsg[0]);
		}
		//     Checkbox
		try { 
			WebElement checkbox = driver.findElement(By.name("email_to[]"));
			System.out.println(checkbox.getAttribute("name"));
			System.out.println(checkbox.getAttribute("value"));
			System.out.println(checkbox.getAttribute("type"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", checkbox);
			String border = checkbox.getCssValue("border");
			System.out.println("border value : " +border);
			if(checkbox.isDisplayed()) {
				test.log(LogStatus.PASS, "Successfully clicked on checkbox");
				System.out.println("Successfully clicked on checkbox");
			}
		}catch (Exception e) {
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to click on checkbox " + errorMsg[0]);
			System.out.println("Failed to click on checkbox " + errorMsg[0]);
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
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("Button Methods");
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}
}