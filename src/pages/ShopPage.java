package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ShopPage {
	static WebDriver driver = null;
	static WebElement element = null;

	//page constructor
	public ShopPage(WebDriver driver){
		ShopPage.driver = driver;		
	}

	//form elements identifiers
	static By cart = By.partialLinkText("Cart");
	static By buyFunnyCow = By.xpath("//*[@id='product-6']/div/p/a");
	static By buyFluffyBunny = By.xpath("//*[@id='product-4']/div/p/a");


	//form elements setter
	public static WebElement btnBuyFunnyCow(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(buyFunnyCow));
		return element;		
	}

	public static WebElement btnBuyFluffyBunny(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(buyFluffyBunny));
		return element;		
	}

	public static WebElement cartLink(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(cart));
		return element;		
	}


	//form elements functions
	public static void addFluffyBunny() {
		btnBuyFluffyBunny(driver).click();
	}

	public static void addFunnyCow() {
		btnBuyFunnyCow(driver).click();
	}


	public static void clickCartLink() {
		cartLink(driver).click();
	}


}
