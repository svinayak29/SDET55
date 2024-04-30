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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LongClick {

	
	@Test
	public void demo() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "OnePlus9R");
		dc.setCapability("UDID", "72613c38");
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("appPackage","io.appium.android.apis");
		dc.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		
		URL u = new URL("http://localhost:4723");
		AppiumDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId()));
		
		String textValue = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]")).getText();
		
		System.out.println(textValue);
		
}
	
	
}
