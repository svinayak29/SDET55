package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void maximiziWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void waitForPageLoad(WebDriver driver,int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public WebDriverWait webDriverwait(WebDriver driver,int sec) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	public void waitUntilEleToBeVisible(WebDriver driver,int sec,WebElement Element) {
		webDriverwait(driver, sec).until(ExpectedConditions.visibilityOf( Element));
	}
	
	public void waitUntilTitleIsVisible(WebDriver driver,int sec,String Element) {
		webDriverwait(driver, sec).until(ExpectedConditions.titleIs(Element));
	}
	
	public void elementToBeClickable(WebDriver driver,int sec,WebElement Element) {
		webDriverwait(driver, sec).until(ExpectedConditions.elementToBeClickable(Element));
	}
	public Actions performActions(WebDriver driver) {
		Actions actions = new Actions(driver);
		return actions;
	}
	
	public void clickAction(WebDriver driver,WebElement Element) {
		performActions(driver).click(Element).perform();
	}
	
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement target,int duration) {
		performActions(driver).dragAndDrop(source, target).pause(duration).perform();;
	}
	
	public void sendKeysAction(WebDriver driver,WebElement Element,String keys ) {
		performActions(driver).sendKeys(Element, keys ).perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement Element) {
	performActions(driver).doubleClick(Element).perform();
	}
	public void contextClickAction(WebDriver driver,WebElement Element) {
		performActions(driver).contextClick(Element).perform();
	}
	public void enterKeyPress(WebDriver driver) {
		performActions(driver).sendKeys(Keys.ENTER).perform();
	}
	public void enterKeyElement(WebDriver driver,WebElement Element) {
		performActions(driver).sendKeys(Element, Keys.ENTER).perform();
	}
	
	public void clickAndHoldAction(WebDriver driver,WebElement Element) {
		performActions(driver).clickAndHold(Element).perform();
	}
	
	public void moveToElement(WebDriver driver,WebElement Element,int duration,String text) {
		performActions(driver).moveToElement(Element).pause(duration).sendKeys(Element, text).perform();
	}
	
	public Select HandleDropDown(WebElement Element) {
		Select select = new Select(Element);
		return select;
	}
	public void byVisibleText(WebElement Element,String text) {
		HandleDropDown(Element).selectByVisibleText(text);
	}
	
	public void byValue(WebElement Element,String value) {
		HandleDropDown(Element).selectByValue(value);
	}
	
	public void byIndex(WebElement Element,int index) {
		HandleDropDown(Element).selectByIndex(index);
	}
	
	public void switchToWindows(WebDriver driver,String expWind) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String win = it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			if(currentTitle.contains(expWind)) {
				break;
			}
		}
		
		
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	
	public void switchToFrame(WebDriver driver,WebElement Element) {
		driver.switchTo().frame(Element);
	}
	
	public String getScreenShotOfWebPage(WebDriver driver,String screenShotName) throws IOException {
		JavaUtility jUtils = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot/"+screenShotName+" "+jUtils.getSystemDateinFormat()+".png";
		File dest = new File(path);
		String srcPath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return srcPath;
	}
	
	public void scrollBarAction(WebDriver driver) {
		
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,800)", "");
	
	
	}
	
	public void scrollActionTillEle(WebDriver driver,WebElement Element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int x = Element.getLocation().getX();
		int y = Element.getLocation().getY();
		
		jse.executeScript("window.scrollBy("+x+","+y+")",Element );
		}
	
	
	public void scrollTillBottom(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void clickOnEle(WebDriver driver,WebElement Element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click",Element);
		}
	
	
	public void sendKeys(WebDriver driver,WebElement Element,String text) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1]",Element,text);
		}
	
	public void scrollTillEleToBeVisible(WebDriver driver,WebElement Element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()",Element);
	}
	
	
	public void alertPopupAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	
}
