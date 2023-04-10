package test.com.practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class MyContactForm {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void ContactFormTest()throws InterruptedException{
		try {
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sample Forms")).click();
			//1.Using Starting Text of an Attribute
			driver.findElement(By.cssSelector("input[name^='q11_las']")).sendKeys("sri");
			Thread.sleep(1000);
			//2.Using Containing Text of an Attribute
			driver.findElement(By.cssSelector("input[name*='q11_firs']")).sendKeys("Nithya");
			driver.findElement(By.cssSelector("input[name*='q11_firs']")).clear();
			//3.Using Ending Text of an Attribute
			driver.findElement(By.cssSelector("input[name$='11_first']")).sendKeys("sai");
			//4.Using Tag Name CSS Selector
			driver.findElement(By.cssSelector("input")).sendKeys("sanvi@gmail.com");
			//5.Using Absolute Path CSS Selector
			driver.findElement(By.cssSelector("tr>td>textarea")).sendKeys("Welcome...!");
			driver.findElement(By.partialLinkText("Business Contact Form")).click();
			//6.Using first-of-type CSS Selector
			driver.findElement(By.cssSelector(".samples:nth-of-type(3)>li:first-of-type")).click();
			//7.Using Tag and ID CSS Selector
			driver.findElement(By.cssSelector("input#email")).sendKeys("Keerthana@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input#email")).clear();
			driver.navigate().back();
			//8.Using Comma Operator to Implement OR Operation CSS Selector
			driver.findElement(By.cssSelector("input#user,input#pass")).sendKeys("Riya@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input#user,input#pass")).clear();
			//9.Using last-of-type CSS Selector
			driver.findElement(By.cssSelector(".samples:nth-of-type(3)>li:last-of-type")).click();
			//10.Using Tag and Class CSS Selector
			driver.findElement(By.cssSelector("input.txt_log")).sendKeys("Aadvi@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input.txt_log")).clear();
			driver.navigate().back();
			//11.Using nth-of-type CSS Selector
			driver.findElement(By.cssSelector(".samples:nth-of-type(3)>li:nth-of-type(6)")).click();
			driver.navigate().back();
			//12.Using tag:nth-child(n) CSS Selector
			driver.findElement(By.cssSelector(".samples:nth-of-type(3)>li:nth-child(5)")).click();
			driver.navigate().back();
			//13.Using Sibling “+” Operator CSS Selector
			driver.findElement(By.cssSelector(".samples:nth-of-type(3)>li:nth-child(3)+li")).click();
			WebElement user=driver.findElement(By.cssSelector("input#pass"));
			user.sendKeys("keerthana");
			user.getText();
			driver.findElement(By.partialLinkText("Generic Registration")).click();
			//14.Using Tag & Attribute & Value Trio
			WebElement firstname= driver.findElement(By.cssSelector("input[name='q[2]']"));
			firstname.sendKeys("Anirudh");
			firstname.getText();
			System.out.println(firstname.getAttribute("type"));
			String color = firstname.getCssValue("color");
			System.out.println("Color value : " +color);
			String border = firstname.getCssValue("border");
			System.out.println("border value : " +border);
			String font = firstname.getCssValue("font-size");
			System.out.println("Font size value : " +font);
			driver.navigate().back();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Test Passed");
		}
		catch(Exception e){
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Test Failed- " + errorMsg[0]);
		}
	}
	@BeforeClass
	public void beforeClass() {
		System.setProperty("WebDriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-extensions");
		driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
	}
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
