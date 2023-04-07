package selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Locators {

	static WebDriver driver;

	@BeforeClass
	public void lauchBrowser() {
		
		System.setProperty("webdriver.chromedriver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void amazonSearch() throws InterruptedException {
		
		// css
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("acer 2023");
		// Using # write CSS locator with ID
		driver.findElement(By.cssSelector("span#nav-search-submit-text")).click();
		// Write XPath using contains function
		driver.findElement(By.xpath("//span[contains(text(),'Acer 2023 Newest Aspire 5 15.6\" FHD IPS Slim Lapto')]"))
		.click();
		// Using . write CSS locator with Class
		driver.findElement(By.cssSelector("input[name='submit.addToCart']")).click();
		// Write xpath using contains function
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[contains(@class,'a-button-input')]")).click();
		// Write CSS using starts-with
		driver.findElement(By.cssSelector("input[id^='twotab']")).sendKeys("samsung galaxy s23 ultra");
		driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();
		// Xpath using index
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		// Write CSS using ends-with
		driver.findElement(By.cssSelector("input[id$=cart-button]")).click();
		// Write css with #
		driver.findElement(By.cssSelector("#attach-close_sideSheet-link")).click();
		// Using . write CSS locator with Class
		driver.findElement(By.cssSelector("span[id='nav-cart-count']")).click();
		// Write XPath using starts-with
		driver.findElement(By.xpath("(//input[starts-with(@name,'proceed')])[1]")).click();
		// id
		driver.findElement(By.id("ap_email")).sendKeys("123");
		// classname
		driver.findElement(By.className("a-button-input")).click();
		// css
		String errormsg = driver.findElement(By.cssSelector("h4[class=a-alert-heading]")).getText();
		
		System.out.println(errormsg);
		
	
	}
	@AfterClass
	public void closeBroswe() {
		driver.quit();
	}
}
