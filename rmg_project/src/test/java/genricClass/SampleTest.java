package genricClass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.rmg.onlineShopping.objectRepository.CreateCategoryPage;
import com.rmg.onlineShopping.objectRepository.HomePage;
import com.rmg.onlineShopping.objectRepository.InsertProductPage;
import com.rmg.onlineShopping.objectRepository.SubCategoryPage;
import com.rmg.onlineShopping.objectRepository.UpdateCategoryPage;

public class SampleTest extends BaseClass {

	
	@Test
	public  void Delete_Category() throws IOException, InterruptedException {
		
	      String value=eUtil.readDataFromExcel("Category", 0, 1);
	      String textValue =eUtil.readDataFromExcel("Category", 1, 1);
		
		
		CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
		
		CreateCategoryPage.deleteCategory(value, textValue);
		Thread.sleep(2000);
		wUtil.alertPopupAccept(driver);
}
	
	 @Test
		public  void Updating_the_category_details() throws IOException, InterruptedException {
		      String value=eUtil.readDataFromExcel("Category", 0, 1);
		      String textValue =eUtil.readDataFromExcel("Category", 1, 1);
		      String descriptionText =eUtil.readDataFromExcel("Category", 3, 1);
			
			CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
			CreateCategoryPage.editCategory(value, textValue);
			
			UpdateCategoryPage updateCategoryPage=new UpdateCategoryPage(driver);
			updateCategoryPage.updateCategory(driver, descriptionText);
			
			

}
	 @Test
		public  void  Verify_the_product() throws IOException, InterruptedException {
			
	     
	      String value1=eUtil.readDataFromExcel("Insert_Product", 0, 1);
	      String value2 =eUtil.readDataFromExcel("Insert_Product", 1, 1);
	      String value3 = eUtil.readDataFromExcel("Insert_Product", 3, 1);
	      String value4 = eUtil.readDataFromExcel("Insert_Product", 2, 1);
	      String value5 = eUtil.readDataFromExcel("Insert_Product", 4, 1);
	      String value6 = eUtil.readDataFromExcel("Insert_Product", 5, 1);
	      String value7 = eUtil.readDataFromExcel("Insert_Product", 6, 1);
	      String value8 = eUtil.readDataFromExcel("Insert_Product", 7, 1);
	      String value9 = eUtil.readDataFromExcel("Insert_Product", 8, 1);
	      String value10 = eUtil.readDataFromExcel("Insert_Product", 9, 1);
	      String value11 = eUtil.readDataFromExcel("Insert_Product", 10, 1);
	      String value12 = eUtil.readDataFromExcel("Insert_Product", 11, 1);
			
				
	      
			
			CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
			
			CreateCategoryPage.createCategory(value1, value2);
			
			SubCategoryPage SubCategoryPage=new SubCategoryPage(driver);
			
			SubCategoryPage.createSubCategory(value3, value4);
			
			
			InsertProductPage InsertProductPage=new InsertProductPage(driver);
			String imgAdd1="C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic1.jpg";
			String imgAdd2="C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic2.jpg";
			String imgAdd3="C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic3.jpg";
			InsertProductPage.insertProductIntoAlphaa(driver, 20, "Admin| Insert Product", value3, value5, value6, value7, value8, value9, value10, value11, value12, imgAdd1, imgAdd2, imgAdd3);
			
			
			driver.get(fUtil.readDataFromPropertyFile("url2"));
			HomePage HomePage=new HomePage(driver);
			
			HomePage.serachProdInHome(driver, value6);
			
			
			  
			 


	 }

}
