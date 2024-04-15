package admintest;

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

public class Updating_the_category_details_Test {

	
	public static WebDriver driver = null;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData_OnlineAlphaa.properties");
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Alpha_TestCase1.xlsx");
		Workbook workbook = WorkbookFactory.create(fs);
		Sheet sheet = workbook.getSheet("Category");
		String value = sheet.getRow(0).getCell(1).getStringCellValue();
		String textValue = sheet.getRow(1).getCell(1).getStringCellValue();
		String descriptionText = sheet.getRow(3).getCell(1).getStringCellValue();
		
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String browser = pObj.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(pObj.getProperty("url1"));
		driver.findElement(By.id("inputEmail")).sendKeys(pObj.getProperty("usernameAdmin"));
		Thread.sleep(2000);
		driver.findElement(By.id("inputPassword")).sendKeys(pObj.getProperty("passwordAdmin"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(value);
		
		WebElement search = driver.findElement(By.xpath("//label[text()='Search: ']//input[@type='text']"));
		search.sendKeys(textValue);
		
		driver.findElement(By.xpath("//tr[@class='odd'][1]//i[@class='icon-edit']")).click();
		
		WebElement textArea = driver.findElement(By.xpath("//label[text()='Description']/..//textarea"));
		
		Actions actions = new Actions(driver);
		actions.sendKeys(textArea, Keys.CONTROL+"a").sendKeys(textArea, Keys.DELETE).sendKeys(textArea, descriptionText).perform();
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		driver.manage().window().minimize();
		driver.quit();
		
		
		
		
		
		

	}

}
