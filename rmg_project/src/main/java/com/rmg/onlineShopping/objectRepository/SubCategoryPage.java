package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;



public class SubCategoryPage {

	 WebDriverUtility wlib = new WebDriverUtility();
	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement subCategoryLink;
	
	@FindBy(name="category")
	private WebElement categoryDropDown;
	
	@FindBy(xpath="//input[@placeholder='Enter SubCategory Name']")
	private WebElement subCategorytext;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement subCategoryBtn;
	
	public SubCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubCategoryLink() {
		return subCategoryLink;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubCategorytext() {
		return subCategorytext;
	}

	public WebElement getSubCategoryBtn() {
		return subCategoryBtn;
	}
	
	public void createSubCategory(String text,String value) {
		subCategoryLink.click();
		wlib.byVisibleText(categoryDropDown, text);
		subCategorytext.sendKeys(value);
		subCategoryBtn.click();
		
	}
	
}
