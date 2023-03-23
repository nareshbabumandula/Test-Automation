package selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebsiteBasics {
	
	WebDriver driver;
	
	void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		System.out.println("Opened Chrome Browser.");
	}
	
	void accessingSite() {
		driver.get("https://www.amazon.in/");
		System.out.println("Accessed Amazon Site.");
	}
	
	void searchProduct(String name) {
		System.out.println("Searched 'TV' Product in the search bar." + name);
	}
	
	void selectProduct() {
		System.out.println("Selected a Model/Company.");
	}
	
	boolean closeBrowser() throws InterruptedException {
		System.out.println("closed Chrome Browser");
		Thread.sleep(3000);
		driver.quit();
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		SeleniumWebsiteBasics web = new SeleniumWebsiteBasics();
		web.openBrowser();
		web.accessingSite();
		web.searchProduct("TV");
		web.selectProduct();
		System.out.println(web.closeBrowser());
	}
}
