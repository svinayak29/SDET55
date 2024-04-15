package admintest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.rmg.onlineShopping.objectRepository.CreateCategoryPage;
import com.rmg.onlineShopping.objectRepository.LoginAdminPage;

public class Verify_the_product_is_displayed_in_the_user_module_Test {

	
	public static WebDriver driver = null;
	@Test
	public void  VerifyTheProduct() throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData_OnlineAlphaa.properties");
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Alpha_TestCase1.xlsx");
		Workbook workbook = WorkbookFactory.create(fs);
		Sheet sheet = workbook.getSheet("Insert_Product");
		String value1 = sheet.getRow(0).getCell(1).getStringCellValue();
		String value2 = sheet.getRow(1).getCell(1).getStringCellValue();
		String value3 = sheet.getRow(3).getCell(1).getStringCellValue();
		String value4 = sheet.getRow(2).getCell(1).getStringCellValue();
		String value5 = sheet.getRow(4).getCell(1).getStringCellValue();
		String value6 = sheet.getRow(5).getCell(1).getStringCellValue();
		String value7 = sheet.getRow(6).getCell(1).getStringCellValue();
		String value8 = sheet.getRow(7).getCell(1).getStringCellValue();
		String value9 = sheet.getRow(8).getCell(1).getStringCellValue();
		String value10 = sheet.getRow(9).getCell(1).getStringCellValue();
		String value11 = sheet.getRow(10).getCell(1).getStringCellValue();
		String value12 = sheet.getRow(11).getCell(1).getStringCellValue();
		
		
		
		
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String browser = pObj.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pObj.getProperty("url1"));
		//driver.findElement(By.id("inputEmail")).sendKeys(pObj.getProperty("usernameAdmin"));
		LoginAdminPage LoginAdminPage=new LoginAdminPage(driver);

		LoginAdminPage.getUsertextAdmin().sendKeys(pObj.getProperty("usernameAdmin"));
		Thread.sleep(2000);
		LoginAdminPage.getPasswordtextAdmin().sendKeys(pObj.getProperty("passwordAdmin"));
		Thread.sleep(2000);
		LoginAdminPage.getLogInBtn().click();
		
		CreateCategoryPage CreateCategoryPage=new CreateCategoryPage(driver);
		CreateCategoryPage.getCreateCategorylink().click();
		//driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		
		driver.findElement(By.xpath("//input[@name='category']")).sendKeys(value1);
		driver.findElement(By.name("description")).sendKeys(value2);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
		
		WebElement category = driver.findElement(By.name("category"));
		Select select_Cat = new Select(category);
		select_Cat.selectByVisibleText(value3);
		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(value4);
		
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs("Admin| Insert Product"));
		
		/*WebElement category_Insert = driver.findElement(By.xpath("//label[text()='Category']/..//select[@class='span8 tip']"));
		 Select select_CatP = new Select(category_Insert);
		 select_CatP.selectByVisibleText(value4);*/
		
		WebElement Pro_Cat = driver.findElement(By.xpath("//select[@name='category']"));
		Select select = new Select(Pro_Cat);
		select.selectByVisibleText(value3);
		 
		WebElement subCategory = driver.findElement(By.xpath("//select[@id='subcategory']"));
		Select select_SubCat = new Select(subCategory);
		select_SubCat.selectByVisibleText(value5);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Product Name']")).sendKeys(value6);
		driver.findElement(By.xpath("//input[@placeholder='Enter Product Comapny Name']")).sendKeys(value7);
		
		
		driver.findElement(By.xpath("//label[text()='Product Price Before Discount']/..//input[@placeholder='Enter Product Price']")).sendKeys(value8);
		driver.findElement(By.xpath("//label[text()='Product Price After Discount(Selling Price)']/..//input[@placeholder='Enter Product Price']")).sendKeys(value9);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Product Description']")).sendKeys(value10);
		driver.findElement(By.xpath("//input[@placeholder='Enter Product Shipping Charge']")).sendKeys(value11);
		WebElement product_Avl = driver.findElement(By.xpath("//select[@id='productAvailability']"));
		
		Select selects = new Select(product_Avl);
		selects.selectByVisibleText(value12);
		driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys("C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic1.jpg");
		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic2.jpg");
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\Users\\siddhi\\OneDrive\\Desktop\\BatPic3.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Insert']")).click();
		
		driver.get(pObj.getProperty("url2"));
		
		WebElement searchText = driver.findElement(By.xpath("//input[@placeholder='Search here...']"));
		  Actions actions = new Actions(driver);
		  actions.sendKeys(searchText,value6 ).sendKeys(Keys.ENTER).perform();
		  Thread.sleep(3000);
		  driver.manage().window().minimize();
		  driver.quit();
		  
		  
		
		
		
	}	
		

	}


