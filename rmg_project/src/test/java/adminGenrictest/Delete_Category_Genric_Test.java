package adminGenrictest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
@Listeners(com.GenericUtilities.ListnerImpClass.class)
public class Delete_Category_Genric_Test extends BaseClass {
	
	 @Test(retryAnalyzer =com.GenericUtilities.RetryImpClass.class)
	public  void Delete_Category() throws IOException, InterruptedException {
		
	      String value=eUtil.readDataFromExcel("Category", 0, 1);
	      String textValue =eUtil.readDataFromExcel("Category", 1, 1);
		Assert.fail();
		
		CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
		
		CreateCategoryPage.deleteCategory(value, textValue);
		Thread.sleep(2000);
		wUtil.alertPopupAccept(driver);
		
		
		


	}

}
