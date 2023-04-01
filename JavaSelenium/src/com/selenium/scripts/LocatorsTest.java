package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();

		// ID locator
		driver.findElement(By.id("user")).sendKeys("padma");
		Thread.sleep(1000);
		driver.findElement(By.id("user")).clear();

		// Name locator
		driver.findElement(By.name("pass")).sendKeys("Secure*123");
		Thread.sleep(1000);
		driver.findElement(By.name("pass")).clear();

		// Classname Locator
		driver.findElement(By.className("txt_log")).sendKeys("nandini");
		Thread.sleep(1000);
		driver.findElement(By.className("txt_log")).clear();

		// CSS Selector Locator
		driver.findElement(By.cssSelector("input[id='user']")).sendKeys("nagaraju");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='user']")).clear();

		// CSS Selector with starts-with attribute
		driver.findElement(By.cssSelector("input[id^='use']")).sendKeys("jeevitha");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id^='use']")).clear();

		// CSS Selector with ends-with attribute
		driver.findElement(By.cssSelector("input[id$='ser']")).sendKeys("harish");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id$='ser']")).clear();

		// CSS Selector with contains attribute
		driver.findElement(By.cssSelector("input[id*='se']")).sendKeys("praveen");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='se']")).clear();

		// Linktext locator
		driver.findElement(By.linkText("Sample Forms")).click();
		Thread.sleep(1000);

		// Partiallinktext locator
		driver.findElement(By.partialLinkText("Feat")).click();
		Thread.sleep(1000);

		// Tagname locator
		driver.findElement(By.tagName("input")).sendKeys("keerthana");
		Thread.sleep(1000);
		driver.findElement(By.tagName("input")).clear();

		// Absolute xpath - starts from root/parent node of the html dom
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("rushita");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).clear();

		// A relative xpath is one where the path starts from the node of your choice with a preceding // double slash.
		driver.findElement(By.xpath("//fieldset/div/input")).sendKeys("satya");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//fieldset/div/input")).clear();


		Thread.sleep(2000);
		driver.quit();
	}

}
