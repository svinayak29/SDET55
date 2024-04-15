package genricClass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClasses;
import com.rmg.onlineShopping.objectRepository.AddToCartPage;
import com.rmg.onlineShopping.objectRepository.HomePage;
import com.rmg.onlineShopping.objectRepository.SearchResultPage;
import com.rmg.onlineShopping.objectRepository.SwitchWindowPage;

public class DemoTest extends BaseClasses {

	
	 @Test
		public  void Add_product_to_Wishlist() throws IOException, InterruptedException {
			
		  	String value =eUtil.readDataFromExcel("wishlist", 0, 1);
		
			HomePage HomePage=new HomePage(driver);
			
			HomePage.serachProdInHome(driver, value);
			
			SearchResultPage searchResultPage=new SearchResultPage(driver);
			searchResultPage.addProdToWishlist();
			
			
			wUtil.alertPopupAccept(driver);
			
			
			


		}
	 
	 
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
