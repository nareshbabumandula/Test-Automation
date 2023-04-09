package com.selenium.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class BrowserTest {
	WebDriver driver;
  @BeforeClass
 public void launchBrowser() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	  driver = new ChromeDriver(options);
	  driver.get("https://www.amazon.com/");
	  System.out.println("Launch the Browser");
  }
  @Test
  public void browserMethod() throws InterruptedException {
	  driver.manage().window().maximize();
	  String strTitle = driver.getTitle();
	  System.out.println("Current url is "+driver.getCurrentUrl());
	  System.out.println("Title is "+strTitle);
       Thread.sleep(3000);
       driver.navigate().to("https://www.amazon.ca/electronics-deals-electronics-sale-tv-sale/b/?ie=UTF8&node=2055586011&ref_=sv_ce_1");
       driver.navigate().back();
       Thread.sleep(3000);
       driver.navigate().forward();
       Thread.sleep(3000);
       driver.navigate().refresh();
	  System.out.println("Perform the task");
  }

  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
	  System.out.println("closed the browser");
  }

}
