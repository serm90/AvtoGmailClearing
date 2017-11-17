package sel3.tests;

import org.testng.Assert;
import sel3.pages.*;
import org.testng.annotations.Test;

public class DeleteMailTest extends SettingsTest {

    MailPage mailPage = null;

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        //вход на почту
        loginPage.loginIntoMail(login, password);
        mailPage = loginPage.goToMailPage();

        //проверка входа на почтовик
        mailPage.userProfileButtonClick();
        String mailUser = mailPage.getUserMail();
        Assert.assertEquals(login, mailUser);

        //удаление всех писем & чистка корзины
        mailPage.deleteMail();
        mailPage.deleteTrash();
    }

}
