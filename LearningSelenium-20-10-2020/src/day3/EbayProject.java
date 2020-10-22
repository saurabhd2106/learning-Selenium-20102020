package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EbayProject {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://ebay.in");

	}
	
	public void selectAValueFromSubMenu() {
		WebElement electronicsLink = driver.findElement(By.linkText("Electronics"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(electronicsLink).build().perform();
		
		WaitUtility.waitTillElementVisible(driver, 10, By.linkText("Smart Watches"));
		
		WebElement smartWatchLink = driver.findElement(By.linkText("Smart Watches"));
		
		
		action.moveToElement(smartWatchLink).click().build().perform();
	}
	
	public static void main(String[] args) {
		EbayProject ebayProject = new EbayProject();
		
		ebayProject.invokeBrowser();
		
		ebayProject.selectAValueFromSubMenu();
		
		
	}
}
