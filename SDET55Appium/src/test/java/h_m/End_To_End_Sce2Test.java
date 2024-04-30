package h_m;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class End_To_End_Sce2Test {

	@Test
	public void demo() throws MalformedURLException, InterruptedException {
	DesiredCapabilities dc =new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("automationName", "uiAutomator2");
	dc.setCapability("deviceName", "OnePlus9R");
	dc.setCapability("UDID", "72613c38");
	dc.setCapability("noReset", true);
	dc.setCapability("ignoreHiddenApiPolicyError", true);
	dc.setCapability("autoGrantPermission", true);
	
	URL u = new URL("http://localhost:4723");
	
	AndroidDriver driver = new AndroidDriver(u,dc);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.activateApp("com.hm.goe");
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Divided\"));"));	
	WebElement dividedEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Divided\");"));
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)dividedEle).getId(),"direction","left","percent",0.75));
	driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sport\")")).click();
	Thread.sleep(2000);
	WebElement bagEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Water-repellent hiking backpack\")"));
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)bagEle).getId(),"direction","left","percent",0.80));
	driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sun visor\")")).click();
	driver.findElement(AppiumBy.accessibilityId("Product Image")).click();
	Thread.sleep(2000);
	WebElement prodImg = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
	((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)prodImg).getId(),"percent",0.75));
	((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)prodImg).getId(),"percent",0.75));
	
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)prodImg).getId(),"direction","left","percent",0.75));
	Thread.sleep(2000);
	
	
	driver.findElement(AppiumBy.id("com.hm.goe:id/ivCloseCarousel")).click();
	Thread.sleep(2000);
	driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();
	driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
	WebElement prodName = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sun visor\")"));
	
	if(prodName.isDisplayed()) {
		System.out.println("Product is Added");
	}
	else {
		System.out.println("Not Added");
	}
	}
}
