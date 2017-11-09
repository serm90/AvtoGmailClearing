package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Methods extends PageButton {

    public WebDriver driver;
    PageButton pageButton = new PageButton(driver);

    public Methods(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String mail, String password) throws InterruptedException {
        try {
            inputLogin(mail);
            clickLoginButton();
            inputPassword(password);
            Thread.sleep(500);
            clickLoginButtonNext();
            System.out.println("Юзер залогинился;");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Юзер не залогинился;");
        }
    }

    public void registrationTest() throws InterruptedException {
        try {
            Thread.sleep(1000);
            userProfileButtonClick();
            String mailUser = getUserMail();
            Assert.assertEquals("testtaras1@gmail.com", mailUser);
            Thread.sleep(1000);
            System.out.println("Проверка подленности почтового ящика выполнена;");
        } catch (Exception e) {
            System.out.println("Проверка подленности почтового не ящика выполнена;");
        }
    }

    public void deleteMail() throws InterruptedException {
        try {
            while (true) {
                clickSelect();
                if (deleteButton.isDisplayed()) {
                    clickDelete();
                    clickOk();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Письма не удалены с папки - Все письма;");
        }
    }

    public void deleteTrash() throws InterruptedException {
        try {
            while (true) {
                clickSelect();
                if (deleteForeverButton.isDisplayed()) {
                    ClickDeleteForever();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Письма не удалены с папки - Корзина;");
        }
    }

    public void deleteAllMail() throws InterruptedException {
        try {
            buttonMore();
            buttonAllMail();
            deleteMail();
            clickTrash();
            deleteTrash();
            System.out.println("Писма удалены из почтового ящика.");
        } catch (Exception e) {
            System.out.println("Письма не удалились с почтового ящика.");
        }
    }
}


