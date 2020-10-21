package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("https://test.qatechhub.com/drag-and-drop/");

	}
	
	public void performDragAndDrop() {
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		String colorBeforeDnD = target.getCssValue("color");
		
		action.dragAndDrop(source, target).build().perform();
		
	//	action.moveToElement(source).clickAndHold(source).moveToElement(target).release(target).build().perform();
		
		String colorAfterDnD = target.getCssValue("color");
		
		System.out.println("Before Dnd - "+ colorBeforeDnD);
		
		System.out.println("After Dnd - "+ colorAfterDnD);
	}
	
	public static void main(String[] args) {
		
		
		DragAndDrop dnd = new DragAndDrop();
		
		dnd.invokeBrowser();
		
		dnd.performDragAndDrop();
		
	}

}
