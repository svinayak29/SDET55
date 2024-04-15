package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class UpdateCategoryPage {

	@FindBy(xpath="//label[text()='Description']/..//textarea")
	private WebElement updateDescriptionText;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateOpt;
	
	public WebElement getUpdateOpt() {
		return updateOpt;
	}

	public UpdateCategoryPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}

	public WebElement getUpdateDescriptionText() {
		return updateDescriptionText;
	}
	WebDriverUtility wLib=new WebDriverUtility();
	public void updateCategory(WebDriver driver,String text) {
		wLib.sendKeysAction(driver, updateDescriptionText, Keys.CONTROL+"a");
		wLib.sendKeysAction(driver, updateDescriptionText, Keys.DELETE+"");
		wLib.sendKeysAction(driver,updateDescriptionText , text);
		updateOpt.click();
	}
	
}
