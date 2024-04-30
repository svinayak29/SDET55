package startAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumStartUsingScript {
@Test
public void startAppium() throws MalformedURLException, InterruptedException {
	File fs = new File("C:\\Users\\siddhi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
	AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(fs).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
	service.start();
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
	Thread.sleep(3000);
	service.stop();
}
}
