package com.control.statements;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.Utility;

public class BrowserTest extends Utility{

	WebDriver driver;

	void accessSite() throws IOException, InterruptedException {

		String browser = ReadProperty("browserType");  
		String url = ReadProperty("url");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		default:
			System.out.println("Invalid browser..!");
			break;
		}
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.quit();
	}




	public static void main(String[] args) throws IOException, InterruptedException {
		BrowserTest bt = new BrowserTest();
		bt.accessSite();

	}

}
