package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class MyContactForm {
	WebDriver driver;
	
	@Test
	public void verifySubmitSampleForm() throws InterruptedException {
		WebElement samplelink;
		
		driver.findElement(By.linkText("Sample Forms")).click();	
		driver.findElement(By.name("email_to[]")).click();	
		driver.findElement(By.id("subject")).sendKeys("xyz");
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("q1")).sendKeys("test123");
		driver.findElement(By.id("q2")).sendKeys("Test Description");
		driver.findElement(By.id("q3")).sendKeys("Second Option");
		driver.findElement(By.id("q4")).click();
		driver.findElement(By.id("q5")).click();
		driver.findElement(By.name("checkbox6[]")).click();
		driver.findElement(By.id("q7")).sendKeys("11-18-2008");
		driver.findElement(By.id("q8")).sendKeys("IN");
		driver.findElement(By.id("q9")).sendKeys("India");
		driver.findElement(By.id("q10")).sendKeys("Ontario");
		driver.findElement(By.name("q11_title")).sendKeys("Miss");
		driver.findElement(By.name("q11_first")).sendKeys("abcde");
		driver.findElement(By.name("q11_last")).sendKeys("xxxxxxxxxxxx");
		driver.findElement(By.name("q12_month")).sendKeys("11");
		driver.findElement(By.name("q12_day")).sendKeys("18");
		driver.findElement(By.name("q12_year")).sendKeys("2008");
		driver.findElement(By.name("submit")).click();
	}
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver;","./JavaSelenium/drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
