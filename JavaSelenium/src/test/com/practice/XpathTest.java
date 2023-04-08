package test.com.practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class XpathTest {
	WebDriver browser;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void methods()throws InterruptedException {
		//CSS locator using #(id)
		try {
			browser.get("https://affiliate.flipkart.com/login");
			browser.manage().window().maximize();
			browser.findElement(By.cssSelector("input#inputEmail")).sendKeys("keerthana@gmail.com");
			Thread.sleep(1000);
			browser.findElement(By.cssSelector("input#inputEmail")).clear();
			String str = browser.findElement(By.cssSelector("input#inputEmail")).getText();
			if(str.contains("keerthana08@gmail.com")); {
				test.log(LogStatus.PASS, "Successfully launch the browser and entered the mail");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Test failed");
		}
		//CSS Locator using .(classname)
		try {
			browser.findElement(By.cssSelector("input.form-control")).sendKeys("keer@12345");
			Thread.sleep(1000);
			browser.findElement(By.cssSelector("input.form-control")).clear();
			String st = browser.findElement(By.cssSelector("input.form-control")).getText();
			if(st.contains("input.form-control")); {
				test.log(LogStatus.PASS, "Successfully entered the password");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Test failed");
		}
		//xpath -based on index
		try {
			browser.findElement(By.xpath("//ul[@class='nav nav-sidebar']/li[5]")).click();
			Thread.sleep(1000);
			browser.navigate().back();
			String index=browser.findElement(By.xpath("//ul[@class='nav nav-sidebar']/li[5]")).getText();
			if(index.contains("Home")); {
				test.log(LogStatus.PASS, "Test passed");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Test failed");
		}
		//xpath using /..
		try {
			browser.findElement(By.xpath("//input[@id='inputPassword']/../input")).sendKeys("Keerthana123@gmail.com");
			Thread.sleep(1000);
			browser.findElement(By.xpath("//input[@id='inputPassword']/../input")).clear();
			String str =browser.findElement(By.xpath("//input[@id='inputPassword']/../input")).getText();
			if(str.contains("Keerthana123@gmail.com")); {
				test.log(LogStatus.PASS, "Test passed");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Test failed");
		}
		//CSS using starts-with,end-with and contains 
		try {
			browser.switchTo().newWindow(WindowType.WINDOW);
			browser.navigate().to("https://www.amazon.in/");
			browser.manage().window().maximize();
			browser.findElement(By.cssSelector("input[id$=tabsearchtextbox]")).sendKeys("Handbag");
			Thread.sleep(1000);
			browser.findElement(By.cssSelector("input[id$=tabsearchtextbox]")).clear();
			String find =browser.findElement(By.cssSelector("input[id$=tabsearchtextbox]")).getText();
			if(find.contains("Handbag")); {
				test.log(LogStatus.PASS, "Successfully entered the product");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to search the product name");
		}
		try {
			browser.findElement(By.cssSelector("input[id^=twotabsearchtext]")).sendKeys("Fan");
			Thread.sleep(1000);
			browser.findElement(By.cssSelector("input[id^=twotabsearchtext]")).clear();
			String st =browser.findElement(By.cssSelector("input[id^=twotabsearchtext]")).getText();
			if(st.contains("Fan")); {
				test.log(LogStatus.PASS, "Successfully entered the product name");
			}
		}catch(Exception ex) {
			test.log(LogStatus.FAIL, "Failed to search the product");
		}
		try {
			browser.findElement(By.cssSelector("input[id*=searchtextbo]")).sendKeys("AC 1.5 ton");
			Thread.sleep(1000);
			browser.findElement(By.cssSelector("input[id*=searchtextbo]")).clear();
			String Electronic =browser.findElement(By.cssSelector("input[id*=searchtextbo]")).getText();
			if(Electronic.contains("AC 1.5 ton")); {
				test.log(LogStatus.PASS, "Successfully entered the product name");
			}
		}catch(Exception ex) {
			test.log(LogStatus.FAIL, "Failed to search the product");
		}
		//xpath to find the number of links in a webpage
		List<WebElement> links = browser.findElements(By.xpath("//a"));
		//we are finding all the webelements with xpath "//a"
		for(WebElement link: links ) {
			System.out.println(link.getAttribute("href"));
			// to get the value of a given HTML attribute -getattribute
		}
		//Xpath using contains and starts with
		try {
			browser.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).click();
			browser.navigate().back();
			String st=browser.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).getText();
			if(st.contains("Mobiles")); {
				test.log(LogStatus.PASS, "Successfully launched the amazon website and opened the mobiles");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Test failed");
		}
		try {
			browser.findElement(By.xpath("//span[starts-with(@id,'glow-ingress-line2')]")).click();
			Thread.sleep(1000);
			browser.findElement(By.xpath("//input[starts-with(@id,'GLUXZipUpdateInput')]")).sendKeys("500014");
			Thread.sleep(1000);
			String enter =browser.findElement(By.xpath("//span[starts-with(@id,'glow-ingress-line2')]")).getText();
			if(enter.contains("500014")); {
				test.log(LogStatus.PASS, "Successfully opened the address and entered pincode:500014");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Failed to open and enter the pincode");
		}
	}
	@BeforeClass
	public void beforeClass()  {
		WebElement samplelink;
		browser=new EdgeDriver();
		browser.get("https://www.amazon.in/");
		browser.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
	}
	@AfterClass
	public void afterClass() {
		browser.quit();
		report.endTest(test);
		report.flush();
		browser.quit();
	}
}
