package com.java.oops;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;

public class Browserlaunching {
	WebDriver driver;

	@BeforeClass
	public void launchingBrowser() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("WebDriver.edge.driver", "./drivers/edgeedriver.exe");
		driver = new EdgeDriver(options);
		driver.get("https://www.amazon.in/");

		System.out.println("browser launched...");
	}

	@Test
	public void BrowserMethods() throws InterruptedException {
		driver.manage().window().maximize();
		System.out.println("broweser title:" +driver.getTitle());
		System.out.println("browser current url :"+driver.getCurrentUrl());
		driver.navigate().to("https://www.amazon.in/gp/browse.html?node=1953602031&ref_=nav_em_sbc_wfashion_clothing_0_2_11_2");
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.in/s?i=fashion&bbn=66527098031&rh=n%3A6648217031%2Cn%3A66007520031%2Cn%3A66527098031%2Cn%3A7459780031%2Cn%3A1953602031%2Cp_85%3A10440599031%2Cp_89%3AAND%7CAurelia%7CBIBA%7CClovia%7CJanasya%7CMax%7CMiss+Chase%7CONLY%7CPepe+Jeans%7CPuma%7CSoch%7CSpykar%7CThe+Souled+Store%7CTommy+Hilfiger%7CU.S.+POLO+ASSN.%7CUnited+Colors+of+Benetton%7CVERO+MODA%7CVan+Heusen%7CW+for+Woman%7Cglobal+desi&s=relevanceblender&dc&hidden-keywords=-_-men-man-girl-boy-shoe-night-nighty-shape-tight-legging-shapewear-running-SKDINDIEST8125_Blue-INDIGO19025_Indigo&ds=v1%3AgQk8EY%2BOvqDwdB4ThyPMUnLptWykX6NM7iQFBpFes9Q&pf_rd_i=1953602031&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_p=32859b90-a412-4745-a2c1-924325732caa&pf_rd_r=7QAGQA0B8VN86QP6NZ8X&pf_rd_s=merchandised-search-1&qid=1678871039&rnid=3837712031&ref=sr_nr_p_89_38");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		Thread.sleep(3000);
		search.sendKeys("watch");
		Thread.sleep(3000);
		WebElement find = driver.findElement(By.id("nav-search-submit-button"));
		Thread.sleep(3000);
		find.click();
		System.out.println("browser methodes performing...");

	}



	@AfterClass
	public void ClosingBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		System.out.println("browser closed");
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
