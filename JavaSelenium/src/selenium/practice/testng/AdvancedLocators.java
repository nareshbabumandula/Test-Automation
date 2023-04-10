package selenium.practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvancedLocators {

	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;

	@Test
	public void advLocatorsTest() throws InterruptedException {

		try {
			driver.get("https://www.primevideo.com/");
			driver.manage().window().maximize();
			Thread.sleep(1000);

			//Absolute XPath
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//html/body/div/div/header/div/div/div/div/div/div/div/ol/li/label/div[@class='JJLwL-']"))).perform();
			Thread.sleep(1000);

			//Relative XPath
			driver.findElement(By.xpath("//li/a[text()='Sign In']")).click();
			Thread.sleep(1000);

			//XPath with Attributes
			driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("testuser1@gmail.com");

			//XPath with Multiple Attributes
			driver.findElement(By.xpath("//input[@id='ap_password'] [@name='password']")).sendKeys("TestUser1@123");
			Thread.sleep(1000);

			//XPath with Multiple Attributes with 'AND' Condition
			//driver.findElement(By.xpath("//input[@id='signInSubmit' and @type='submit']")).click();

			////XPath with Multiple Attributes with 'OR' Condition
			WebElement element = driver.findElement(By.xpath("//input[@id='ap_email' or @type='email']"));
			element.clear();
			element.sendKeys("testuser2@gmail.com");

			//XPath with 'starts_with' function
			driver.findElement(By.xpath("//input[starts-with(@id,'ap_p')]")).clear();
			driver.findElement(By.xpath("//input[starts-with(@id,'ap_p')]")).sendKeys("User@2");
			Thread.sleep(1000);

			//XPath with 'contains' function
			driver.findElement(By.xpath("//input[contains(@id,'ai')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'ai')]")).sendKeys("testuser3@gmail.com");

			//XPath with '/..'
			driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']/../input")).sendKeys("Testuser3@123");
			Thread.sleep(1000);

			//XPath with //*[@Attributename='Attribute Value']
			driver.findElement(By.xpath("//*[@id='ap_email']")).clear();

			//XPath with //TagName[@*='Attribute Value']
			driver.findElement(By.xpath("//input[@*='password']")).clear();
			Thread.sleep(1000);

			//XPath with 'contains(text(),'value')'
			driver.findElement(By.xpath("//a[contains(text(),'Create your Amazon account')]")).click();
			
			driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Testuser");
			driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']")).sendKeys("testuser@gmail.com");
			driver.findElement(By.xpath("//input[@id='ap_password'] [@name='password']")).sendKeys("Testuser@123");
			driver.findElement(By.xpath("//input[contains(@id,'check')]")).sendKeys("Testuser@123");
			Thread.sleep(2000);
			test.log(LogStatus.PASS,"Successfully Executed using XPath Functions.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,"Failed to Use XPath Functions.");
		}
		try {
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get("https://www.flipkart.com");
			Thread.sleep(2000);
			
			//Absolute cssSelector
			driver.findElement(By.cssSelector("html>body>div:nth-of-type(2)>div>div>div>div>div>div>form>div>input")).sendKeys("0123456789");
			
			//Relative cssSelector
			driver.findElement(By.cssSelector("div>button[class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
			
			//cssSelector using 'class' with '.'
			driver.findElement(By.cssSelector("input._3704LK")).sendKeys("the fault in our star");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			Thread.sleep(2000);
			driver.close();
			test.log(LogStatus.PASS,"Successfully Executed using cssSelector Functions.");
		}
		catch(Exception ee) {
			System.out.println(ee.getMessage());
			test.log(LogStatus.FAIL,"Failed to Use cssSelector Functions.");
		}
	}
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-extensions");
		driver = new ChromeDriver(options);
		System.out.println(driver.getTitle());
		System.out.println("Successfully launched the Browser");
		//Extent Report
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("AFW_TC001");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		report.flush();
		report.endTest(test);
		System.out.println("Successfully Closed the Browser");
	}

}
