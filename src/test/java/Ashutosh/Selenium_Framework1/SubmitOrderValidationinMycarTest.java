package Ashutosh.Selenium_Framework1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ashutosh.Selenium_POM.LandingPage;
import Ashutosh.Selenium_POM.MyCartPage;
import Ashutosh.Selenium_POM.OrderConfirmationPage;
import Ashutosh.Selenium_POM.PaymentPage;
import Ashutosh.Selenium_POM.ProductPage;
import TestComponents.BaseTest;

public class SubmitOrderValidationinMycarTest extends BaseTest {

	@Test
	public void SubmitOrder() throws IOException {

		String productname = "ZARA COAT 3";
		ProductPage ProductPage = LandingPage.loginApplication("demo24@gmail.com", "Pass@361");
		ProductPage.Getrequiredproductname(productname);
		ProductPage.addtocart(productname);
		MyCartPage MyCartPage = ProductPage.GoToCart();
		boolean match = MyCartPage.validateMyCartList("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
