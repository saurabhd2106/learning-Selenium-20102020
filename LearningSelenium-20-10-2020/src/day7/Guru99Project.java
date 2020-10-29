package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Guru99Project {

	WebDriver driver;

	@Parameters("browserType")
	@Test
	public void invokeBrowser(String browserType) {

		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

			driver = new ChromeDriver();

		} else if (browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/saurabhd2106gma/Desktop/libs/geckodriver");

			driver = new FirefoxDriver();
		}

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4");
	}

	@Test(dependsOnMethods = { "invokeBrowser", "loginToApplication" })
	public void closeBrowser() {
		driver.quit();
	}

	@Parameters({ "user", "pass" })
	@Test(dependsOnMethods = "invokeBrowser")
	public void loginToApplication(String username, String password) {

		// Identifying an element
		WebElement userIdElement = driver.findElement(By.name("uid"));

		userIdElement.clear();

		// Performing an action
		userIdElement.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

		String expectedTitle = "Guru99 Bank Manager HomePage";

		String actualTitle = driver.getTitle();

		String expectedUrl = "http://demo.guru99.com/v4/manager/Managerhomepage.php";

		String actualUrl = driver.getCurrentUrl();

		SoftAssert softAssert = new SoftAssert();

		// Assert.assertEquals(actualTitle, expectedTitle);

		// Assert.assertTrue(actualTitle.equals(expectedTitle));

		softAssert.assertEquals(actualTitle, expectedTitle);

		softAssert.assertEquals(actualUrl, expectedUrl);

		softAssert.assertAll();

	}

}
