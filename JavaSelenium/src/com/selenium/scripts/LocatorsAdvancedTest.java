package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsAdvancedTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();

		// CSS Selector with # (ID)
		driver.findElement(By.cssSelector("input#user")).sendKeys("Nirmala");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='user']")).clear();
		
		// CSS Selector with .(Class)
		driver.findElement(By.cssSelector("input.txt_log")).sendKeys("Padma");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.txt_log")).clear();
		
		// XPath with wildcard as an attribute
		driver.findElement(By.xpath("//input[@*='user']")).sendKeys("Ravi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@*='user']")).clear();
		
		// XPath with child
		driver.findElement(By.xpath("//child::input")).sendKeys("Keerthi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@*='user']")).clear();
	
		String lblUsername = driver.findElement(By.xpath("//input[@id='user']/../label")).getText();
		System.out.println("Username field name is : " + lblUsername);
		
		// Identifying the password field based on username field xpath
		driver.findElement(By.xpath("//input[@id='user']/following::input")).sendKeys("Secure*123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user']/following::input")).clear();

		// Identifying the username field based on password field xpath
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input")).sendKeys("Prudhvi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='pass']/preceding::input")).clear();
		
		// Identifying the day dropdown field based on month using following-sibling axes in xpath
		driver.findElement(By.linkText("Sample Forms")).click();
		boolean bDayflag = driver.findElement(By.xpath("//select[@name='q12_month']/following-sibling::*")).isDisplayed();
		System.out.println("Day dropdown field display status is : " + bDayflag);
		
		// Identifying the month dropdown field based on day using preceding-sibling axes in xpath
		boolean bmonthflag = driver.findElement(By.xpath("//select[@name='q12_day']/preceding-sibling::select")).isDisplayed();
		System.out.println("Month dropdown field display status is : " + bmonthflag);
				
		Thread.sleep(2000);
		driver.quit();
	}

}
