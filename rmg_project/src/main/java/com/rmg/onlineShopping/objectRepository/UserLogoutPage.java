package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogoutPage {

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutUser;
	
	public UserLogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutUser() {
		return logoutUser;
	}
	
	public void userLogout() {
		logoutUser.click();
	}
	
}
