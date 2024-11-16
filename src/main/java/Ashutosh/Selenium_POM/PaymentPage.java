package Ashutosh.Selenium_POM;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Framework1_Utility.ReuseFUN;

public class PaymentPage extends ReuseFUN {
WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@placeholder='Select Country']") WebElement country;
	By CountryBox=By.xpath("//*[@placeholder='Select Country']");
	@FindBy(xpath = "//button[contains(@class,'ta-item list')][2]") WebElement countryselect;
	@FindBy(css = ".action__submit") WebElement PlcaeOrder;
	@FindBy(xpath = "//section[contains(@class,'ta-results')]") WebElement countryresult;
	By countryresult1=By.xpath("//section[contains(@class,'ta-results')]");

	public void EnderCountryName(String contryname) {
	Actions act=new Actions(driver);
	act.sendKeys(driver.findElement(CountryBox),contryname).build().perform();
	}
	

	public void ClickOnCountry() {
		waitfortheelement(countryresult1);
		countryselect.click();
	}
	
	public OrderConfirmationPage ClickOnPlaceOrderbutton() {
		PlcaeOrder.click();
		OrderConfirmationPage OrderConfirmationPage=new OrderConfirmationPage(driver);
		return OrderConfirmationPage;
	}


	

}
