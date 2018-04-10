package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {

    @FindBy(xpath = ".//*[@class='gb_db gbii']")
    public WebElement userProfileButton;

    @FindBy(xpath = ".//*[@class='gb_Ib']")
    public WebElement userProfile;

    @FindBy(xpath = ".//*[@class='CJ']")
    public WebElement moreButton;

    @FindBy(xpath = ".//*[@class='CJ']")
    public WebElement lessButton;

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

    @FindBy(xpath = ".//*[@title='Spam']")
    public WebElement spamButton;

    private String allMailPageTitile = "All Mail";
    private String spamPageTitile = "Spam";
    private String trashPageTitile = "Trash";

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
            validator(allMailPageTitile);

            while (waitForNumber(numberOfMailLocator)) {
                clickOnElement(selectButton);
                if (deleteButton.isDisplayed()) {
                    clickOnElement(deleteButton);
                    clickOnElement(okButton);
                    clickOnElement(refreshButton);
                }
            }
            System.out.println("Письма удалены с папки - Все письма;");

        }
        catch (Exception e){
            e.getMessage();
            System.out.println("Письма не удалены с папки - Все письма;");
        }
    }
    //метод очищает папку СПАМ
    public void deleteSpam(){
        try{
            clickOnElement(lessButton);
            clickOnElement(moreButton);
            clickOnElement(spamButton);
            validator(spamPageTitile);
            while (waitForNumber(numberOfMailLocator)){
                clickOnElement(selectButton);
                if (deleteForeverButton.isDisplayed()){
                    clickOnElement(deleteForeverButton);
                    clickOnElement(refreshButton);
                }
            }
            System.out.println("Папка Спам - очищена;");
        }catch(Exception e){
                e.getMessage();
                System.out.println("Папка Спам - не очищена;");
            }
        }

    //метод удаляет писма с папки КОРЗИНА
    public void deleteTrash(){
        try {
            clickOnElement(lessButton);
            clickOnElement(moreButton);
            clickOnElement(trashButton);
            validator(trashPageTitile);
            while (waitForNumber(numberOfMailLocator)) {
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

    //метод проверяет отображение писем в папаках
    public boolean waitForNumber(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try{
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        }catch (TimeoutException te){
        return false;
        }
        return true;

    }
}

