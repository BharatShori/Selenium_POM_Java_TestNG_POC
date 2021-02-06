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


public class Test3 {

	static WebDriver driver = null;

	@BeforeTest

	public static void setup() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public static void testCase3(){	

		HomePage homePage = new HomePage(driver);
		driver.get("https://jupiter.cloud.planittesting.com/#/home");

		// go to contact page 

		HomePage.clickContactLink();


		//populate mandatory fields with invalid data
		ContactPage contactPage = new ContactPage(driver);
		ContactPage.setForenameText(" ");
		ContactPage.setEmailText("testautomation.com");
		ContactPage.setMessageText(" ");

		// click on submit button
		ContactPage.clickSubmitButton();

		// validate errors
		assertEquals(ContactPage.formError(driver).getText(), "We welcome your feedback - but we won't get it unless you complete the form correctly.");
		assertEquals(ContactPage.forenameError(driver).getText(), "Forename is required");
		assertEquals(ContactPage.emailError(driver).getText(), "Please enter a valid email");
		assertEquals(ContactPage.messageError(driver).getText(), "Message is required");

	}

	@AfterTest

	public static void close() {
		driver.quit();
	}

}
