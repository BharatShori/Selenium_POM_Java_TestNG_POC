package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CartPage {
	static WebDriver driver = null;
	static WebElement element = null;

	//page constructor
	public CartPage(WebDriver driver){
		CartPage.driver = driver;		
	}

	//form elements identifiers
	static By cartMsg = By.className("cart-msg");
	static By crtItm1 = By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[1]");
	static By crtItm1SubT = By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[4]");
	static By crtItm2 = By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[1]");
	static By crtItm2SubT = By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[4]");
	static By crtTot = By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong");



	//form elements locators
	public static WebElement cartMessage(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(cartMsg));
		return element;		
	}
	public static WebElement cartItem1(WebDriver driver) {
		element = driver.findElement(crtItm1);
		return element;		
	}
	public static WebElement cartItem1SubTotal(WebDriver driver) {
		element = driver.findElement(crtItm1SubT);
		return element;		
	}
	public static WebElement cartItem2(WebDriver driver) {
		element = driver.findElement(crtItm2);
		return element;		
	}
	public static WebElement cartItem2SubTotal(WebDriver driver) {
		element = driver.findElement(crtItm2SubT);
		return element;	
	}
	public static WebElement cartTotalAmount(WebDriver driver) {
		element = driver.findElement(crtTot);
		return element;		
	}
	//form elements functions



}

