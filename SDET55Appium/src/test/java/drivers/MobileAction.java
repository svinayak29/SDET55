package drivers;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileAction {

	@Test
	public void action() throws MalformedURLException, InterruptedException {
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
		//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		//driver.pressKey(new KeyEvent(AndroidKey.HOME));
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
		//driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
		//driver.pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));
		//driver.activateApp("com.androidsample.generalstore");
		//Thread.sleep(3000);
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).click();
		
		//driver.pressKey(new KeyEvent(AndroidKey.SPACE));
		
		//driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_UP));
		//driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_DOWN));
		driver.pressKey(new KeyEvent(AndroidKey.CALCULATOR));
	}
}
