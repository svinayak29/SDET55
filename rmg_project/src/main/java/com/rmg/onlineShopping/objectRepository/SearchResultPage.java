package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	@FindBy(xpath="//a[text()='Apple iPhone 6 (Silver, 16 GB)']/../../..//i[@class='icon fa fa-heart']")
	private WebElement productResult;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private WebElement wishListIcon;
	
	
	
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getProductResult() {
		return productResult;
	}

	public WebElement getWishListIcon() {
		return wishListIcon;
	}
	
	public void addProdToWishlist() {
		productResult.click();
		wishListIcon.click();
	}
	
	public void clickOnProd() {
		productResult.click();
	}
	
	
}
