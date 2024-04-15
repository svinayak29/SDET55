package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CreateCategoryPage {

	
	@FindBy(xpath="//a[text()=' Create Category ']")
	private WebElement CreateCategorylink;
	
	@FindBy(xpath="//input[@name='category']")
	private WebElement categoryText;
	
	@FindBy(name="description")
	private WebElement descriptionText;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement categoryCreatebtn;
	@FindBy(xpath="//select[@name='DataTables_Table_0_length']")
	private WebElement createShowOpt;
	
	@FindBy(xpath="//label[text()='Search: ']//input[@type='text']")
	private WebElement createSearchText;
	
	@FindBy(xpath="//tr[@class='odd'][1]//i[@class='icon-edit']")
	private WebElement createEdit;
	
	@FindBy(xpath="//tr[@class='odd'][1]//i[@class='icon-remove-sign']")
	private WebElement removeSign;
	
	public WebElement getRemoveSign() {
		return removeSign;
	}

	public WebElement getCreateShowOpt() {
		return createShowOpt;
	}

	public WebElement getCreateSearchText() {
		return createSearchText;
	}

	public WebElement getCreateEdit() {
		return createEdit;
	}

	public CreateCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCategorylink() {
		return CreateCategorylink;
	}

	public WebElement getCategoryText() {
		return categoryText;
	}

	public WebElement getDescriptionText() {
		return descriptionText;
	}

	public WebElement getCategoryCreatebtn() {
		return categoryCreatebtn;
	}
	
	public void deleteCategory(String value,String value1) {
		CreateCategorylink.click();
		createShowOpt.sendKeys(value);
		createSearchText.sendKeys(value1);
		removeSign.click();
	}
	
	public void editCategory(String value,String value1) {
		CreateCategorylink.click();
		createShowOpt.sendKeys(value);
		createSearchText.sendKeys(value1);
		createEdit.click();
	}
	
	public void createCategory(String value1,String value2) {
		CreateCategorylink.click();
		categoryText.sendKeys(value1);
		descriptionText.sendKeys(value2);
		categoryCreatebtn.click();
	}
	
}
