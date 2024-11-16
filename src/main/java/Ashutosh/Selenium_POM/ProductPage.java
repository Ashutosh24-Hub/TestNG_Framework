package Ashutosh.Selenium_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Framework1_Utility.ReuseFUN;

public class ProductPage extends ReuseFUN{

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css =".mb-3") List<WebElement> productlist;
By products = By.cssSelector(".mb-3");
By addtocart = By.xpath("//div[@class='card-body']//button[2]");
By massage=By.cssSelector("#toast-container");
@FindBy(css ="#toast-container") WebElement massage1;


public WebElement Getrequiredproductname(String productname) {
	
	waitfortheelement(products);
    WebElement prod= productlist.stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productname)).findFirst().orElse(null);	
    return prod;
}

public void addtocart(String productname) {
	
	WebElement prod=Getrequiredproductname(productname);
	 prod.findElement(addtocart).click();
	 waitfortheelement(massage);
	 waitfortheelementtobeInvisible(massage1);
	 
}





}
