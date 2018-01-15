package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends Page {

    @FindBy(xpath = ".//*[@class='gb_ab gbii']")
    public WebElement userProfileButton;

    @FindBy(xpath = ".//*[@class='gb_Cb']")
    public WebElement userProfile;

    @FindBy(xpath = ".//*[@class='CJ']")
    public WebElement moreButton;

    @FindBy(xpath = ".//*[@title='All Mail']")
    public WebElement allMailButton;

    @FindBy(xpath = ".//*[@gh='mtb']/div[1]/div[1]/div[1]/*[@role='button']/div[@class='J-J5-Ji J-JN-M-I-Jm']/span")
    public WebElement selectButton;

    @FindBy(xpath = ".//*[@data-tooltip='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = ".//*[@title='Trash']")
    public WebElement trashButton;

    @FindBy(xpath = ".//button[@name='ok']")
    public WebElement okButton;

    @FindBy(xpath = ".//*[@gh='mtb']/div[1]/div[1]/div[2]/div[1]")
    public WebElement deleteForeverButton;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public String getUserMail() {
        String userMail = userProfile.getText();
        return userMail;
    }

    public void userProfileButtonClick() {
        userProfileButton.click();
    }

    public void deleteMail(){
        try {
            clickOnElement(moreButton);
            waiter(allMailButton);
            clickOnElement(allMailButton);
            while (true) {
                clickOnElement(selectButton);
                if (deleteButton.isDisplayed()) {
                    clickOnElement(deleteButton);
                    waiter(okButton);
                    clickOnElement(okButton);
                } else {
                    System.out.println("Письма удалены с папки - Все письма;");
                    break;
                }
            }
        } catch (Exception e){
             System.out.println("Письма не удалены с папки - Все письма;");
        }
    }

    public void deleteTrash(){
        try {
            waiter(trashButton);
            clickOnElement(trashButton);
            while (true) {
                clickOnElement(selectButton);
                 if (deleteForeverButton.isDisplayed()) {
                    waitTime(100);
                     clickOnElement(deleteForeverButton);
                } else {
                    System.out.println("Письма удалены с папки - Корзина;");
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Письма не удалены с папки - Корзина;");
        }
    }
}

