package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class  LoginPage extends Page {

    @FindBy(xpath = ".//*[@id='identifierId']")
    public WebElement loginField;

    @FindBy(xpath = ".//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[@id='identifierNext']")
    public WebElement loginButton;

    @FindBy(xpath = ".//*[@id='passwordNext']")
    public WebElement loginButtonNext;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
        waitTime(1000);
    }

    public void clickLoginButton() {
        loginButton.click();

    }

    public void clickLoginButtonNext() {
        loginButtonNext.click();
    }

    public void loginIntoMail(String login, String password) {
        inputLogin(login);
        clickLoginButton();
        inputPassword(password);
        clickLoginButtonNext();
    }
}


