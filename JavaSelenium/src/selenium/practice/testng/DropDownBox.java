package selenium.practice.testng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownBox {

	WebDriver driver;

	@Test
	public void advLocatorsTest() throws InterruptedException {
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		try {
			driver.findElement(By.linkText("Sample Forms")).click();
			Thread.sleep(2000);
			WebElement dropBox = driver.findElement(By.cssSelector("select#q3"));
			Select select = new Select(dropBox);
			
			//1. How to select nth item from a dropwon list in Selenium?
			select.selectByIndex(2);
			List<WebElement> options = select.getOptions();
			System.out.println("No of Drop Down Box options are : " + options.size());
			
			//2. How to get all item names from the dropdown in Selenium?
			System.out.println("The Drop Down Box Options are : ");
			for(int i=0; i<options.size();i++) {
				System.out.println(options.get(i).getText());
			}
			Thread.sleep(1000);
			//printing through Lambda Expression
			System.out.println("Printing with Lambda Expression : ");
			options.forEach(opts->System.out.println(opts.getText()));

			WebElement usStates = driver.findElement(By.cssSelector("select[id='q8']"));
			Select st = new Select(usStates);
			List<WebElement> statesCode = st.getOptions();
			int n = statesCode.size();

			//3. How to get the count of dropdown items in Selenium?
			System.out.println("No of Pre Defined Fields-U.S States are :" + n);

			//4. How to select last but one value from the dropdown list?
			for(int i=0; i<n; i++) {
				if(i==n-2) {
					System.out.println(statesCode.get(i).getText());
					statesCode.get(i).click();
					Thread.sleep(1000);
				}
			}
			
			WebElement country = driver.findElement(By.cssSelector("*#q9"));
			Select selct = new Select(country);
			
			//5. How to get the default value from a dropdown in Selenium?
			System.out.println(selct.getFirstSelectedOption().getText());
			
			//6. What are the different methods available in select class for selecting the dropdown items?
			selct.selectByIndex(38);
			Thread.sleep(1000);
			//7. How to use selectByValue method in Selenium?
			selct.selectByValue("Egypt");
			Thread.sleep(1000);
			selct.selectByVisibleText("Germany");
			Thread.sleep(1000);
			List<WebElement> countries = selct.getOptions();
			System.out.println("The No of Pre Defined Field Countries are : " + countries.size());
			System.out.println(selct.getFirstSelectedOption().getText());
			
			//8. How to sort the dropdown items in Selenium?
			WebElement name = driver.findElement(By.cssSelector("*[name='q11_title']"));
			List<String> tagList = new ArrayList<String>();
			Select se = new Select(name);
			List<WebElement> tags = se.getOptions();
			for(WebElement tag:tags) {
				tagList.add(tag.getText());
			}
			System.out.println("Before Sorting : "+ tagList);
			List<String> sortedTagList = new ArrayList<String>();
			sortedTagList = tagList;
			Collections.sort(sortedTagList);
			System.out.println("After Sorting : "+ sortedTagList);

			//9. How to compare 2 dropdown lists in Selenium?
			//10. When to use isMultiple method for a dropdown in Selenium?
			
		}
		catch(StaleElementReferenceException e) {
			System.out.println(e.getMessage());
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
