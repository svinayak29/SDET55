package userGenrictest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClasses;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.rmg.onlineShopping.objectRepository.HomePage;
import com.rmg.onlineShopping.objectRepository.LoginUserPage;
import com.rmg.onlineShopping.objectRepository.SearchResultPage;

public class Add_product_to_Wishlist_and_remove_product_from_Wishlist_Genric_Test extends BaseClasses {
	 
	 @Test
	public  void Add_product_to_Wishlist() throws IOException, InterruptedException {
		
	  	String value =eUtil.readDataFromExcel("wishlist", 0, 1);
	
		HomePage HomePage=new HomePage(driver);
		
		HomePage.serachProdInHome(driver, value);
		
		SearchResultPage searchResultPage=new SearchResultPage(driver);
		searchResultPage.addProdToWishlist();
		
		
		wUtil.alertPopupAccept(driver);
		
		
		


	}

}
