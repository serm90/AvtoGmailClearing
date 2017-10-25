package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBox {

    public MailBox(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")
    public WebElement userProfileButton;

    @FindBy(xpath = ".//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div/div[2]")
    public WebElement userProfile;

    @FindBy(xpath = ".//*[@id=':2w']/div[1]/span/div")
    public WebElement userDeleteMail;

    @FindBy(id = "login__logout")
    public WebElement buttonLogout;

    public String getUserMail() {
        String userMail = userProfile.getText();
        return userMail;
    }

    public void userDeleteMail() {

        userDeleteMail.click();
    }

    public void userLogout() {
        buttonLogout.click();
    }

    public void userProfileButton() {
        userProfileButton.click();
    }
}
