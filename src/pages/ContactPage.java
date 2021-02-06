package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	static WebDriver driver = null;
	static WebElement element = null;

	//form elements identifiers

	static By forename = By.id("forename");
	static By surname = By.id("surname");
	static By email = By.id("email");
	static By telephone = By.id("telephone");
	static By message = By.id("message");
	static By submit = By.linkText("Submit");
	static By back = By.xpath("/html/body/div[2]/div/a");
	
	//form error elements identifiers
	static By formErr = By.xpath("/html/body/div[2]/div/div");
	static By forenameErr = By.id("forename-err");
	static By emailErr = By.id("email-err");
	static By messageErr = By.id("message-err");

	//page constructor
	public ContactPage(WebDriver driver){
		ContactPage.driver = driver;		
	}
	
	//form elements setter
	public static WebElement inputForename(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(forename));
		return element;		
	}

	public static WebElement inputSurname(WebDriver driver) {
		element = driver.findElement(surname);
		return element;		
	}

	public static WebElement inputEmail(WebDriver driver) {
		element = driver.findElement(email);
		return element;		
	}

	public static WebElement textMessage(WebDriver driver) {
		element = driver.findElement(message);
		return element;		
	}

	public static WebElement buttonSubmit(WebDriver driver) {
		element = new WebDriverWait(driver,10)
				.until(ExpectedConditions.elementToBeClickable(submit));
		return element;		
	}
	
	public static WebElement buttonBack(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(back));
		return element;		
	}

	//form error elements setters

	public static WebElement formError(WebDriver driver) {
		element = new WebDriverWait(driver,30)
				.until(ExpectedConditions.elementToBeClickable(formErr));
		return element;		
	}

	public static WebElement forenameError(WebDriver driver) {
		element = driver.findElement(forenameErr);
		return element;		
	}

	public static WebElement emailError(WebDriver driver) {
		element = driver.findElement(emailErr);
		return element;		
	}

	public static WebElement messageError(WebDriver driver) {
		element = driver.findElement(messageErr);
		return element;		
	}

	//form elements functions

	public static void clickSubmitButton() {
		buttonSubmit(driver).click();
	}
	
	public static void setForenameText(String forename) {
		inputForename(driver).sendKeys(forename);
	}
	public static void setSurnameText(String surname) {
		inputSurname(driver).sendKeys(surname);
	}

	public static void setEmailText(String email) {
		inputEmail(driver).sendKeys(email);
	}
	public static void setMessageText(String message) {
		textMessage(driver).sendKeys(message);
	}


}
