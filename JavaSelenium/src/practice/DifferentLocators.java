package practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class DifferentLocators {
	ExtentTest test;
	ExtentReports report;
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	 driver.findElement(By.linkText("Sample Forms")).click();
	 driver.findElement(By.xpath("//input[@name='email_to[]']/following::input[2]")).click();
	 driver.findElement(By.cssSelector("input[id='subject']")).sendKeys("abcd");
	 driver.findElement(By.cssSelector("input[name='email']")).sendKeys("nikhil@gmail.com");
	 driver.findElement(By.cssSelector("input[id='q1']")).sendKeys("ghef glyufy hgti");
	 driver.findElement(By.cssSelector("[name='q2']")).sendKeys("hhaliu bfliawu hbfliuuw hhbli hgfilu hjgfil");
	 driver.findElement(By.xpath("//select[@id='q3']")).sendKeys("Third Option");
	 List<WebElement>radioButtonList= driver.findElements(By.xpath("//input[@name='q4']"));
	 for(int i=0; i<radioButtonList.size(); i++) {
		 System.out.println("RadioButtonList  ="+ radioButtonList.get(i).getAttribute("value"));	
	 }
	 test.log(LogStatus.PASS, "Radio-Button-List Printed successfully");
	 driver.findElement(By.xpath("//input[@name='q7']")).sendKeys("01-24-2023");
	 driver.findElement(By.xpath("//select[@name='q8']/option"));
	 List<WebElement>states= driver.findElements(By.xpath("//select[@name='q8']/option"));
	 System.out.println("Number of states in unitedstates ="+states.size());
	 for(int i=0; i<states.size(); i++) {
		 System.out.println("Number of states in us ="+states.get(i).getAttribute("value"));	
	 }
	 test.log(LogStatus.PASS, "Number of states in unitedstates Printed successfully  ");
	 List<WebElement>canadianProvinces= driver.findElements(By.xpath("//select[@id='q10']/option"));
	 System.out.println("Canadian Provinces in Sample Email and Contact Forms ="+canadianProvinces.size());
	 for(int i=0; i<canadianProvinces.size(); i++) {
		 System.out.println("Canadian Provinces="+canadianProvinces.get(i).getAttribute("value"));
	 }
	 test.log(LogStatus.PASS, "Canadian Provinces in Sample Email and Contact Forms Printed successfully ");
	 List<WebElement>preDefinedFieldName=driver.findElements(By.xpath("//select[@name='q11_title']/option"));
	 System.out.println("Pre-Defined Fields in  Sample Email and Contact Forms:"+preDefinedFieldName.size());
	 test.log(LogStatus.PASS, "Pre-Defined Fields in  Sample Email and Contact Forms");
	 driver.findElement(By.xpath("//select[@name='q11_title']")).sendKeys("Ms.");
	 driver.findElement(By.xpath("//input[@name='q11_first']")).sendKeys("Padma");
	 driver.findElement(By.xpath("//input[@name='q11_last']")).sendKeys("Musunuru");
	 
	 List<WebElement>dateOfBirth=driver.findElements(By.xpath("//select[@name='q12_month']/option"));
	 System.out.println("Pre-Defined Field - Date of Birth="+dateOfBirth.size());
	 test.log(LogStatus.PASS, "Pre-Defined Field - Date of Birth");
	 
	 List<WebElement>dateOfDays=driver.findElements(By.xpath("//select[@name='q12_day']/option"));
	 System.out.println("Pre-Defined Field - Date of Days="+dateOfDays.size());
	 test.log(LogStatus.PASS, "Pre-Defined Field - Date of Days");
	 
	 driver.findElement(By.xpath("//select[@name='q12_month']")).sendKeys("8");
	 driver.findElement(By.xpath("//select[@name='q12_day']")).sendKeys("18");
	 driver.findElement(By.xpath("//select[@name='q12_year']")).sendKeys("2004");

	  Thread.sleep(1000);
  }
  @BeforeClass
  public void launchTheBrowser() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	  driver=new ChromeDriver(options);
	  driver.get("https://www.mycontactform.com/");
	  driver.manage().window().maximize();
	  System.out.println("Launch the browser");
	  //test.log(LogStatus.PASS, "Successfully Launch the browser ");
	  report = new ExtentReports("./TestExtentReportResults.html");
	  test = report.startTest("Sample Email and Contact Forms");
	
	  
	  Thread.sleep(2000);
	  
  }

  @AfterClass
  public void closeTheBrowser() throws InterruptedException {
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }

}
