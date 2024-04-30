package browserStack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MobileBrowserTestingHashMap {
	public static final String userName ="siddhivinayak_SUHx1r";
	public static final String accessKey ="KqcWhpx9PQyJ6Pp8NXHp";
	public static final String url ="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	@Test
	public void mobileBrowser() throws MalformedURLException {
		MutableCapabilities dc = new MutableCapabilities();
		HashMap<String, Object> browserStackOpt = new HashMap<String, Object>();
		browserStackOpt.put("browserName", "chrome");
		browserStackOpt.put("deviceName", "Google Pixel 6 Pro");
		browserStackOpt.put("realMobile", true);
		browserStackOpt.put("osVersion", "13");
		dc.setCapability("bstack:options", browserStackOpt);
		
		WebDriver driver = new RemoteWebDriver(new URL(url),dc);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	}
}
