package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends Page {

    @FindBy(xpath = ".//*[@class='gb_db gbii']")
    public WebElement userProfileButton;

    @FindBy(xpath = ".//*[@class='gb_Ib']")
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

    @FindBy(xpath = ".//*[@gh='tm']/div/div[2]/div/span/div/span/span[2]")
    public WebElement numberOfMailLocator;

    @FindBy(xpath = ".//div[@gh='mtb']/..//div[@data-tooltip='Refresh']")
    public WebElement refreshButton;

    @FindBy(xpath = ".//*[@class='nU n1']/a[contains(text(),'Spam')]")
    public WebElement spamButton;

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

    //метод удаляет писма с папки ВСЕ ПИСЬМА
    public void deleteMail(){
        try {
            clickOnElement(moreButton);
            clickOnElement(allMailButton);
            while (numberOfMailLocator.isDisplayed()) {
                clickOnElement(selectButton);
                if (deleteButton.isDisplayed()) {
                    clickOnElement(deleteButton);
                    clickOnElement(okButton);
                    clickOnElement(refreshButton);
                }
            }
            System.out.println("Письма удалены с папки - Все письма;");
        } catch (Exception e){
            e.getMessage();
            System.out.println("Письма не удалены с папки - Все письма;");
        }
    }
    //метод очищает папку СПАМ
    public void deleteSpam(){
        try{
            clickOnElement(spamButton);
            while (numberOfMailLocator.isDisplayed()){
                clickOnElement(selectButton);
                if (deleteForeverButton.isDisplayed()){
                    clickOnElement(deleteForeverButton);
                    clickOnElement(refreshButton);
                }
            }
            System.out.println("Папка Спам - очищена;");
        }catch(Exception e){
                e.getMessage();
                System.out.println("Письма Спам - не очищена;");
            }
        }

    //метод удаляет писма с папки КОРЗИНА
    public void deleteTrash(){
        try {
            clickOnElement(trashButton);
            while (numberOfMailLocator.isDisplayed()) {
                clickOnElement(selectButton);
                 if (deleteForeverButton.isDisplayed()) {
                     clickOnElement(deleteForeverButton);
                     clickOnElement(refreshButton);
                }
            }
            System.out.println("Письма удалены с папки - Корзина;");
        } catch (Exception e){
            e.getMessage();
            System.out.println("Письма не удалены с папки - Корзина;");
        }
    }
}

