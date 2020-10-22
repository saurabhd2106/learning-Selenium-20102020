package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAndFrameHandling {
	
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

	}
	
	public void clickTryItButton() {
		
		String parentWindow = driver.getWindowHandle();
		
		System.out.println("Parent Window - "+ parentWindow);
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//To switch back to a page from a frame
		//driver.switchTo().defaultContent();
		
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		
		System.out.println("Child Window - "+ childWindow);
		
		driver.switchTo().window(childWindow);
		
		System.out.println("Title of child window "+ driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		System.out.println("Title of parent window "+ driver.getTitle());
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		WindowAndFrameHandling wf = new WindowAndFrameHandling();
		
		wf.invokeBrowser();
		
		wf.clickTryItButton();
	}

}
