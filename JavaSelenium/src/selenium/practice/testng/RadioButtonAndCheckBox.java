package selenium.practice.testng;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class RadioButtonAndCheckBox {

	static ExtentReports reports;
	static ExtentTest test;

	WebDriver driver;

	@Test 
	public void buttonTest() throws InterruptedException {
		try {
			//click method
			driver.findElement(By.partialLinkText("Sample")).click();

			//Alternate click method using JavascriptExecutor
			WebElement login = driver.findElement(By.name("btnSubmit"));
			JavascriptExecutor clk = (JavascriptExecutor)driver;
			clk.executeScript("arguments[0].click();",login);
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Successfully clicked the login button.");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL,"Failed to click the login button.");
		}
	}
	@Test
	public void checkBoxTest() throws InterruptedException {
		try {
			//click method using cssSelector AND 'Tag name[][]'
			driver.findElement(By.cssSelector("input[name='email_to[]'][value='0']")).click();
			Thread.sleep(1000);

			//using JAvascriptExecutor using '*' AND '*[][]'
			WebElement tick = driver.findElement(By.cssSelector("*[name='email_to[]'][value='2']"));
			JavascriptExecutor chk = (JavascriptExecutor)driver;
			chk.executeScript("arguments[0].click();",tick);
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Successfully clicked the Check Box button.");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL,"Failed to click the Check Box button.");
		}
	}

	@Test
	public void radioButtonTest() throws InterruptedException {
		try {
			//click method using cssSelector contains word 'Tag Name[Attribute ~= value']
			driver.findElement(By.cssSelector("input[value~='First']")).click();
			Thread.sleep(1000);

			//using JAvascriptExecutor using cssSelector contains 'Tag Name[Attribute *= value']
			WebElement selct = driver.findElement(By.cssSelector("input[value*='Third O']"));
			JavascriptExecutor rad = (JavascriptExecutor)driver;
			rad.executeScript("arguments[0].click();",selct);
			Thread.sleep(2000);
			test.log(LogStatus.PASS,"Successfully clicked the Radio button.");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL,"Failed to click the Radio button.");
		}
		try {
			List<WebElement> checkboxes = driver.findElements(By.name("checkbox6[]"));
			System.out.println("Total No Of Check Boxes : " + checkboxes.size());
			//Clicking all the check boxes using 'for each loop'
			for(WebElement chkbox : checkboxes) {
				chkbox.click();
			}
			Thread.sleep(1000);
			//Clicking  Alternate check boxes using 'for loop'
			for(int i=0; i<checkboxes.size(); i++) {
				if(i%2==0) {
					checkboxes.get(i).click();
					Thread.sleep(1000);
				}
			}
			//Clicking specific check boxes using 'for each loop'
			for(WebElement chkboxes : checkboxes) {
				String s = chkboxes.getAttribute("value");
				if(s.equals("Second Check Box") || s.equals("Fourth Check Box")) {
					chkboxes.click();
					Thread.sleep(1000);
				}
			}
			//clicking first 2 check boxes using 'for loop' 
			/*int firsttwo = checkboxes.size();
			System.out.println(firsttwo);*/
			for(int j=0; j<checkboxes.size()-3; j++) {
				checkboxes.get(j).click();
			}
			//clicking last 2 check boxes using 'for loop'
			int lasttwo = checkboxes.size();
			System.out.println(lasttwo);
			for(int k=lasttwo-2; k<lasttwo; k++) {
				checkboxes.get(k).click();
			}
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Successfully clicked all the Check Boxes.");
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL,"Failed to click all the Check Boxes.");
		}
	}
	
	/*
	 * @Test public void multipleCheckBoxTest() throws InterruptedException { }
	 */
	@BeforeClass
	public void launchBrowser() throws InterruptedException { 
		System.setProperty("WebDriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("disable-extensions");
		driver = new ChromeDriver(opt);
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		reports = new ExtentReports("./ExtentReportResults.html");
		test = reports.startTest("MCF_TC001");
	}

	@AfterClass
	public void closeBrowser() {
		reports.flush();
		reports.endTest(test);
		driver.quit();

	}
}
