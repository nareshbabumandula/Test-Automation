package com.selenium.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathAxesFunctionsTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// ancestor
		String value = driver.findElement(By.xpath("//input[@id='user']/ancestor::div")).getAttribute("id");
		System.out.println(value);
		
		// descendant
		driver.findElement(By.xpath("//div[@id='content_wrapper']/descendant::input[@id='user']")).sendKeys("testuser");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
