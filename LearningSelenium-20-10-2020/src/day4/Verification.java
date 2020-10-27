package day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.mercurytravels.co.in");

	}

	public void verifDefaultElementsOnHomepage() {

		driver.get("https://www.mercurytravels.co.in");

		driver.findElement(By.xpath("//div[@id='modalPopup']//button/span[text()='×']")).click();

		driver.findElement(By.linkText("Flights")).click();

		WebElement roundTripRadioButton = driver.findElement(By.xpath("//input[@value='R']"));

		WebElement returnDate = driver.findElement(By.name("returnDate"));
		
		boolean roundTripDeatlStatus = roundTripRadioButton.isSelected();
		
		
		boolean visibleStatus = returnDate.isDisplayed();

		if (roundTripDeatlStatus &&  visibleStatus) {
			System.out.println("Test Pass");
		} else {
			System.err.println("Default status is wrong");
		}

		driver.findElement(By.xpath("//div[@id='modalPopup']//button/span[text()='×']")).click();
		
		WebElement oneWayTripRadioButton = driver.findElement(By.xpath("//input[@value='S']"));
		
		oneWayTripRadioButton.click();

		
		 visibleStatus = returnDate.isDisplayed();
		 
		 returnDate.isEnabled();
		
		if (!visibleStatus) {
			System.out.println("Test Pass");
		} else {
			System.err.println("Default status is wrong");
		}

	}

	public static void main(String[] args) {

		Verification verify = new Verification();

		verify.invokeBrowser();

		verify.verifDefaultElementsOnHomepage();

	}

}
