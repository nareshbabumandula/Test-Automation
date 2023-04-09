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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class XpathAxes {
	static ExtentTest test;
	static ExtentReports report;

	WebDriver driver;
	@Test
	public void browsermethods() throws InterruptedException {
		try {

			driver.manage().window().maximize();

			//xpath-Child Axes
			driver.findElement(By.xpath("//div[@class='header-right']//child::li")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//xpath-Parent Axes
			List<WebElement> menubar=driver.findElements(By.xpath("//a[@class=' alignTag']//parent::li//parent::ul"));
			menubar.forEach(tab->System.out.println(tab.getText()));

			//xpath-Ancestor Axes
			List<WebElement> names=driver.findElements(By.xpath("//div[@class='popup-blk wishlist-blk-icon']//ancestor::div[2]"));
			names.forEach(tab->System.out.println(tab.getText()));

			//xpath-self axes
			driver.findElement(By.xpath("//input[@name='searchVal']//self::input")).sendKeys("bags");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='searchVal']//self::input")).clear();

			//xpath-Ancestor-or-self Axes 
			driver.findElement(By.xpath("//a[@title='Lamp, Diyas & Candle']//ancestor-or-self::li")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			//xpath-Descendant axes
			String name=driver.findElement(By.xpath("//ul[@class='level-first false']//descendant::a[@title='WOMEN']")).getText();
			System.out.println("title:"+name);

			//xpath-descendant or self axes and following axes
			driver.findElement(By.xpath("//div[@class='scb']//descendant-or-self::input")).sendKeys("shoes");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='scb']//following::input")).clear();

			//xpath-following-sibling axes
			driver.findElement(By.xpath("//li[@data-test='li-WOMEN']//following-sibling::li[@data-test='li-KIDS']")).click();
			Thread.sleep(2000);
			driver.navigate().back();

			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("https://www.facebook.com/");

			//xpath-preceding axes and attribute axes
			driver.findElement(By.xpath("//input[@id='pass']//preceding::input[1]")).sendKeys("murthy");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[attribute::id='email']")).clear();

			//xpath-preceding-sibling axes
			driver.findElement(By.xpath("//div[@class='_6ltj']//preceding-sibling::div[1]")).click();
			test.log(LogStatus.PASS, "Test Passed");

		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Test Passed");
		}
	}
	@BeforeClass
	public void BrowserLaunching() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver,chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get("https://www.ajio.com/");
		report=new ExtentReports("./ExtentReportResults.html");
		test=report.startTest("xpath axes");
	}
	@AfterClass
	public void BrowserCloseing() throws InterruptedException {
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
