package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageButton {

    public WebDriver driver;

    public PageButton(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='identifierId']")
    public WebElement loginField;

    @FindBy(xpath = ".//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[@id='identifierNext']")
    public WebElement loginButton;

    @FindBy(xpath = ".//*[@id='passwordNext']")
    public WebElement loginButtonNext;

    @FindBy(xpath = ".//*[@class='gb_bb gbii']")
    public WebElement userProfileButton;

    @FindBy(xpath = ".//*[@class='gb_Db']")
    public WebElement userProfile;

    @FindBy(xpath = ".//*[@class='CJ']")
    public WebElement moreButton;

    @FindBy(xpath = ".//*[@title='All Mail']")
    public WebElement allMailButton;

    @FindBy(xpath = ".//*[@gh='mtb']/div[1]/div[1]/div[1]/*[@role='button']/div[@class='J-J5-Ji J-JN-M-I-Jm']")
    public WebElement selectButton;

    @FindBy(xpath = ".//*[@data-tooltip='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = ".//*[@title='Trash']")
    public WebElement trashButton;

    @FindBy(xpath = ".//button[@name='ok']")
    public WebElement okButton;

    @FindBy(xpath = ".//*[@class='TC']")
    public WebElement emptyInBox;

    @FindBy(xpath = ".//*[@gh='mtb']/div[1]/div[1]/div[2]/div[1]")

    public WebElement deleteForeverButton;

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

    public String getUserMail() {
        String userMail = userProfile.getText();
        return userMail;
    }

    public void buttonMore() throws InterruptedException {
        moreButton.click();
        Thread.sleep(1000);
    }

    public void buttonAllMail() throws InterruptedException {
        allMailButton.click();
        Thread.sleep(1000);
    }

    public void userProfileButtonClick() {
        userProfileButton.click();
    }

    public void clickSelect() throws InterruptedException {
        selectButton.click();
        Thread.sleep(1000);
    }

    public void clickDelete() throws InterruptedException {
        deleteButton.click();
        Thread.sleep(1000);
    }

    public void clickOk() throws InterruptedException {
        okButton.click();
        Thread.sleep(1000);
    }

    public void clickTrash() throws InterruptedException {
        trashButton.click();
        Thread.sleep(1000);
    }

    public void ClickDeleteForever() throws InterruptedException {
        deleteForeverButton.click();
        Thread.sleep(3000);
    }

}
