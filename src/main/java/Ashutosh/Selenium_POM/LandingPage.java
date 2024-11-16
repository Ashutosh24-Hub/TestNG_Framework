package Ashutosh.Selenium_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Framework1_Utility.ReuseFUN;

public class LandingPage extends ReuseFUN {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="userEmail") WebElement usermail;
@FindBy(id="userPassword") WebElement Pasword;
@FindBy(xpath ="//input[@name='login']") WebElement LoginButton;
@FindBy(css = "div[role='alert']") WebElement errormsg;


public void launchurl() {
	driver.get("https://rahulshettyacademy.com/client/");
}


public ProductPage loginApplication(String userId, String PaswordId) {

	usermail.sendKeys(userId);
	Pasword.sendKeys(PaswordId);
	LoginButton.click();
	ProductPage ProductPage=new ProductPage(driver);
	return ProductPage;
}

public String ErrorMassageValidation() {
	waitforWebElement(errormsg);
	return errormsg.getText();
}










}
