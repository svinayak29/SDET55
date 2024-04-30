package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Activate {

	@Test
	public void activate() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "OnePlus9R");
		dc.setCapability("UDID", "72613c38");
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,dc);
		if(driver.isAppInstalled("com.androidsample.generalstore")) {
			System.out.println("Installed");
		}
		else {
			System.out.println("Not Installed");
		}
		driver.activateApp("com.androidsample.generalstore");//to launch the app
		driver.runAppInBackground(Duration.ofSeconds(10));//to run in background
		
		System.out.println(driver.queryAppState("com.androidsample.generalstore"));//to find the status of app running in background or foreground
		
		
	}
}
