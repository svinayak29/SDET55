package startAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ParallelExec {

	@Parameters({"deviceName","UDID","port"})
	@Test
	public void demo(String deviceName,String UDID,int port ) throws MalformedURLException, InterruptedException {
		File fs = new File("C:\\Users\\siddhi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(fs).withIPAddress("127.0.0.1").usingPort(port).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("UDID", UDID);
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiPolicyError", true);
		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
		URL u = new URL("http://localhost:"+port+" ");
		AndroidDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		//driver.activateApp("com.androidsample.generalstore");
		Thread.sleep(3000);
		service.stop();
	}
}
