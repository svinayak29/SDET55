package h_m;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class EndToEndH_MTest {

	@Test
	public void demo() throws MalformedURLException, InterruptedException {
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
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\").instance(0)")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Baby\"]")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Flounce-trimmed jersey dress\"));")).click();
		driver.findElement(AppiumBy.accessibilityId("Product Image")).click();
		Thread.sleep(3000);
		WebElement img = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)img),"percent",0.75));
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)img),"percent",0.75));
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)img).getId(),"direction","left","percent",0.75));
		WebElement img2 = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]"));
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)img2).getId(),"direction","right","percent",0.75));
		driver.findElement(AppiumBy.id("com.hm.goe:id/ivCloseCarousel")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.hm.goe:id/hm_shoppingbag_count")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"3\"));")).click();
		
		
	}
}
