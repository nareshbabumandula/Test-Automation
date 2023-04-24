package selenium.practice.testng;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TestAnnotaions extends BaseTestAnnotations {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14 pro");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String e =driver.findElement(By.xpath("//span[contains(text(),'iphone14 pro')]")).getText();
		if(e.contains("iphone14")) {
			test.log(LogStatus.PASS,"Successfully searched Iphone 14 pro.");  
		}else {
			test.log(LogStatus.FAIL,"Failed to search Iphone 14 pro.");
		}
		System.out.println("beforeMethod.");
	}

	@Test
	public void testMethod() throws IOException, Exception {
		String parentTab = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 14 Pro (128 GB) - Gold')]"));
		//JavascriptExecutor Class
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		Set<String> WindowHandles = driver.getWindowHandles();
		for(String tab : WindowHandles) {
			if(!tab.equals(parentTab)) {
				driver.switchTo().window(tab);
				//Actions Class
				Actions action = new Actions(driver);
				WebElement purple = driver.findElement(By.xpath("//input[@name='0']"));
				action.moveToElement(purple).perform();
				WebElement silver = driver.findElement(By.xpath("//input[@name='2']"));
				action.moveToElement(silver).perform();
				WebElement black = driver.findElement(By.xpath("//input[@name='3']"));
				action.moveToElement(black).perform();
				js.executeScript("arguments[0].click();",purple);
				WebElement storagetb = driver.findElement(By.xpath("//input[@name='0'][@aria-labelledby='size_name_0-announce']"));
				action.moveToElement(storagetb).perform();
				WebElement storage = driver.findElement(By.xpath("//input[@name='3'][@aria-labelledby='size_name_3-announce']"));
				action.moveToElement(storage).perform();
				storage.click();
				boolean finalVariant = driver.findElement(By.cssSelector("span#productTitle")).isDisplayed();
				if(finalVariant) {
					System.out.println("Successfully finalised the iphone14 pro 512GB Deep Purple colour.");
					test.log(LogStatus.PASS,"Successfully finalised the variant of Iphone 14 pro.");  
				}else {
					test.log(LogStatus.FAIL,"Failed to finalise the variant of Iphone 14 pro.");
				}
			}
		}
		System.out.println("Test Method passed.");
	}

	@AfterMethod
	public void addtoCart() {
		boolean image = false;
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//form/span/span/input[@class='a-button-input']")).click();
	    image = driver.findElement(By.className("sc-product-image")).isDisplayed();
		Assert.assertEquals(image, true, "Failed adding to cart.");
		test.log(LogStatus.PASS, "Successfully iphone14 pro added to cart.");
		System.out.println("afterMethod.");
		//test.log(LogStatus.PASS,"Successfully executed AfterMethod.");
	}

	@BeforeClass
	public void accessSite() {
		driver.get("https://www.Amazon.in");
		System.out.println("beforeTest.");
	}

	@AfterClass
	public void afterTest() {
		System.out.println("afterTest.");
		//test.log(LogStatus.PASS,"Successfully executed AfterTest.");
	}

}
