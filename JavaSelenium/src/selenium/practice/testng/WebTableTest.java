package selenium.practice.testng;

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

public class WebTableTest {

	ExtentReports report;
	ExtentTest test;

	WebDriver driver;

	@Test(priority = 0)
	public void webTable() throws InterruptedException {
		test = report.startTest("WTT_TC001");
		boolean bflag = false;
		try {
			driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");
			List<WebElement> row = driver.findElements(By.cssSelector("table#t01>tbody>tr"));
			System.out.println("No.of Rows in First Table : " + row.size());
			List<WebElement> column = driver.findElements(By.cssSelector("table#t01>tbody>tr>th"));
			System.out.println("No.of Columns in First Table : " + column.size());
			for(int i=1; i<=column.size(); i++) {
				String element = driver.findElement(By.cssSelector("table#t01>tbody>tr:nth-of-type(1)>th:nth-of-type("+ i +")")).getText();
				System.out.print(element);
				System.out.print("   ");
			}
			System.out.println();
			for(int i=2; i<=row.size(); i++) {
				for(int j=1; j<=column.size(); j++) {
					String data = driver.findElement(By.cssSelector("table#t01>tbody>tr:nth-of-type("+ i +")>td:nth-of-type("+ j +")")).getText();
					System.out.print(data);
					System.out.print("    ");
				}
				System.out.println();
			}
			bflag = true;
			System.out.println("-----------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bflag) {
				test.log(LogStatus.PASS,"Successfully printed the first table data.");
			}else {
				test.log(LogStatus.FAIL,"Failed to print the first table data.");
			}
		}
	}

	@Test(priority = 1)
	public void secondWebTable() {
		test = report.startTest("WTT_TC002");
		boolean bflagg = false;
		try {
			List<WebElement> row = driver.findElements(By.xpath("//table[@id='t02']/tbody/tr"));
			System.out.println("No of rows in Second Table: " + row.size());
			List<WebElement> column = driver.findElements(By.xpath("//table[@id='t02']/tbody/tr/th"));
			System.out.println("No of columns in Second Table: " + column.size());
			for(int i=1; i<=column.size(); i++) {
				String ele = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr/th["+ i +"]")).getText();
				System.out.print(ele);
				System.out.print("    ");
			}
			System.out.println();
			for(int i=2; i<=row.size(); i++) {
				for(int j=1; j<=column.size(); j++) {
					String elements = driver.findElement(By.xpath("//table[@id='t02']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
					System.out.print(elements);
					System.out.print("      ");
				}
				System.out.println();
			}
			bflagg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bflagg) {
				test.log(LogStatus.PASS,"Successfully printed the Second table data.");
			}else {
				test.log(LogStatus.FAIL,"Failed to print the Second table data.");
			}
		}
	}
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
	}

	@AfterClass
	public void closeBrowser() {
		report.flush();
		report.endTest(test);
		driver.quit();
	}

}
