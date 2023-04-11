package selenium.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CssPractice {
	
	static WebDriver driver;
	
	@BeforeClass
	public void lauchBrowser() {

		System.setProperty("webdriver.chromedriver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void searchFunctionality() throws InterruptedException {
		
		//Using :nth-of-type(n) CSS Selector 
		driver.findElement(By.cssSelector("._2hriZF>div>button:nth-of-type(1)")).click();
		//CSS with className
		driver.findElement(By.cssSelector("._3704LK")).sendKeys("men");
		Thread.sleep(2000);
		//Using *:last-of-type CSS Selector 
		driver.findElement(By.cssSelector("div > button > svg")).click();//svg>g>*:last-of-type
		//Using Tag & Attribute & Value
		driver.findElement(By.cssSelector("a[title='Casual Shirts']")).click();
		// Using Containing Text of an Attribut
		driver.findElement(By.cssSelector("a[title*='Men Regular Fit Solid Casual Shirt']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		java.util.Iterator<String> it = windowHandles.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		//Using tag names
		driver.findElement(By.cssSelector("#swatch-3-size>a")).click();
		//Using tag:nth-child(n) 
		driver.findElement(By.cssSelector("div>ul>li:nth-child(1)>button")).click();
		driver.findElement(By.cssSelector("div:nth-child(6)>div>div>a>span")).click();
	    //Using Containing Text
		driver.findElement(By.cssSelector("div[class*='3ds']")).click();		
	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.quit();
	}
}
