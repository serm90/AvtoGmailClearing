package pages;

import org.testng.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    //общие методы для работы на страницах
    public WebDriver driver;


    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //метод ожидает пока елемент станет нажимамым
    public void waiter(WebElement webElement) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            e.getMessage();
            System.out.println("Елемент " + webElement + " не отображается");
        }
    }

    //метод очищает поле перед вводом данных
    public void clearTextField(WebElement element) {
        element.clear();
    }

    public MailPage goToMailPage() {
        return new MailPage(driver);
    }

    //метод нажимает на элемент
    public void clickOnElement(WebElement webElement) {
        waiter(webElement);
        webElement.click();
    }

    //проверка присутсвия в указанном месте почтовика
    public void validator(String pageTitle) {

        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            boolean titleValid = wait.until(ExpectedConditions.titleContains(pageTitle));
            if (titleValid) {
                System.out.println("Тест на странице: " + pageTitle);
            }
        } catch (TimeoutException te) {
            System.out.println("Не верная страница, ожидали увидеть: " + pageTitle + " оказались на: " + driver.getTitle());
            Assert.fail();
        }
    }
    }










