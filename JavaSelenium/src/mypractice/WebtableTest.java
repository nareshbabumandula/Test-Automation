package mypractice;

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

public class WebtableTest{
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;

	@Parameters({"firstname"})
	@Test
	public void webtablemethods(String firstname) throws InterruptedException{
		boolean bflag = false;
		try {
			List<WebElement> noRows =  driver.findElements(By.xpath("//table[@id='t01']/tbody/tr")); 
			int rowcount = noRows.size();
			System.out.println("No of rows in a webtable:" + rowcount);
			List<WebElement> noColumns =  driver.findElements(By.xpath("//table[@id='t01']/tbody/tr/th"));
			int colcount = noColumns.size();
			System.out.println("No of columns in a webtable:" + noColumns.size());
			bflag = true;

			for(int i=1;i<=rowcount;i++) {
				if(i==1) {
					for(int j=1;j<=colcount;j++) {
						String cellHeadderText = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr["+i+"]/th["+j+"]")).getText();
						System.out.print(cellHeadderText+"     ");
					}
				}else {
					System.out.println();
					for(int j=1;j<=colcount;j++) {
						String cellBodyText = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr["+i+"]/td["+j+"]")).getText();
						System.out.print(cellBodyText+"     ");
						if(cellBodyText.equals(firstname)) {
							String age = driver.findElement(By.xpath("//table[@id='t01']/tbody/tr["+i+"]/td[3]")).getText();
							System.out.println("\n Age of "+firstname+" is:" +age);
							test.log(LogStatus.PASS,"\n Age of "+firstname+" is:" +age);
						}
					}
				}
			}


		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(bflag = true) {
				test.log(LogStatus.PASS,"successfully performed operations on a webtable");
			}
			else {
				test.log(LogStatus.FAIL,"failed to perform operations on a webtable");
			}
		}
	}


	@BeforeClass
	public void beforeClass() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println("Successfully launched the Browser");
		//Extent Report
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("WTT_TC001");

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
		report.flush();
		report.endTest(test);
		System.out.println("Successfully Closed the Browser");
	}

}
