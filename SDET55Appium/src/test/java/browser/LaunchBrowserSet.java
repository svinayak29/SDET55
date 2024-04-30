package browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LaunchBrowserSet {

	@Test
	public void launchBrowser() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("OnePlus9r");
		options.setAutomationName("uiAutomator2");
		options.setCapability("browserName", "chrome");
		options.ignoreHiddenApiPolicyError();
		options.autoGrantPermissions();
		options.autoWebview();
		options.noReset();
		URL u = new URL("http://localhost:4723");
		AndroidDriver driver = new AndroidDriver(u,options);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	}
}
