/*
 * Author: Bharat Shori
 * 
 * Class contains all the elements and methods needed for Jupiter Toys home page
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	static WebDriver driver = null;
	static WebElement element = null;
	
	//page constructor
	public HomePage(WebDriver driver){
		HomePage.driver = driver;		
	}

	// element identifiers
	static By contact = By.linkText("Contact");
	static By shop = By.linkText("Shop");


	//elements locators
	public static WebElement shopLink(WebDriver driver) {
		element = new WebDriverWait(driver,10)
				.until(ExpectedConditions.elementToBeClickable(shop));
		return element;
	}

	public static WebElement contactLink(WebDriver driver) {
		element = new WebDriverWait(driver,10)
				.until(ExpectedConditions.elementToBeClickable(contact));
		return element;
	}

	//element methods
	public static void clickShopLink() {

		driver.findElement(shop).click();
	}


	public static void clickContactLink() {

		driver.findElement(contact).click();
	}


}
