package browserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MobileWeb {

	public static final String userName ="siddhivinayak_SUHx1r";
	public static final String accessKey ="KqcWhpx9PQyJ6Pp8NXHp";
	public static final String url ="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	
	@Test
	public void mobileWeb() throws MalformedURLException {
	MutableCapabilities dc = new MutableCapabilities();	
	
	dc.setCapability("deviceName", "Google Pixel 7");
	dc.setCapability("browserName", "Chrome");
	dc.setCapability("platformName", "Android");
	dc.setCapability("platformVersion", "13");
	dc.setCapability("build", "1.0.8");
	dc.setCapability("name","MobileWeb");
	
	WebDriver driver = new RemoteWebDriver(new URL(url),dc);
	driver.get("https://www.facebook.com/");
	System.out.println(driver.getTitle());
	}
}
