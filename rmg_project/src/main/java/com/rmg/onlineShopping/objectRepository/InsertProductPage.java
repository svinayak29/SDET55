package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class InsertProductPage {

	@FindBy(xpath="//a[text()='Insert Product ']")
	private WebElement insertProductLink;
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement proCatDropDown;
	
	@FindBy(xpath="//select[@id='subcategory']")
	private WebElement subCatDropDown;
	
	@FindBy(xpath="//input[@placeholder='Enter Product Name']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@placeholder='Enter Product Comapny Name']")
	private WebElement companyName;
	
	@FindBy(xpath="//label[text()='Product Price Before Discount']/..//input[@placeholder='Enter Product Price']")
	private WebElement proPriceBefore;
	
	@FindBy(xpath="//label[text()='Product Price After Discount(Selling Price)']/..//input[@placeholder='Enter Product Price']")
	private WebElement proPriceAfter;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Product Description']")
	private WebElement productDiscriptionText;
	
	@FindBy(xpath="//input[@placeholder='Enter Product Shipping Charge']")
	private WebElement productShipping;
	
	@FindBy(xpath="//select[@id='productAvailability']")
	private WebElement productAval;
	
	@FindBy(xpath="//input[@id='productimage1']")
	private WebElement productImg1;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement productImg2;
	
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement productImg3;
	
	@FindBy(xpath="//button[text()='Insert']")
	private WebElement insertBtn;
	
	public InsertProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}

	public WebElement getInsertProductLink() {
		return insertProductLink;
	}

	public WebElement getProCatDropDown() {
		return proCatDropDown;
	}

	public WebElement getSubCatDropDown() {
		return subCatDropDown;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getProPriceBefore() {
		return proPriceBefore;
	}

	public WebElement getProPriceAfter() {
		return proPriceAfter;
	}

	public WebElement getProductDiscriptionText() {
		return productDiscriptionText;
	}

	public WebElement getProductShipping() {
		return productShipping;
	}

	public WebElement getProductAval() {
		return productAval;
	}

	public WebElement getProductImg1() {
		return productImg1;
	}

	public WebElement getProductImg2() {
		return productImg2;
	}

	public WebElement getProductImg3() {
		return productImg3;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}
	WebDriverUtility wLib=new WebDriverUtility();
	public void insertProductIntoAlphaa(WebDriver driver,int sec,String title,String categoryValue,String subCatvalue,String nameOfProduct,String nameofCompany,String price,
			String priceAfter,String discText,String shipCharge,String avlOfProd,String img1Add,String img2Add,String img3Add) {
		insertProductLink.click();
		wLib.waitUntilTitleIsVisible(driver, sec, title);
		wLib.byVisibleText(proCatDropDown, categoryValue);
		wLib.byVisibleText(subCatDropDown, subCatvalue);
		productName.sendKeys(nameOfProduct);
		companyName.sendKeys(nameofCompany);
		proPriceBefore.sendKeys(price);
		proPriceAfter.sendKeys(priceAfter);
		productDiscriptionText.sendKeys(discText);
		productShipping.sendKeys(shipCharge);
		wLib.byVisibleText(productAval, avlOfProd);
		productImg1.sendKeys(img1Add);
		productImg2.sendKeys(img2Add);
		productImg3.sendKeys(img3Add);
		insertBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
