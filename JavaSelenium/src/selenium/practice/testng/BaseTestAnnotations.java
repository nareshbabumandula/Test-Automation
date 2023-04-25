package selenium.practice.testng;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
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
		System.setProperty("WebDriver.edgedriver.driver","./drivers/msedgedriver.exe");
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new EdgeDriver(option);
		driver.manage().window().maximize();
		//driver.get("https://www.google.com");
		System.out.println("BeforeTest : Launched the Edge Browser.");
	}

	@AfterTest
	public void closeBrowser() {
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("AfterTest : CLosed the Edge Browser.");
	}

	@AfterSuite
	public void teardown() throws Exception {
		Desktop.getDesktop().browse(new File("ExtentReportResults.html").toURI());
		System.out.println("AfterSuite : Extent Report has generated.");
	}

}
