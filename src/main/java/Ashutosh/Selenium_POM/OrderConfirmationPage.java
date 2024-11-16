package Ashutosh.Selenium_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Selenium_Framework1_Utility.ReuseFUN;

public class OrderConfirmationPage extends ReuseFUN{
WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary") WebElement confirmationMassage;
	
	
	public boolean getconfirmationmassage(String expectedtxt) {
		
		boolean actualtxt=confirmationMassage.getText().equalsIgnoreCase(expectedtxt);
		return actualtxt;
	}
	
	
}
