package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBox {

    public WebDriver driver;
    public MailBox(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


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

    public void deleteForever() throws InterruptedException {
        deleteForeverButton.click();
        Thread.sleep(3000);
    }

    public void deleteMail() throws InterruptedException {
        while (true) {
            clickSelect();

            if (deleteButton.isDisplayed()) {
                clickDelete();
                clickOk();
            } else {
                break;
            }
        }
    }

    public void deleteTrash() throws InterruptedException {
            while (true) {
                clickSelect();

                if(deleteForeverButton.isDisplayed()) {
                    deleteForever();
                }else{
                    break;
                }
            }
    }

}

