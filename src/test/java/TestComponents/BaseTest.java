package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Ashutosh.Selenium_POM.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage LandingPage;
	public WebDriver browserInitialisation() throws IOException {

		Properties prop = new Properties();
		FileInputStream data = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Properties/GlobalData.properties");
		prop.load(data);
		String brousername=System.getProperty("browser")!=null ?  prop.getProperty("Browser"): System.getProperty("browser");
		String browser = prop.getProperty("Browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Testing/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:/Testing/msedgedriver.exe");
			driver = new EdgeDriver();
			
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.firefox.driver", "C:/Testing/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	@BeforeMethod(alwaysRun = true)
	public void LaunchApplication() throws IOException  {
		driver = browserInitialisation();
		LandingPage= new LandingPage(driver);
		LandingPage.launchurl();
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser() {
		driver.close();
	}
	
	
	
	

}
