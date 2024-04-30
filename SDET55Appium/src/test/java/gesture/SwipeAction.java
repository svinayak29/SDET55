package gesture;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SwipeAction {

	@Test
	public void swipe() throws MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("automationName", "uiAutomator2");
	dc.setCapability("deviceName", "OnePlus9R");
	dc.setCapability("UDID", "72613c38");
	dc.setCapability("noReset", true);
	dc.setCapability("ignoreHiddenApiPolicyError", true);
	dc.setCapability("autoGrantPermission", true);
	dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
	dc.setCapability("appActivity", ".MainActivity");	
	
	URL u = new URL("http://localhost:4723");
	AppiumDriver driver = new AndroidDriver(u,dc);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/viewPagerGalleries")).click();
	//((JavascriptExecutor)driver.executeScript("mobile: swipeGesture",ImmutableMap.of("left",1074,"top",1067,"width",30,"height",1067,"direction","left","percent",0.75)));
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("left",1071,"top",1063,"width",11,"height",1063,"direction","left","percent",0.75));
	
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of("left",11,"top",1063,"width",1071,"height",1063,"direction","right","percent",0.75));
	
	}
}
