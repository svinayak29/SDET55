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

public class Click {

	
	@Test
	public void clickAction() throws MalformedURLException {
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
		
		
		
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", 
				ImmutableMap.of("x",205,"y",639));
		
		String text = driver.findElement(AppiumBy.accessibilityId("Cloning")).getText();
		
		System.out.println(text);
		
		
		
		
		
		
	}
}
