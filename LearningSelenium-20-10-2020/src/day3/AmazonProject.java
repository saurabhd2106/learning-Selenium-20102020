package day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProject {

	WebDriver driver;

	public void invokeBrowser(String browserType) {
		
		if(browserType.equals("chrome")) {

		System.setProperty("webdriver.chrome.driver", "/home/saurabhd2106gma/Desktop/libs/chromedriver");

		driver = new ChromeDriver();
		
		} else if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/saurabhd2106gma/Desktop/libs/geckodriver");

			driver = new FirefoxDriver();
		}

		// Maximize the browser's screen
		driver.manage().window().maximize();

		// Bypass all the existing cookies
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

	}

	public void searchProduct(String product, String category) {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);

		WebElement categoryDropdown = driver.findElement(By.id("searchDropdownBox"));

		Select selCategory = new Select(categoryDropdown);

		selCategory.selectByVisibleText(category);

		driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

	public String getSearchResult() {

		return driver.findElement(By.xpath("//span[@data-component-type='s-result-info-bar']")).getText();
	}

	public void getNthProduct(int itemNumber) {

		String xpathExpression = String.format("//span[@data-component-type='s-search-results']"
				+ "//div[@data-component-type='s-search-result' and @ data-index='%d']", itemNumber);

		String nthProductDetails = driver.findElement(By.xpath(xpathExpression)).getText();

		System.out.println(nthProductDetails);

	}

	public void getALlProduct() {

		List<WebElement> allProduct = driver.findElements(By.xpath(
				"//span[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"]"));

		for (WebElement product : allProduct) {

			System.out.println(product.getText());

			System.out.println("-------------------------------------");
		}

	}

	public void getALlProductAndScroll() {

		List<WebElement> allProduct = driver.findElements(By.xpath(
				"//span[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"]"));

		Actions action = new Actions(driver);

		for (WebElement product : allProduct) {

			action.moveToElement(product).build().perform();

			System.out.println(product.getText());

			System.out.println("-------------------------------------");
		}

	}

	public void getALlProductAndScrollViaJs() {

		List<WebElement> allProduct = driver.findElements(By.xpath(
				"//span[@data-component-type=\"s-search-results\"]//div[@data-component-type=\"s-search-result\"]"));

		int xLocation, yLocation;

		for (WebElement product : allProduct) {

			xLocation = product.getLocation().x;
			yLocation = product.getLocation().y;

			scrollBy(xLocation, yLocation);

			System.out.println(product.getText());

			System.out.println("-------------------------------------");
		}

	}

	private void scrollBy(int x, int y) {
		JavascriptExecutor jsEngine;

		jsEngine = (JavascriptExecutor) driver;

		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);

		jsEngine.executeScript(jsCommand);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		AmazonProject amazonProject = new AmazonProject();

		amazonProject.invokeBrowser("firefox");

		amazonProject.searchProduct("Apple Watch", "Electronics");

		System.out.println(amazonProject.getSearchResult());

		amazonProject.getALlProductAndScrollViaJs();

		amazonProject.getNthProduct(6);

		amazonProject.closeBrowser();
	}

}
