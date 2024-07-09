package Enocta;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
    protected static WebDriver driver;
    
   // protected  String url = "https://www.trendyol.com/";

    
	@BeforeClass
	@Parameters("browser")
    public void beforeClass(String browser) {

        
           // System.setProperty("webdriver.chrome.driver", "C:\\Users\\90533\\eclipse-workspace\\EnoctaVakaCalismasi\\chromedriver.exe");

       
                if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\90533\\eclipse-workspace\\EnoctaVakaCalismasi\\chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\90533\\eclipse-workspace\\EnoctaVakaCalismasi\\geckodriver.exe");
                    driver = new FirefoxDriver();
                } else {
                    throw new IllegalArgumentException("Browser not supported: " + browser);
                }
                driver.manage().window().maximize();
       
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get(url);
	}
        
            


    
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		  if (driver != null) {
	            driver.quit();
    	
		  }
	}
}