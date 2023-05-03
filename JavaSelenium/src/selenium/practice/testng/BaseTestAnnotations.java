package selenium.practice.testng;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.awt.Desktop;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTestAnnotations {

	ExtentReports report;
	ExtentTest test;
	
	WebDriver driver;

	@BeforeSuite
	public void creatingExtentReport() {
		//Extent Report
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("TC001");
		System.out.println("BeforeSuite : Created the Extent Report.");
	}

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chromedriver.driver","./drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		//driver.get("https://www.google.com");
		System.out.println("BeforeTest : Launched the Chrome Browser.");
	}

	@AfterTest
	public void closeBrowser() {
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("AfterTest : CLosed the Chrome Browser.");
	}

	@AfterSuite
	public void teardown() throws Exception {
		Desktop.getDesktop().browse(new File("ExtentReportResults.html").toURI());
		System.out.println("AfterSuite : Extent Report has generated.");
	}

}
