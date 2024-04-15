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
import org.testng.annotations.Parameters;

import com.rmg.onlineShopping.objectRepository.LoginAdminPage;

public class BaseClass {

	
	public DataBaseUtility dUtil = new DataBaseUtility();
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
		dUtil.connectToDB();
		Reporter.log("---DB connected--",true);
	}
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
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
		sdriver = driver;
		wUtil.maximiziWindow(driver);
		wUtil.implicitlyWait(driver);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToAppAdmin() throws IOException {
		
		String urlAdmin = fUtil.readDataFromPropertyFile("url1");
		String userNameAdmin = fUtil.readDataFromPropertyFile("usernameAdmin");
		String passwordAdmin = fUtil.readDataFromPropertyFile("passwordAdmin");
		
		driver.get(urlAdmin);
		LoginAdminPage logAdmin = new LoginAdminPage(driver);
		logAdmin.loginToAppAdmin(userNameAdmin, passwordAdmin);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutAsAdmin() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		wUtil.minimizeWindow(driver);
		wUtil.quitBrowser(driver);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException {
		dUtil.closeDB();
	}
	
	
	//Hi....Well Done
	
	
	
	
}
