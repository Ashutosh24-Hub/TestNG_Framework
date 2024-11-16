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

public class ErrorValidationTest extends BaseTest {

	@Test(groups={"Error"})
	public void SubmitOrder() throws IOException {

		
		ProductPage ProductPage = LandingPage.loginApplication("demo24@gmail.com", "Pa");
		String actualError=LandingPage.ErrorMassageValidation();
		Assert.assertEquals(actualError, "Incorrect email or password.");
	    

	}

}
