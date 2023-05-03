package com.selenium.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JavaScriptExecutorTest{

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	/**
	 * What is JavascriptExecutor in Selenium? In simple words, JavascriptExecutor is an interface that is used
	 * to execute JavaScript with Selenium. To simplify the usage of JavascriptExecutor in Selenium, 
	 * think of it as a medium that enables the WebDriver to interact with HTML elements within the browser. 
	 * JavaScript is a programming language that interacts with HTML in a browser, and to use this function in 
	 * Selenium, JavascriptExecutor is required.
	 * @throws InterruptedException
	 */

	/**
	 * executeScript method – This method executes the test script in the context of the currently selected window
	 * or frame. The script in the method runs as an anonymous function. If the script has a return statement, 
	 * the following values are returned:
	 * @throws InterruptedException
	 */
	@Test(groups = {"smoke"})
	public void textboxMethods() throws InterruptedException {
		String actUsername="";
		try {

			// Finding an element using the selenium webdriver and highlighting it.
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("history.go(0)"); // Page Refresh

			//To get the Title of our webpage
			String titleText =  jsExecutor.executeScript("return document.title;").toString();
			System.out.println(titleText);

			//To get the domain name
			String domainName=  jsExecutor.executeScript("return document.domain;").toString();
			System.out.println(domainName);

			//To get the URL of a webpage
			String url=  jsExecutor.executeScript("return document.URL;").toString();
			System.out.println(url);

			WebElement username = driver.findElement(By.id("user"));
			jsExecutor.executeScript("arguments[0].style.border='2px solid red'", username); 
			jsExecutor.executeScript("arguments[0].style.background='yellow'", username);  
			Thread.sleep(2000);
			jsExecutor.executeScript("arguments[0].value='priyanka';", username);
			Thread.sleep(2000);

			// Finding an element using Javascript and highlighting it.
			String javasript = "document.getElementById('pass').style.border='2px solid red'";  
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript(javasript);  
			js.executeScript("document.getElementById('pass').value='Secure*1234'");
			Thread.sleep(2000);
			actUsername = username.getAttribute("value");

			System.out.println("Value entered in the username field is : " + actUsername);
			Assert.assertEquals(actUsername, "priyanka", "Actual username is not same as expected");

			// Javascript click
			js.executeScript("document.getElementsByName('btnSubmit')[0].click();");
			Thread.sleep(2000);

			driver.findElement(By.linkText("Sample Forms")).click();
			Thread.sleep(2000);
			// To perform Scroll on an application using Selenium
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);

			// To scroll the page vertically till the end
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);

			// Scroll till the object is found
			WebElement submit =driver.findElement(By.linkText("Home"));
			js.executeScript("arguments[0].scrollIntoView(true);", submit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(actUsername.equals("priyanka")){
				test.log(LogStatus.PASS, "Successfully entered in the username field is : " + actUsername);
			}else{
				test.log(LogStatus.FAIL, "Value entered in the username field is not correct");
			}
		}
	}

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("JavascriptExecutor Methods");
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
