package selenium.practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class cssSelectorAssignment {

	ExtentReports report;
	ExtentTest test;

	WebDriver driver;

	@Test
	public void fillingDetails() throws InterruptedException {
		try {
			//CSS Selector using Tag Name
			driver.findElement(By.cssSelector("input")).sendKeys("TestUser");

			//CSS Selector using id with '#"
			driver.findElement(By.cssSelector("input#pass")).sendKeys("Testuser@123");
			Thread.sleep(1000);
			
			//Using nth-of-type
			driver.findElement(By.cssSelector("body>div>ul>li:nth-of-type(6)>a")).click();

			//Absolute CSS Selector
			driver.findElement(By.cssSelector("div>div>div>form>fieldset>div>input[name='user']")).sendKeys("TestUser");

			//Non Absolute CSS Selector (Using '#' for 'id' and '.' for 'class' combined)
			driver.findElement(By.cssSelector("input.txt_log#pass")).sendKeys("Testuser@123");

			// CSS Selector Using Attribute
			driver.findElement(By.cssSelector("input[value='0']")).click();

			//CSS Selector Using Attribute
			driver.findElement(By.cssSelector("input[value='1']")).click();

			//CSS Selector Using contains '*' 
			driver.findElement(By.cssSelector("input[name*='ai']:nth-of-type(3)")).click();

			//CSS Selector Using Starts with '^'
			driver.findElement(By.cssSelector("input[name^='sub']")).sendKeys("Testing");;

			//CSS Selector Using Ends with '$'
			driver.findElement(By.cssSelector("input[name$='il']")).sendKeys("testuser@gmail.com");

			//CSS Selector using 'OR' ','
			driver.findElement(By.cssSelector("input#q1,input.text")).sendKeys("Test Field");
			
			//CSS Selector using Sibling '+'
			driver.findElement(By.cssSelector("td>label+textarea#q2")).sendKeys("This is the test description for my contact form.");
			
			//CSS Selector using 'first-of-type'
			driver.findElement(By.cssSelector("tr>td>select:first-of-type")).click();
			
			//CSS Selector using 'last-of-type'
			driver.findElement(By.cssSelector("tr>td>select>option:last-of-type")).click();
			
			//CSS Selector using 'nth-child(n)'
			driver.findElement(By.cssSelector("div>input:nth-child(7)")).click();

			Thread.sleep(5000);
			test.log(LogStatus.PASS,"Successfully Entered the details in Sample Form.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,"Failed to Enter the Details in Sample Form.");
		}
	}

	@BeforeClass
	public void openBrowser() {
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		System.setProperty("WebDriver.edge.driver","./drivers/msedgedriver.exe");
		driver = new EdgeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com");
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("MCF_TC001");

	}

	@AfterClass
	public void closeBrowser() {
		report.flush();
		report.endTest(test);
		driver.quit();
	}

}
