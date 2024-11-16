package Ashutosh.Selenium_POM;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class A {

	public static void main(String[] args) {
		String[] products = { "ZARA COAT 3", "QWERTY" };

		System.setProperty("webdriver.chrome.driver", "C:/Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("demo24@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Pass@361");
		driver.findElement(By.cssSelector("#login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

		List<WebElement> producsweb = driver.findElements(By.xpath("//div[@class='card-body']//b"));

		for (int i = 0; i < producsweb.size(); i++) {
			String productname = producsweb.get(i).getText();
			List productlist = Arrays.asList(products);
			if (productlist.contains(productname)) {
				driver.findElements(By.xpath("//div[@class='card-body']//button[2]")).get(i).click();
				WebElement msg = driver.findElement(By.cssSelector(".toast-message"));
				wait.until(ExpectedConditions.visibilityOf(msg));
				wait.until(ExpectedConditions.invisibilityOf(msg));
			}
		}

		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();

		List<WebElement> cart_Produc = driver.findElements(By.xpath("//*[@class='cart']//h3"));

		List<String> AddedProductList = null;

		for (int i = 0; i < cart_Produc.size(); i++) {
			Assert.assertEquals(cart_Produc.get(i).getText(), products[i]);
		}

		driver.findElement(By.xpath("//li[@class='totalRow']//button")).click();

		WebElement countrybox = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		Actions act = new Actions(driver);
		act.sendKeys(countrybox, "India").build().perform();

		WebElement country = driver.findElement(By.xpath("//section[contains(@class,'ta-results')]//button[2]"));
		wait.until(ExpectedConditions.visibilityOf(country));
		country.click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		String actualTXT = driver.findElement(By.xpath("//tbody//h1")).getText();
		Assert.assertTrue(actualTXT.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	
		// TODO Auto-generated method stub

	}

}
