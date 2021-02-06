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


public class Test2 {

	static WebDriver driver = null;

	@BeforeTest

	public static void setup() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public static void testCase2(){	

		HomePage homePage = new HomePage(driver);
		driver.get("https://jupiter.cloud.planittesting.com/#/home");

		// go to contact page 

		HomePage.clickContactLink();


		//populate mandatory fields
		ContactPage contactPage = new ContactPage(driver);
		ContactPage.setForenameText("test");
		ContactPage.setEmailText("test@automation.com");
		ContactPage.setMessageText("test automation is fun");

		// click on submit button
		ContactPage.clickSubmitButton();

		//validate success message
		assertEquals(ContactPage.buttonBack(driver).isDisplayed(), true);
		assertEquals(ContactPage.formError(driver).getText(), "Thanks test, we appreciate your feedback.");

	}

	@AfterTest

	public static void close() {
		driver.quit();
	}

}
