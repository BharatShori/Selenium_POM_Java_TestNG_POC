/*
 * Author: Bharat Shori
 */

package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ContactPage;


public class Test1 {

	static WebDriver driver = null;

	@BeforeTest

	public static void setup() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public static void testCase1(){	

		HomePage homePage = new HomePage(driver);
		driver.get("https://jupiter.cloud.planittesting.com/#/home");
		
		// go to contact page 

		HomePage.clickContactLink();
		
		// click on submit button
		ContactPage contactPage = new ContactPage(driver);
		ContactPage.clickSubmitButton();

		
		// validate errors
		assertEquals(ContactPage.formError(driver).getText(), "We welcome your feedback - but we won't get it unless you complete the form correctly.");
		assertEquals(ContactPage.forenameError(driver).getText(), "Forename is required");
		assertEquals(ContactPage.emailError(driver).getText(), "Email is required");
		assertEquals(ContactPage.messageError(driver).getText(), "Message is required");
		
		//populate mandatory fields
		ContactPage.setForenameText("test");
		ContactPage.setEmailText("email@test.com");
		ContactPage.setMessageText("test message");
		
		//validate errors disappear
		assertEquals(ContactPage.formError(driver).getText(), "We welcome your feedback - tell it how it is.");
		
	}

	@AfterTest

	public static void close() {
		driver.quit();
	}

}
