package selenium.practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XPathAxesFunctionsAssignment {

	static ExtentReports report;
	static ExtentTest test;

	WebDriver driver;

	@Test
	public void axesMethods() throws InterruptedException {

		//Ancestor
		driver.findElement(By.xpath("//div[@class='_6luy _55r1 _1kbt']/ancestor::div/div/input[@type='text']")).sendKeys("testuser1@gmail.com");
		Thread.sleep(1000);

		//Ancestor-or-self
		driver.findElement(By.xpath("//div[@class='_6luy _55r1 _1kbt']/ancestor-or-self::div/div/input[@type='password']")).sendKeys("Testuser1@123");
		Thread.sleep(1000);

		//Child
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/form/div/child::div/input[@id='email']")).clear();
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/form/div/child::div/input[@id='email']")).sendKeys("testuser2@gmail.com");

		//Descendant
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/descendant::div/input[@name='pass']")).clear();
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/descendant::div/input[@name='pass']")).sendKeys("User@2");
		Thread.sleep(1000);

		//Descendant-or-self
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/descendant-or-self::div/div/input[@data-testid='royal_email']")).clear();
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']/descendant-or-self::div/div/input[@data-testid='royal_email']")).sendKeys("testuser3@gmail.com");

		//Following
		driver.findElement(By.xpath("//div[@class='_6lux']/following::input[@type='password']")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/following::input[@type='password']")).sendKeys("Testuser3@123");
		Thread.sleep(1000);

		//Preceding
		driver.findElement(By.xpath("//div[@class='_6lux']/preceding::input[@type='text']")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/preceding::input[@type='text']")).sendKeys("testuser4@gmail.com");

		//Following-sibling
		driver.findElement(By.xpath("//div[@class='_6lux']/following-sibling::div/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/following-sibling::div/div/input")).sendKeys("User@4");
		Thread.sleep(1000);

		//Preceding-sibling
		driver.findElement(By.xpath("//div[@class='_6lux']/preceding-sibling::div/input")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/preceding-sibling::div/input")).sendKeys("testuser5@gmail.com");

		//Self
		driver.findElement(By.xpath("//div[@class='_6lux']/self::div/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/self::div/div/input")).sendKeys("Testuser5@123");
		Thread.sleep(1000);

		//Parent
		driver.findElement(By.xpath("//div[@class='_6lux']/parent::div/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']/parent::div/div/input")).sendKeys("testuser6@gmail.com");

		//Attribute
		driver.findElement(By.xpath("//input[attribute::id='pass']")).clear();
		driver.findElement(By.xpath("//input[attribute::id='pass']")).sendKeys("User@6");
		Thread.sleep(1000);

		String s = driver.findElement(By.xpath("//ancestor::h2")).getText();
		System.out.println(s);
		if(s.contains("Facebook")) {
			test.log(LogStatus.PASS,"Successfully tested Facebook page with xPath Axes");
		}
		else {
			test.log(LogStatus.FAIL,"Failed to test Facebook page with xPath Axes");
		}

	}

	@BeforeClass
	public void openBrowser() throws InterruptedException {
		System.setProperty("WebDriver.edge.driver","./drivers/msedgedriver.exe");
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new EdgeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		//Extent report
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("TC001");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		report.flush();
		report.endTest(test);
	}

}
