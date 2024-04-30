package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;

public class AppInstall {
    @Test
	public void intallAppln() throws MalformedURLException {
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
		 driver.installApp("E:\\Download\\General-Store.apk");
		 if(driver.isAppInstalled("com.androidsample.generalstore")) {
			 System.out.println("Installed");
		 }
		 else {
			 System.out.println("Not Installed");
		 }
		driver.removeApp("com.androidsample.generalstore");
		 
	}
}
