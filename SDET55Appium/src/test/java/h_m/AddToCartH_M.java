package h_m;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AddToCartH_M {

	@Test
	public void addToCartPro() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
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
		driver.findElement(AppiumBy.id("com.hm.goe:id/action_search_button")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"product \"]")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)")).click();
		driver.findElement(AppiumBy.id("com.hm.goe:id/carouselImage")).click();
		
		WebElement ele = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"percent",0.75));	
		
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"percent",0.75));
		
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"direction","left","percent",0.75));
		Thread.sleep(2000);
		WebElement proImage = driver.findElement(AppiumBy.accessibilityId("Product Image"));
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)proImage).getId(),"direction","right","percent",0.75));
		driver.findElement(AppiumBy.id("com.hm.goe:id/ivCloseCarousel")).click();
		driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();
		Thread.sleep(2000);
		
		WebElement sizeEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)"));
		Assert.assertTrue(sizeEle.isDisplayed(), "Size is not available");
		sizeEle.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
		
		driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2\");)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"2\"));")).click();
		
		Thread.sleep(2000);
		WebElement priceValue = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Rs. 1,398.00\"])[1]"));
		String priceText = priceValue.getText();
		//System.out.println(priceText);
		
                   
		String s= priceText;
		String a[] = s.split("Rs.");
		//System.out.println(a[1]);
		for (int i = 0; i <= a[1].length()-4; i++) {
			System.out.print(a[1].charAt(i));//Hello
			
		}
		
		
		
	}
	
}
