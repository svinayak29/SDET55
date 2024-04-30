package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {

	@Test
	public void demo() throws MalformedURLException {
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
		//dc.setCapability("appPackage","com.oneplus.calculator");
		//dc.setCapability("appActivity","com.oneplus.calculator.Calculator");
		
		URL u = new URL("http://localhost:4723");
		//AndroidDriver driver = new AndroidDriver(u,dc);
		
		AppiumDriver driver = new AndroidDriver(u,dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
		//driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
		 /*driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_8")).click();
		 driver.findElement(AppiumBy.accessibilityId("plus")).click();
	     driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_2")).click();
	     
	     WebElement textResult = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/result"));
	     String textValue = textResult.getText();
	     System.out.println(textValue);
	     
	     driver.findElement(AppiumBy.id("com.oneplus.calculator:id/clr")).click();
	     
	     driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
	     driver.findElement(AppiumBy.accessibilityId("minus")).click();
	     driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_2")).click();
	     String res = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
	     System.out.println(res);
	     driver.findElement(AppiumBy.id("com.oneplus.calculator:id/clr")).click();*/
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).click();
				
	     
		
		
		
	}
}
