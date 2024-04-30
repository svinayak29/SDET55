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

public class Drag {

	
	@Test
	public void drag() throws MalformedURLException {
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
		AndroidDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement ele = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"endX",726,"endY",1096,"speed",5000));
		
		String res = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(res);
	}
}






