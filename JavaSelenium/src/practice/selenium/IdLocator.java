package practice.selenium;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class IdLocator {
	ExtentTest test;
	ExtentReports report;
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		//id-locator
		driver.findElement(By.id("user")).sendKeys("padma");
		Thread.sleep(1000);
		driver.findElement(By.id("user")).clear();
		System.out.println("Enter the name with id locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with id locator ");

		//name-lacator
		driver.findElement(By.name("user")).sendKeys("Ravi");
		Thread.sleep(1000);
		driver.findElement(By.id("user")).clear();
		System.out.println("Enter the name with name locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with name locator ");

		//class
		driver.findElement(By.className("txt_log")).sendKeys("Nikhil");
		Thread.sleep(1000);
		driver.findElement(By.className("txt_log")).clear();
		System.out.println("Enter the name with class locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with class locator ");

		//css
		driver.findElement(By.cssSelector("input[id='user']")).sendKeys("Himani");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='user']")).clear();
		System.out.println("Enter the name with cssSelector locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with css locator ");

		//starts with
		driver.findElement(By.cssSelector("input[id^='use']")).sendKeys("Mom");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id^='use']")).clear();
		System.out.println("Enter the name with starts with locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with starts with locator ");

		//ends with
		driver.findElement(By.cssSelector("input[id$='ser']")).sendKeys("Dad");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id$='ser']")).clear();
		System.out.println("Enter the name with ends with locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with ends with locator ");

		//contains with
		driver.findElement(By.cssSelector("input[id*='se']")).sendKeys("Bro");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='se']")).clear();
		System.out.println("Enter the name with contains with locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with contains with locator ");

		//linketext
		driver.findElement(By.linkText("Sample Forms")).click();
		Thread.sleep(1000);
		System.out.println("Click the Sample Forms with linktext locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with linketext locator ");

		//partial linketext
		driver.findElement(By.partialLinkText("Featur")).click();
		Thread.sleep(1000);
		System.out.println("Click the Fearures with partial linketext locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with partial linketext locator ");

		//tag name
		driver.findElement(By.tagName("input")).sendKeys("sis");
		Thread.sleep(1000);
		driver.findElement(By.tagName("input")).clear();
		System.out.println("Enter the name with tag name locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with tagname locator ");

		//absolute xpath
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("Sri");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/form/fieldset/div/input")).clear();
		System.out.println("Enter the name with absolute xpath locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with absolute xpath locator ");


		//relative xpath
		driver.findElement(By.xpath("//fieldset/div/input")).sendKeys("Padmasri");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//fieldset/div/input")).clear();
		System.out.println("Enter the name with ralative xpath locator");
		test.log(LogStatus.PASS, "Successfully Enter the name with relative xpath locator ");

	}

	@BeforeClass
	public void beforeClass() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdrivr.chrome.driver","./chromedriver.exe");
		driver = new ChromeDriver(options);
		report = new ExtentReports("./TestExtentReportResults.html");
		test = report.startTest("mycontact001");
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();		
		System.out.println("Launch the browser");
		test.log(LogStatus.PASS, "Successfully Launch the browser ");
	}

	@AfterClass
	public void afterClass() {

		report.endTest(test);
		report.flush();
		driver.quit();


	}

}
