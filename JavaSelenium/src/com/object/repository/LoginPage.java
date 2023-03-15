package com.object.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "user")
	private WebElement username;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="btnSubmit")
	private WebElement login;

	public void login(String strUsername, String strPassword) {
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		login.click();
	}
	
	

}
