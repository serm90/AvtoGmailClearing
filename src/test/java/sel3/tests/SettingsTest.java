package sel3.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

public class SettingsTest {

    public  WebDriver driver;

    protected static String password =  "12345678azx";
    protected static String login = "testtaras1@gmail.com";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//serg-qa//Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");
    }

    @AfterTest
   public void tearDown(){driver.quit();}

}
