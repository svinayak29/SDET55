package genralStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GeneralStore {

	@Test
	public void test() throws MalformedURLException {
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
		driver.activateApp("com.androidsample.generalstore");
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vinayak");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String activity = driver.currentActivity();
		System.out.println(activity);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String text = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.Toast")).getText();
		System.out.println(text);
	}
}
