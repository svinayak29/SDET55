package browserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebBrowser {

	public static final String userName ="siddhivinayak_SUHx1r";
	public static final String accessKey ="KqcWhpx9PQyJ6Pp8NXHp";
	public static final String url ="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	@Test
	public void webBrowser() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("os", "windows");
		dc.setCapability("os_version", "11");
		dc.setCapability("browser", "chrome");
		dc.setCapability("browser_version", "117");
		dc.setCapability("name", "WebBrowser");
		
		WebDriver driver = new RemoteWebDriver(new URL(url),dc);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		
				
	}
	
	
	
}
