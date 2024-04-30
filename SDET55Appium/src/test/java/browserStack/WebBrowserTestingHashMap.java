package browserStack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebBrowserTestingHashMap {
	public static final String userName ="siddhivinayak_SUHx1r";
	public static final String accessKey ="KqcWhpx9PQyJ6Pp8NXHp";
	public static final String url ="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	
     @Test
	public void webBrowser() throws MalformedURLException {
		ChromeOptions browserOpt = new ChromeOptions();
		browserOpt.setPlatformName("windows 11");
		browserOpt.setBrowserVersion("latest");
		
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("build", "selenium-build GME35");
		options.put("name", "WebBrowserTestingHashMap");
		browserOpt.setCapability("sauce:options", options);
		//browserOpt.setCapability("bstack", options);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL(url),browserOpt);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		
	}
}
