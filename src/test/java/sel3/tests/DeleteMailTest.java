package sel3.tests;

import org.testng.Assert;
import sel3.pages.LoginPage;
import sel3.pages.MailPage;
import org.testng.annotations.Test;

public class DeleteMailTest extends BeforeAfterTest{

    @Test
     public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = new MailPage(driver);

        // регестрация юзера
         loginPage.inputLogin(login);
         loginPage.clickLoginButton();
         loginPage.inputPassword(password);
         loginPage.clickLoginButtonNext();

         //проверка входа на почтовик
         mailPage.userProfileButtonClick();
         String mailUser = mailPage.getUserMail();
         Assert.assertEquals(login, mailUser);

         //удаление всех писем & чистка корзины
         mailPage.deleteMail();
         mailPage.deleteTrash();
        }

}
