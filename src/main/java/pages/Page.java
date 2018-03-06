package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    public WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waiter(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

        } catch (TimeoutException e) {
            e.getMessage();
            System.out.println("Елемент " + webElement + " не отображается");
        }
    }

    public void clearTextField(WebElement element) {
        element.clear();
    }

    public MailPage goToMailPage() {
        return new MailPage(driver);
    }

    public void clickOnElement(WebElement webElement) {
        waiter(webElement);
        webElement.click();
    }
}





