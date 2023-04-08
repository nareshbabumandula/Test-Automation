package selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class XpathAxes {

	WebDriver driver;

	@BeforeClass
	public void lauchBrowser() {

		System.setProperty("webdriver.chromedriver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.mycontactform.com/");
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void search() {

		//self
		driver.findElement(By.xpath("//a[contains(text(),'Sample')]/self::a")).click();
		//Ancestor
		driver.findElement(By.xpath("//input[@type='checkbox']/ancestor::td/div/input[1]")).click();
		//ancestor-or-self
		driver.findElement(By.xpath("(//input[@type='checkbox']/ancestor-or-self::input)[2]")).click();
		//child
		driver.findElement(By.xpath("(//td/div/child::input[@type='checkbox'][3])[1]")).click();
		//descendant
		driver.findElement(By.xpath("//td/descendant::input[@id='subject']")).sendKeys("Xpath Practice");
		//Descendant-or-self
		driver.findElement(By.xpath("//input[@name='email']/descendant-or-self::input")).sendKeys("Test@gmail.com");
		//following
		driver.findElement(By.xpath("//tbody/tr/following::td/div/input[@id='q4']")).click();
		//following-sibling
		driver.findElement(By.xpath("//tbody/tr/following::td/div/input[@id='q4']/following-sibling::input")).click();
		//parent
		driver.findElement(By.xpath("//input[@id='q4']/parent::div/input[3]")).click();
		//preceding
		driver.findElement(By.xpath("//tr[9]/preceding::td[1]/input[@id='q5']")).click();
		//preceding-sibiling
		driver.findElement(By.xpath("//input[@name='checkbox6[]'][2]/preceding-sibling::input[@type='checkbox']")).click();
		driver.quit();

	}
}
