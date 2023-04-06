package selenium.practice.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TabsAssignment {
	
	WebDriver driver;
	
	@Test
	public void advLocatorsTest() throws InterruptedException {
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='header']/ul/li"));
		System.out.println("My Contact Form Tabs are : ");
		for(WebElement menuTabs:tabs) {
			System.out.println(menuTabs.getText());
		}
		driver.navigate().to("https://www.Amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[4]")).click();
		Thread.sleep(2000);
		List<WebElement> brandTabs = driver.findElements(By.xpath("//span[starts-with(text(),'Brands')]/parent::div/parent::div/ul/li"));
		System.out.println();
		System.out.println("The Brand Names are : ");
		for(WebElement menu : brandTabs) {
			System.out.println(menu.getText());
		}
	}
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-extensions");
		driver = new ChromeDriver(options);
		System.out.println(driver.getTitle());
		System.out.println("Successfully launched the Browser");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("Successfully Closed the Browser");
	}
}
