package pageObject.hook;

import pageObject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Hook {
    public WebDriver driver;
    public pageObject.pages.HomePage HomePage;
    public Utility util;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.shopify.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage = new HomePage(driver);
        util = new Utility(driver);
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
