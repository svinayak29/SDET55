package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class SwitchWindowPage {

	public SwitchWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	WebDriverUtility wLib=new WebDriverUtility();
	
	public void switchToWindows(WebDriver driver,String expWind) {
		wLib.switchToWindows(driver, expWind);
	}
}
