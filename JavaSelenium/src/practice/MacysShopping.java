                                                                                                                                                                                                                                                                                                     package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MacysShopping {
	WebDriver driver;
	
	public void launchSite() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user")).sendKeys("padma");
		driver.findElement(By.id("pass")).sendKeys("august18");
		Thread.sleep(3000);
		driver.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		MacysShopping ms =new MacysShopping();
		ms.launchSite();
}

}
