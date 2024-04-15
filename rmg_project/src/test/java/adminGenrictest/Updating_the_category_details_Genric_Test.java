package adminGenrictest;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.rmg.onlineShopping.objectRepository.CreateCategoryPage;
import com.rmg.onlineShopping.objectRepository.LoginAdminPage;
import com.rmg.onlineShopping.objectRepository.UpdateCategoryPage;
//@Listeners(com.GenericUtilities.ListnerImpClass.class)
public class Updating_the_category_details_Genric_Test extends BaseClass{
	 @Test
	public  void Updating_the_category_details() throws IOException, InterruptedException {
	      String value=eUtil.readDataFromExcel("Category", 0, 1);
	      String textValue =eUtil.readDataFromExcel("Category", 1, 1);
	      String descriptionText =eUtil.readDataFromExcel("Category", 3, 1);
		
		CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
		CreateCategoryPage.editCategory(value, textValue);
		//Assert.fail();
		UpdateCategoryPage updateCategoryPage=new UpdateCategoryPage(driver);
		updateCategoryPage.updateCategory(driver, descriptionText);
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
