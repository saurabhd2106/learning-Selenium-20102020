package gridExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSeleniumGrid {

	WebDriver driver;

	@Parameters("browserType")
	@Test
	public void verifySeleniumGrid(String browserType) throws MalformedURLException {

		URL remoteAddress = new URL("http://172.17.0.1:4444/wd/hub");

		if (browserType.equals("chrome")) {

			ChromeOptions chromeOption = new ChromeOptions();

			driver = new RemoteWebDriver(remoteAddress, chromeOption);

		} else if (browserType.equals("firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			driver = new RemoteWebDriver(remoteAddress, firefoxOptions);

		}
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://test.qatechhub.com");

	}

}
