package gesture;

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

public class ZoomOut {

	@Test
	public void zoomOut() throws MalformedURLException, InterruptedException {
		String path = "E:\\Download\\com.davemorrissey.labs.subscaleview.sample.apk";
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "OnePlus9R");
		dc.setCapability("UDID", "72613c38");
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		//dc.setCapability("app", path);
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");		
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/eventHandling")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(AppiumBy.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"percent",0.75));
		
		
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"percent",0.75));
		
	}
}
