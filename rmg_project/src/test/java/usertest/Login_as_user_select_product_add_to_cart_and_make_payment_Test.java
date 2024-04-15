package usertest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

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

public class Login_as_user_select_product_add_to_cart_and_make_payment_Test {

	
	public static WebDriver driver=null;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData_OnlineAlphaa.properties");
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Alpha_TestCase1.xlsx");
		Workbook workbook = WorkbookFactory.create(fs);
		
		Sheet sheet = workbook.getSheet("Add_To_Cart");
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
		
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//i[@class='icon fa fa-shopping-cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		
		driver.findElement(By.xpath("//input[@value='COD']")).click();
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver.findElement(By.xpath("//td[text()='2024-03-29 02:04:55  ']/..//a[contains(text(),'Track')]")).click();
		String widid = driver.getWindowHandle();
		
		Set<String> wids = driver.getWindowHandles();
		for(String wid : wids) {
			String title = driver.switchTo().window(wid).getTitle();
			if(title.equals("Order Tracking Details")){
				driver.close();
			}
			
		}
		
		 driver.switchTo().window(widid);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.manage().window().minimize();
		driver.quit();
		
			
		
		
		
		
		

	}
}
