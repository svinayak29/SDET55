package usertest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Add_product_to_Wishlist_and_remove_product_from_Wishlist_Test {

	
	 public static WebDriver driver=null;
		public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
			
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData_OnlineAlphaa.properties");
			FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Alpha_TestCase1.xlsx");
			Workbook workbook = WorkbookFactory.create(fs);
			
			Sheet sheet = workbook.getSheet("wishlist");
			String value = sheet.getRow(0).getCell(1).getStringCellValue();
			Properties pObj = new Properties();
			pObj.load(fis);
			
			String browser = pObj.getProperty("browser");
			
			if(browser.equalsIgnoreCase("chrome")) {
				driver =new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.get(pObj.getProperty("url2"));
			Actions actions = new Actions(driver);
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(pObj.getProperty("usernameUser"));
			Thread.sleep(2000);
			
			
			//WebElement passwordText = driver.findElement(By.xpath("exampleInputPassword1"));
			WebElement passwordText	=driver.findElement(By.xpath("//label[text()='Password ']/..//input[@id='exampleInputPassword1']"));
			actions.moveToElement(passwordText).pause(1000).sendKeys(passwordText, pObj.getProperty("passwordUser")).perform();
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			
			WebElement searchText = driver.findElement(By.xpath("//input[@placeholder='Search here...']"));
			
			actions.sendKeys(searchText,value ).sendKeys(Keys.ENTER).perform();
			
			driver.findElement(By.xpath("//a[text()='Apple iPhone 6 (Silver, 16 GB)']/../../..//i[@class='icon fa fa-heart']")).click();
			driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
			
			driver.switchTo().alert().accept();
			driver.manage().window().minimize();
			driver.quit();
			
			

		}
}
