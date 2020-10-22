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

	public String getLinkUrl(String linktext) {

		WebElement link = driver.findElement(By.linkText(linktext));

		return link.getAttribute("href");

	}

	public void getAllLinkInfo() {
		List<WebElement> allLink = driver.findElements(By.tagName("a"));

		for (WebElement element : allLink) {

			System.out.println("Linktext - " + element.getText() + " and the URL is - " + element.getAttribute("href"));

			System.out.println("---------------------------------------------------------------------------------");

		}
	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		AmazonLinkExample amazonLink = new AmazonLinkExample();

		amazonLink.invokeBrowser();

		String linkUrl = amazonLink.getLinkUrl("Amazon Pay");

		System.out.println("Link URL - " + linkUrl);

		int linkCount = amazonLink.getLinkCount();

		System.out.println("Link Count - " + linkCount);

		amazonLink.getAllLinkInfo();
	}

}
