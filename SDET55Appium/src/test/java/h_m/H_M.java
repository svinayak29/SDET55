package h_m;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class H_M {

	@Test
	public void login() throws MalformedURLException {
    	DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", "OnePlus9R");
		dc.setCapability("UDID", "72613c38");
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("appPackage", "com.hm.goe");
		dc.setCapability("appActivity", "com.hm.goe.app.home.HomeActivity");
		URL u = new URL("http://localhost:4723");
		
		AndroidDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.installApp("E:\\Download\\HM_v22.15.1.apk");
		//driver.activateApp("com.hm.goe");
		
		
		
		
		
	}

}
