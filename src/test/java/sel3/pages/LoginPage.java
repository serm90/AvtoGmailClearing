package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = ".//*[@id='identifierId']")
    public WebElement loginField;

    @FindBy(xpath = ".//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[@id='identifierNext']/content/span")
    public WebElement loginButton;

    @FindBy(xpath = ".//*[@id='passwordNext']/content/span")
    public WebElement loginButtonNext;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLoginButtonNext() {
        loginButtonNext.click();
    }
}
