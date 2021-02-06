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

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import pages.HomePage;
import pages.ShopPage;
import pages.CartPage;
import pages.ContactPage;


public class Test4 {

	static WebDriver driver = null;

	@BeforeTest

	public static void setup() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public static void testCase4(){	

		HomePage homePage = new HomePage(driver);
		driver.get("https://jupiter.cloud.planittesting.com/#/home");

		// go to contact page 

		HomePage.clickShopLink();


		// add items to shopping cart
		ShopPage shopPage = new ShopPage(driver);
		assertEquals(ShopPage.btnBuyFluffyBunny(driver).isDisplayed(), true);
		ShopPage.addFluffyBunny();
		ShopPage.addFunnyCow();
		ShopPage.addFunnyCow();

		//validate shopping cart
		ShopPage.clickCartLink();
		CartPage cartPage = new CartPage(driver);
		assertEquals(CartPage.cartMessage(driver).getText(), "There are 3 items in your cart, you can Checkout or carry on Shopping.");
		assertEquals(CartPage.cartItem1(driver).getText(), "Fluffy Bunny" );
		assertEquals(CartPage.cartItem1SubTotal(driver).getText(), "$9.99");
		assertEquals(CartPage.cartItem2(driver).getText(), "Funny Cow");
		assertEquals(CartPage.cartItem2SubTotal(driver).getText(), "$21.98");
		assertEquals(CartPage.cartTotalAmount(driver).getText(), "Total: 31.97");

	}

	@AfterTest

	public static void close() {
		driver.quit();
	}

}
