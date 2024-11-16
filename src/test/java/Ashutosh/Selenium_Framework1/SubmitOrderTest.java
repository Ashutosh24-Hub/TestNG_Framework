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
import Ashutosh.Selenium_POM.OrderPage;
import Ashutosh.Selenium_POM.PaymentPage;
import Ashutosh.Selenium_POM.ProductPage;
import TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productname = "ZARA COAT 3";
	@Test
	public void SubmitOrder() throws IOException {

		
		ProductPage ProductPage = LandingPage.loginApplication("demo24@gmail.com", "Pass@361");
		ProductPage.Getrequiredproductname(productname);
		ProductPage.addtocart(productname);
		MyCartPage MyCartPage = ProductPage.GoToCart();
		boolean match = MyCartPage.validateMyCartList(productname);
		Assert.assertTrue(match);
		PaymentPage PaymentPage = MyCartPage.clickOnCkeckOutButton();
		PaymentPage.EnderCountryName("India");
		PaymentPage.ClickOnCountry();
		OrderConfirmationPage OrderConfirmationPage = PaymentPage.ClickOnPlaceOrderbutton();
		boolean Msgstatus = OrderConfirmationPage.getconfirmationmassage("Thankyou for the order.");
		Assert.assertTrue(Msgstatus);
	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void orderVerifyinOrderlistTest() {
		
		ProductPage ProductPage = LandingPage.loginApplication("demo24@gmail.com", "Pass@361");
		OrderPage OrderPage=LandingPage.GoToOrderList();
		Assert.assertTrue(OrderPage.getplacedordername(productname));
		
	}

}
