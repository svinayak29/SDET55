package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class LoginUserPage {

	@FindBy(id="exampleInputEmail1")
	private WebElement userNameText;
	
	@FindBy(xpath="//label[text()='Password ']/..//input[@id='exampleInputPassword1']")
	private WebElement userPasswordText;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement userLoginBtn;
	
	public LoginUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameText() {
		return userNameText;
	}

	public WebElement getUserPasswordText() {
		return userPasswordText;
	}

	public WebElement getUserLoginBtn() {
		return userLoginBtn;
	}
	WebDriverUtility wLib=new WebDriverUtility();
	public void loginAsUser(String userText,WebDriver driver,int duration,String text) {
		userNameText.sendKeys(userText);
		wLib.moveToElement(driver, userPasswordText, duration, text);
		userLoginBtn.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
