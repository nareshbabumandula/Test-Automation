package com.selenium.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebTableTest{

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	
	@Parameters({"firstname"})
	@Test(groups = {"smoke"})
	public void webtableMethods() throws InterruptedException {
		String firstName = "Jemma";
		boolean bFlag=false;
		try {
			List<WebElement> nRows = driver.findElements(By.xpath("//table[@id='t01']/tbody/tr"));
			int rowcount = nRows.size();
			System.out.println("No of rows in a webtable are : " + rowcount);
			List<WebElement> nColumns = driver.findElements(By.xpath("//table[@id='t01']/tbody/tr/th"));
			int colCount = nColumns.size();
			System.out.println("No of columns in a webtable are : " + colCount);
			
			for (int i = 2; i <= rowcount; i++) {
				for (int j = 1; j <= colCount; j++) {
					String cellText = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println(cellText);
						
					if (cellText.equals(firstName)) {
						String age = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr["+i+"]/td[3]")).getText();
						System.out.println("Age of " +firstName+ " is : " + age);
						test.log(LogStatus.PASS, "Age of " +firstName+ " is : " + age);
						System.out.println(firstName + " found at row : " + i + " and column :" +j);
					}
				}
			}
			
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(bFlag){
				test.log(LogStatus.PASS, "Successfully performed operations on webtable");
			}else{
				test.log(LogStatus.FAIL, "Failed to perform operations on webtable");
			}
		}
	}

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("WebTable Methods");
	}
		
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}

}
