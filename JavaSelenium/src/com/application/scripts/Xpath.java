package com.application.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		//Self
		driver.findElement(By.xpath("//input[@id='user']//self::input")).sendKeys("Nagaraju");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='user']//self::input")).clear();
		
		//Parent
	//	driver.findElement(By.xpath("//div[@id='right_col_top']/parent::div")).sendKeys("Pavanf");
	//	Thread.sleep(3000);
	//	driver.findElement(By.xpath("div[@id='right_col_top']/child::*")).sendKeys("Pavanf"); parent  
		
		
		
		
		
		





	}
}
