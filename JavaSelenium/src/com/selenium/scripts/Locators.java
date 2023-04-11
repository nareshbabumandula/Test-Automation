package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class Locators{

	static WebDriver driver;
	static  ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("TC001");
		driver.manage().window().maximize();
	}
	@Test
	public void browserMethod() throws InterruptedException {
		//Id Locator
		driver.findElement(By.id("user")).sendKeys("harsh");
		Thread.sleep(1000);
		driver.findElement(By.id("user")).clear();

		//name locator
		driver.findElement(By.name("pass")).sendKeys("password1234");
		Thread.sleep(1000);
		driver.findElement(By.name("pass")).clear();

		//ClassName locator
		driver.findElement(By.className("txt_log")).sendKeys("navjot");
		Thread.sleep(1000);
		driver.findElement(By.className("txt_log")).clear();

		//CSS Selector locator
		driver.findElement(By.cssSelector("input[id='user']")).sendKeys("deep");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='user']")).clear();

		//CSS Selector locator with with-starts attribute
		driver.findElement(By.cssSelector("input[id^='use']")).sendKeys("rajveer");
		Thread.sleep(900);
		driver.findElement(By.cssSelector("input[id^='use']")).clear();

		//CSS Selector locator with ends-with attribute
		driver.findElement(By.cssSelector("input[id$='ser']")).sendKeys("hardeep");
		Thread.sleep(900);
		driver.findElement(By.cssSelector("input[id$='ser']")).clear();

		//CSS Selector locator with contains attribute
		driver.findElement(By.cssSelector("input[id*='se']")).sendKeys("satveer");
		Thread.sleep(900);
		driver.findElement(By.cssSelector("input[id*='se']")).clear();

		//linkText locator
		driver.findElement(By.linkText("Sample Forms")).click();

		//partialLinkTest locator
		driver.findElement(By.partialLinkText("Fea")).click();

		//TagName locator
		driver.findElement(By.tagName("input")).sendKeys("Simran");
		Thread.sleep(900);
		driver.findElement(By.tagName("input")).clear();

		//absolute xPath -starts from parent/root node of the html dom
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("Harjeet");
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/form/fieldset/div/input")).clear();


		//relative xPath -starts from  node of your choice 
		driver.findElement(By.xpath("//form/fieldset/div/input")).sendKeys("Bachan");
		driver.findElement(By.xpath("//form/fieldset/div/input")).clear();
		
		//obtain color in rgba
		WebElement username = driver.findElement(By.cssSelector("input[id*='se']"));
		String color = username.getCssValue("color");
		System.out.println("Color value for username field is " +color);
		
		String font = username.getCssValue("font-size");
		System.out.println("font-size value for username field is " +font);
		
		//xPath with attributes
		driver.findElement(By.xpath("//input[@id ='user']")).sendKeys("Navneet");
		Thread.sleep(900);
		driver.findElement(By.xpath("//input[@id ='user']")).clear();
		
		//xPath using starts-with 
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).sendKeys("ajju");
		Thread.sleep(900);
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).clear();
		
		//xpath using contains
		driver.findElement(By.xpath("//input[contains(@id,'use')]")).sendKeys("gurbachan");
		Thread.sleep(900);
		driver.findElement(By.xpath("//input[contains(@id,'use')]")).clear();
		
		//xpath with and operator
		driver.findElement(By.xpath("//input[@class='txt_log' and @name='pass']")).sendKeys("secure845");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='txt_log' and @name='pass']")).clear();
		
		//xpath with or operator
		driver.findElement(By.xpath("//input[@id='user' or @name='user']")).sendKeys("navjeet");
		Thread.sleep(900);
		driver.findElement(By.xpath("//input[@id='user' or @name='user']")).clear();
		
		//xpath with contains text method
		boolean bflag = driver.findElement(By.xpath("//label[contains(text(),'User Name:')]")).isDisplayed();
		System.out.println("Display status of the username label is:"+bflag);
		String usernameField = driver.findElement(By.xpath("//label[contains(text(),'User Name:')]")).getText();
		System.out.println("Field name for the username field is:"+usernameField);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}



