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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TestAnnotaions extends BaseTestAnnotations {

	@BeforeClass
	public void accessSiteAndLogin() {
		try {
			driver.get("https://www.Amazon.in");
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			if(actualTitle.equals(expectedTitle)) {
				test.log(LogStatus.PASS,"Successfully accessed the site.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL,"Failed to access the site.");
		}
		System.out.println("BeforeClass : Successfully accessed and logged into the site.");
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		String e;
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14 pro");
			driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
			e = driver.findElement(By.xpath("//span[contains(text(),'iphone14 pro')]")).getText();
			System.out.println(e);
			if(e.contains("iphone14")) {
				test.log(LogStatus.PASS,"Successfully searched Iphone 14 pro."); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			test.log(LogStatus.FAIL,"Failed to search Iphone 14 pro.");
		} 
		System.out.println("BeforeMethod : Successfully searched the product.");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMethod() throws IOException, Exception {
		String parentTab = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'(128 GB) - Gold')]"));
		//JavascriptExecutor Class
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		//Multiple Window/Tab Handling
		Set<String> WindowHandles = driver.getWindowHandles();
		for(String tab : WindowHandles) {
			if(!tab.equals(parentTab)) {
				driver.switchTo().window(tab);
				//Actions Class
				Actions action = new Actions(driver);
				WebElement purple = driver.findElement(By.cssSelector("input[name='0'][aria-labelledby='color_name_0-announce']"));
				action.moveToElement(purple).perform();
				WebElement silver = driver.findElement(By.cssSelector("img[alt='Silver']"));
				action.moveToElement(silver).perform();
				WebElement black = driver.findElement(By.cssSelector("img[alt='Space Black']"));
				action.moveToElement(black).perform();
				js.executeScript("arguments[0].click();",purple);
				WebElement storagetb = driver.findElement(By.cssSelector("input[aria-labelledby='size_name_0-announce']"));
				action.moveToElement(storagetb).perform();
				WebElement storage = driver.findElement(By.cssSelector("span[id='size_name_3']"));
				action.moveToElement(storage).perform();
				js.executeScript("arguments[0].click();",storage);
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
	public void addtoCart() throws InterruptedException {
		boolean image = false;
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("add-to-cart-button")).click();
			driver.findElement(By.xpath("//form/span/span/input[@class='a-button-input']")).click();
			image = driver.findElement(By.className("sc-product-image")).isDisplayed();
			//Assertion
			Assert.assertEquals(image, true, "Failed to add in cart."); 
			test.log(LogStatus.PASS, "Successfully added iphone14 pro to cart.");
			System.out.println("afterMethod : Successfully added iphone14 pro to cart.");
		} catch (Exception e1) {
			e1.printStackTrace();
			test.log(LogStatus.FAIL,"Failed to add in cart.");
		}
		//DropBox
		boolean quantity = false;
		try {
			quantity = true;
			WebElement element = driver.findElement(By.xpath("//select[@name='quantity']"));
			Select select = new Select(element);
			select.selectByIndex(3);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(quantity) {
				test.log(LogStatus.PASS,"Successfully added quantity.");
			}else {
				test.log(LogStatus.FAIL,"Failed to add quantity.");
			}
		}
	}

	@AfterClass
	public void logout() {
		System.out.println("AfterClass : Successfully logged out.");
		//test.log(LogStatus.PASS,"Successfully executed AfterTest.");
	}

}
