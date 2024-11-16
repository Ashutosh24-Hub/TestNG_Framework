package Ashutosh.Selenium_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Framework1_Utility.ReuseFUN;

public class OrderPage extends ReuseFUN {

WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//tr//td[2]") List<WebElement> namrcol;
	
	
	public boolean getplacedordername(String productname) {
		
		boolean namestatus=namrcol.stream().anyMatch(name->name.getText().equalsIgnoreCase(productname));
		return namestatus;
	}
	
	
	
	
}
