package Ashutosh.Selenium_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Selenium_Framework1_Utility.ReuseFUN;

public class MyCartPage extends ReuseFUN {

	WebDriver driver;
	
	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='cartSection']/h3") List<WebElement> MyCartProduct;
	By mycartlist= By.xpath("//div[@class='cartSection']/h3");
	@FindBy(css = ".totalRow button") WebElement ChecketOutbutton;
	
	
	
	public boolean validateMyCartList(String productname) {
		waitfortheelement(mycartlist);
		boolean status= MyCartProduct.stream().anyMatch(cartpro->cartpro.getText().equalsIgnoreCase(productname));
		return status;
	}
	public PaymentPage clickOnCkeckOutButton() {
		ChecketOutbutton.click();
		PaymentPage PaymentPage=new PaymentPage(driver);
		return PaymentPage;
	}
	

}
