package practice;

import org.testng.annotations.Test;

import io.netty.util.internal.SystemPropertyUtil;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DropdownListbox {
	WebDriver driver;
  @Test
  public void dropdownList() {
	 
	  try {
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sample Forms")).click();
		WebElement canadianProvinces= driver.findElement(By.id("q10"));
		Select provincesList = new Select(canadianProvinces);
		List<WebElement> listItems = provincesList.getOptions(); 
		System.out.println("Number Of Canadian Provinces :"+listItems.size());
		System.out.println("Last But ONE Canadian Provinces: "+listItems.get(listItems.size()-2).getText());
		for (int i = 0; i <listItems.size(); i++) {
			System.out.println("Names From Dropdown:"+listItems.get(i).getText());
		}
		
		ArrayList<String> sortedList = new ArrayList<String>();
		for (int i = 0; i <listItems.size(); i++) {
			//System.out.println("Names After sort:"+listItems.get(i).getText());
			sortedList.add(listItems.get(i).getText());
		}
		Collections.sort(sortedList);
		for (int i = 0; i <sortedList.size(); i++) {
			System.out.println("Sorted Canadian Provinces list :"+sortedList.get(i));
		}
		
		System.out.println("Default Selected Value:"+canadianProvinces.getText());
		provincesList.selectByIndex(5);
		Thread.sleep(2000);
		provincesList.selectByValue("Ontario");
		Thread.sleep(2000);
		provincesList.selectByVisibleText("--Canadian Territories--");	
		System.out.println("Is multiple dropdown: "+provincesList.isMultiple());
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
  }
  
  @BeforeClass
  public void launchTheBrowser() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	  driver=new ChromeDriver(options);
	  driver.get("https://www.mycontactform.com/");	  		
  }

  @AfterClass
  public void closeTheBrowser() throws InterruptedException {
	  Thread.sleep(0);
	  driver.quit();
  }

}
