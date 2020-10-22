package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4");

	}

	public void loginToApplication(String username, String password) {

		// Identifying an element
		WebElement userIdElement = driver.findElementByName("uid");

		userIdElement.clear();

		// Performing an action
		userIdElement.sendKeys(username);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

	}

	public String getTitle() {

		return driver.getTitle();
	}

	public void addCustomer() {
		driver.findElement(By.linkText("New Customer")).click();

		driver.findElement(By.name("name")).sendKeys("Prerna");

		driver.findElement(By.xpath("//input[@value='f']")).click();

		driver.findElement(By.id("dob")).sendKeys("06-06-1989");

		driver.findElement(By.name("addr")).sendKeys("Bangalore");

		driver.findElement(By.name("city")).sendKeys("Bangalore");

		driver.findElement(By.name("state")).sendKeys("Karnatka");
		driver.findElement(By.name("pinno")).sendKeys("234132");
		driver.findElement(By.name("telephoneno")).sendKeys("432542");
		
		String emailId = "ss" + System.currentTimeMillis() + "@dfghd.com";
		
		System.out.println(emailId);
		
		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("password")).sendKeys("fdadf");
		driver.findElement(By.name("sub")).click();
	}

	public String getCutomerId() {
		String customerId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();

		return customerId;
	}
	
	public void addAccount(String customerId) {
		
		driver.findElement(By.linkText("New Account")).click();
		
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		
		WebElement dropdown = driver.findElement(By.name("selaccount"));
		
		Select accountType = new Select(dropdown);
		
		accountType.selectByVisibleText("Current");
		
		System.out.println(accountType.isMultiple());
		
		driver.findElement(By.name("inideposit")).sendKeys("32487");
		
		driver.findElement(By.name("button2")).click();
		
	}
	
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		try {
			
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		alert.accept();
		
	}

	public void closeBrowser() {
		driver.quit();
	}

}
