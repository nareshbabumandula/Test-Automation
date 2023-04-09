package practice.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class AdvancedLocator {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@id='pass']/preceding::input")).sendKeys("TestUser");
	  driver.findElement(By.xpath("//input[@id='user']/following::input")).sendKeys("1234");
	  driver.findElement(By.xpath("//a[text()='Resources']/ancestor::li/following-sibling::li[5]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[2]/td/child::input")).sendKeys("EmployeContactForm");
	  driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[3]/td/descendant::input")).sendKeys("Employ1@test.com");
	  driver.findElement(By.xpath("//*[@id=\"q1\"]/self::input")).sendKeys("EmpioyTextBoxField");
	  driver.findElement(By.xpath("//textarea[@id='q2']")).sendKeys("EmpioyTextBoxFieldMulti Line");
	  driver.findElement(By.xpath("//*[@id=\"q3\"]/option[4]/parent::select")).sendKeys("Second Option");
	  driver.findElement(By.xpath("//input[@id='q4']/following::input[3]")).click();
	  driver.findElement(By.xpath("//input[@id='q5']")).click();
	  driver.findElement(By.xpath("//input[@name='checkbox6[]']")).click();
	  driver.findElement(By.xpath("//input[@name='q7']")).sendKeys("04-09-2023");
	  driver.findElement(By.xpath("//select[@id='q8']")).sendKeys("TX");
	  driver.findElement(By.xpath("//select[@id='q9']")).sendKeys("United States of America");
	  driver.findElement(By.xpath("//select[@id='q10']")).sendKeys("Ontario");
	  driver.findElement(By.xpath("//select[@name='q11_title']")).sendKeys("Ms.");
	  driver.findElement(By.xpath("//input[@name='q11_first']")).sendKeys("Marry");
	  driver.findElement(By.xpath("//input[@name='q11_last']")).sendKeys("Ruthuprabu");
	  driver.findElement(By.xpath("//select[@name='q12_month']")).sendKeys("8");
	  driver.findElement(By.xpath("//select[@name='q12_day']")).sendKeys("12");
	  driver.findElement(By.xpath("//select[@name='q12_year']")).sendKeys("2008");
	  
	  Thread.sleep(4000);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	  driver=new ChromeDriver(options);
	  driver.get("https://www.mycontactform.com/");
	  driver.manage().window().maximize();
	  

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
