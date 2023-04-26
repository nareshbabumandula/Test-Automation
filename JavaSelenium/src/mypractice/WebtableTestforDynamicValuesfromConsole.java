package mypractice;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebtableTestforDynamicValuesfromConsole{
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;

	@Test
	public void webtablemethods() throws InterruptedException {
		boolean bflag = false;
		Scanner scanner = new Scanner(System.in);
		try {
			/**In this code, the "Scanner class" is used to read the table ID by the user from the console using the "nextLine() method".
			 *  The table ID is then used to dynamically construct the XPath expressions to locate the table rows and columns.**/
			System.out.print("Enter table ID: ");
			String tableID = scanner.nextLine(); // read table ID from console
			List<WebElement> noRows = driver.findElements(By.xpath("//table[@id='" + tableID + "']/tbody/tr"));
			int rowcount = noRows.size();
			System.out.println("No of rows in a webtable:" + rowcount);
			List<WebElement> noColumns = driver.findElements(By.xpath("//table[@id='" + tableID + "']/tbody/tr/th"));
			int colcount = noColumns.size();
			System.out.println("No of columns in a webtable:" + noColumns.size());
			bflag = true;

			for (int i = 1; i <= rowcount; i++) {
				if (i == 1) {
					for (int j = 1; j <= colcount; j++) {
						String cellHeadderText = driver.findElement(By.xpath("//table[@id='" + tableID + "']/tbody/tr[" + i + "]/th[" + j + "]")).getText();
						System.out.print(cellHeadderText + "     ");
					}
				} else {
					System.out.println();
					for (int j = 1; j <= colcount; j++) {
						String cellBodyText = driver.findElement(By.xpath("//table[@id='" + tableID + "']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
						System.out.print(cellBodyText + "     ");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (bflag) {
				test.log(LogStatus.PASS, "successfully performed operations on a webtable");
			} else {
				test.log(LogStatus.FAIL, "failed to perform operations on a webtable");
			}
			scanner.close(); // close the scanner
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
