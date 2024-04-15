package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.rmg.onlineShopping.objectRepository.LoginAdminPage;

public class DataProviderTest {

	@Test(dataProviderClass=DataStore.class,dataProvider = "data")
	public void getData(String username,String pasword) {
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
	LoginAdminPage LoginAdminPage=new LoginAdminPage(driver);
	LoginAdminPage.loginToAppAdmin(username, pasword);
	
	}
}
