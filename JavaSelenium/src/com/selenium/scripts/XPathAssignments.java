package com.selenium.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathAssignments {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='header']/ul/li"));
		
		for (WebElement menutab : tabs) {
			System.out.println(menutab.getText());
		}
				
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Mobiles")).click();
		List<WebElement> brands = driver.findElements(By.xpath("//span[starts-with(text(), 'Brands')]/parent::div/parent::div/ul/li/span/a"));
		for (WebElement brand : brands) {
			System.out.println(brand.getText());
		}
		driver.quit();
	}

}
