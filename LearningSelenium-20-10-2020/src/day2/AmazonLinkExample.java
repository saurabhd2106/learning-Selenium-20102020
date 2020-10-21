package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinkExample {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("https://www.amazon.in/");

	}

	public int getLinkCount() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		return allLinks.size();
	}

	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		AmazonLinkExample amazonLink = new AmazonLinkExample();
		
		amazonLink.invokeBrowser();
		
		int linkCount = amazonLink.getLinkCount();
		
		System.out.println("Link Count - "+ linkCount);
	}

}
