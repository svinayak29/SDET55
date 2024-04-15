package com.rmg.onlineShopping.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addtocart;
	
	@FindBy(xpath="//i[@class='icon fa fa-shopping-cart']")
	private WebElement cartIcon;
	
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proccedToCheckout;
	
	@FindBy(xpath="//input[@value='COD']")
	private WebElement cod;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitOpt;
	
	@FindBy(xpath="//td[text()='2024-03-29 02:04:55  ']/..//a[contains(text(),'Track')]")
	private WebElement itemNo;
	
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getProccedToCheckout() {
		return proccedToCheckout;
	}

	public WebElement getCod() {
		return cod;
	}

	public WebElement getSubmitOpt() {
		return submitOpt;
	}

	public WebElement getItemNo() {
		return itemNo;
	}
	
	public void addingProdIntoCart() {
		addtocart.click();
		cartIcon.click();
		proccedToCheckout.click();
		cod.click();
		submitOpt.click();
		itemNo.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}






















