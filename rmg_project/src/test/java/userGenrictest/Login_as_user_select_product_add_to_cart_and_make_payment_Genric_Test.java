package userGenrictest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

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
import com.rmg.onlineShopping.objectRepository.AddToCartPage;
import com.rmg.onlineShopping.objectRepository.HomePage;
import com.rmg.onlineShopping.objectRepository.LoginUserPage;
import com.rmg.onlineShopping.objectRepository.SearchResultPage;
import com.rmg.onlineShopping.objectRepository.SwitchWindowPage;
import com.rmg.onlineShopping.objectRepository.UserLogoutPage;

public class Login_as_user_select_product_add_to_cart_and_make_payment_Genric_Test extends BaseClasses {
	
	@Test
	public  void Login_as_user_select_product() throws IOException, InterruptedException {
		
		
	      String value =eUtil.readDataFromExcel("Add_To_Cart", 0, 1);
		
		HomePage HomePage=new HomePage(driver);
		
		HomePage.serachProdInHome(driver,value );
	    SearchResultPage SearchResultPage=new SearchResultPage(driver);
	    SearchResultPage.clickOnProd();
	    
	    AddToCartPage addToCartPage=new AddToCartPage(driver);
	    addToCartPage.addingProdIntoCart();
	    
		
	    SwitchWindowPage switchWindowPage=new SwitchWindowPage(driver);
	    switchWindowPage.switchToWindows(driver, "Order Tracking Details");
		
	    switchWindowPage.switchToWindows(driver,"Order History" );
		
		
		
		
		
		
			
		

	}

}
