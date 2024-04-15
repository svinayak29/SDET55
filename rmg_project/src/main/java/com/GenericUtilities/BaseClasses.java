package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.rmg.onlineShopping.objectRepository.HomePage;
import com.rmg.onlineShopping.objectRepository.LoginUserPage;
import com.rmg.onlineShopping.objectRepository.UserLogoutPage;

public class BaseClasses {

	
	public DataBaseUtility dUtil = new DataBaseUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	
	@BeforeSuite
	public void connectToDB() throws SQLException {
		dUtil.connectToDB();
		Reporter.log("---DB connected--",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		String browser = fUtil.readDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else {
			Reporter.log("---Invalid Browser---",true);
		}
		wUtil.maximiziWindow(driver);
		wUtil.implicitlyWait(driver);
		
	}
	
	@BeforeMethod
	public void loginAsUser() throws IOException {
		String urlUser = fUtil.readDataFromPropertyFile("url2");
		String userName = fUtil.readDataFromPropertyFile("usernameUser");
		String passwordUser = fUtil.readDataFromPropertyFile("passwordUser");
		
		driver.get(urlUser);

		HomePage HomePage=new HomePage(driver);
		HomePage.loginToHome();
		
		LoginUserPage loginUserPage=new LoginUserPage(driver);
		loginUserPage.loginAsUser(userName, driver, 1000, passwordUser);
	}
	
	@AfterMethod
	public void signOut() {
		UserLogoutPage userLogoutPage=new UserLogoutPage(driver);
		userLogoutPage.userLogout();
	}
	
	@AfterClass
	public void closeBrowser() {
		
		wUtil.minimizeWindow(driver);
		wUtil.quitBrowser(driver);
		}
	
	@AfterSuite
	public void closeDB() throws SQLException {
		dUtil.closeDB();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
