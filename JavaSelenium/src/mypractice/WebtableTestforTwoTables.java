package mypractice;

import java.util.List;

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

public class WebtableTestforTwoTables{
	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;

	@Test
	public void webtablemethods() throws InterruptedException{
		boolean bflag = false;
		try {
			/**In this code, we have an array tableIDs that stores the ID values of both tables. 
			 * We iterate over each ID value in the array, and for each ID, we retrieve the number of rows and columns in that table,
			 *  and print the header and body cell values.
			 *   The \n\n at the end of the loop prints two new lines to separate the two tables.**/
			String[] tableIDs = {"t01", "t02"};
			for (String tableID : tableIDs) {
				List<WebElement> noRows = driver.findElements(By.xpath("//table[@id='" + tableID + "']/tbody/tr"));
				int rowcount = noRows.size();
				System.out.println("No of rows in " + tableID + " webtable:" + rowcount);
				List<WebElement> noColumns = driver.findElements(By.xpath("//table[@id='" + tableID + "']/tbody/tr/th"));
				int colcount = noColumns.size();
				System.out.println("No of columns in " + tableID + " webtable:" + colcount);
				bflag = true;
				for(int i=1; i<=rowcount; i++) {
					if(i==1) {
						for(int j=1; j<=colcount; j++) {
							String cellHeaderText = driver.findElement(By.xpath("//table[@id='" + tableID + "']/tbody/tr["+i+"]/th["+j+"]"))
									.getText();
							System.out.print(cellHeaderText + "     ");
						}
					} else {
						System.out.println();
						for(int j=1; j<=colcount; j++) {
							String cellBodyText = driver.findElement(By.xpath("//table[@id='" + tableID + "']/tbody/tr["+i+"]/td["+j+"]"))
									.getText();
							System.out.print(cellBodyText + "     ");
						}
					}
				}
				System.out.println("\n\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if(bflag == true) {
				test.log(LogStatus.PASS,"successfully performed operations on webtables");
			} else {
				test.log(LogStatus.FAIL,"failed to perform operations on webtables");
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
