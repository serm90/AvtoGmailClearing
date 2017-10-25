package sel3.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import sel3.pages.LoginPage;
import sel3.pages.MailBox;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailBox mailBox;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//serg-qa//Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBox = new MailBox(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");
    }
     @Test
     public void loginTest() throws InterruptedException {
         loginPage.inputLogin("testtaras1@gmail.com");
         loginPage.clickLoginButton();
         loginPage.inputPassword("12345678azx");
         Thread.sleep(500);
         loginPage.clickLoginButtonNext();

         Thread.sleep(1000);
         mailBox.userProfileButton();
         String mailUser = mailBox.getUserMail();
         Assert.assertEquals("testtaras1@gmail.com", mailUser);




        }
        @AfterTest
        public static void tearDown(){driver.quit();}



}
