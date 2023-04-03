package selenium.practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserExtentReport {

	static ExtentReports report;
	static ExtentTest test;
	WebDriver driver;

	@Test
	public void websiteTest() throws InterruptedException {
		try {
			driver.navigate().to("https://www.myntra.com/shop/men");
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().to("https://www.myntra.com/men-tshirts");
			driver.navigate().refresh();
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("https://Amazon.in");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(3000);
			WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
			search.clear();
			search.sendKeys("Iphone 14 Pro");
			Thread.sleep(2000);
			search.submit();
			Thread.sleep(3000);
			String txt = driver.findElement(By.xpath("//span[contains(text(),'iPhone14')]")).getText();
			if(txt.contains("iPhone14")) {
				test.log(LogStatus.PASS, "Successfully Searched the product.");
			}
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Failed Searched the product." + e.getMessage());
		}
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 14 pro max");
		//driver.findElement(By.className("nav-input")).click();
		WebElement searchh = driver.findElement(By.name("field-keywords"));
		searchh.clear();
		searchh.sendKeys("Oneplus");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		//WebElement searchhh = driver.findElement(By.className("nav-input nav-progressive-attribute"));
		WebElement s = driver.findElement(By.name("field-keywords"));
		s.clear();
		s.sendKeys("Samsung");
		Thread.sleep(2000);
		s.submit();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Samsung Galaxy S23 Ultra 5G (Cream, 12GB, 1TB Storage)")).click();
		driver.close();
	}

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		System.setProperty("WebDriver.edge.driver", "./drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Myntra.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		//Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("MYT_TC001");
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		driver.close();
		report.endTest(test);
		report.flush();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Successfully Completed.");

	}
}
