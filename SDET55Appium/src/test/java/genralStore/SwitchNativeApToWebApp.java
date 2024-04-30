package genralStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

 public class SwitchNativeApToWebApp {
@Test
 public void nativeTOWebApp() throws MalformedURLException {
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
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vinayak");
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/..//android.widget.TextView[@text='ADD TO CART']")).click();
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	Set<String> cons = driver.getContextHandles();
	int count = cons.size();
	System.out.println(count);
	for (String con : cons) {
	
		System.out.println(con);
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
	}
	driver.findElement(By.name("q")).sendKeys("Appium"+Keys.ENTER);
	
 }




}
