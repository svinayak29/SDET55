package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

 public class HomePage {

	@FindBy(xpath="//input[@placeholder='Search here...']")
	private WebElement searchText;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginHome;
	public WebElement getLoginHome() {
		return loginHome;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchText() {
		return searchText;
	}
	
	public void loginToHome() {
		loginHome.click();
	}
	WebDriverUtility wLib=new WebDriverUtility();
	public void serachProdInHome(WebDriver driver,String proName) {
		wLib.sendKeysAction(driver, searchText, proName);
		wLib.enterKeyElement(driver, searchText);
		//wLib.minimizeWindow(driver);
	}
	
	
	
}
