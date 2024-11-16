package Selenium_Framework1_Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;

import Ashutosh.Selenium_POM.MyCartPage;
import Ashutosh.Selenium_POM.OrderPage;

public class ReuseFUN {

	WebDriver driver;

	public ReuseFUN(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartbutton;
	@FindBy(css = "[routerlink*='order']")
	WebElement Orderbutton;

	public void waitfortheelement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitforWebElement(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}

	public void waitfortheelementtobeInvisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public MyCartPage GoToCart() {
		cartbutton.click();
		MyCartPage MyCartPage = new MyCartPage(driver);
		return MyCartPage;
	}

	public OrderPage GoToOrderList() {
		Orderbutton.click();
		OrderPage OrderPage=new OrderPage(driver);
		return OrderPage;
	}

}