package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginAdminPage {
	
	@FindBy(id="inputEmail")
	private WebElement usertextAdmin;
	
	@FindBy(id="inputPassword")
	private WebElement passwordtextAdmin;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement logInBtn;
	
	public LoginAdminPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsertextAdmin() {
		return usertextAdmin;
	}

	public WebElement getPasswordtextAdmin() {
		return passwordtextAdmin;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}
	
	public void loginToAppAdmin(String username,String pasword) {
		usertextAdmin.sendKeys(username);
		passwordtextAdmin.sendKeys(pasword);
		logInBtn.click();
	}
	
	
	
	
}
