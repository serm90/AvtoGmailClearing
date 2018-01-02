package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page{

    public WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitTime(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void waiter (WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        boolean element = wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }

    public void clearTextField(WebElement element){
        element.clear();
    }

    public MailPage goToMailPage(){
        return new MailPage(driver);
    }

    public void clickOnElement (WebElement webElement){
        webElement.click();
    }
}
