package sel3.tests;

import org.testng.Assert;
import sel3.pages.LoginPage;
import sel3.pages.MailBox;
import org.testng.annotations.Test;

public class TestDeleteMail extends BeforeAfterTest{



    @Test
     public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        MailBox mailBox = new MailBox(driver);

        // регестрация юзера
         loginPage.inputLogin("testtaras1@gmail.com");
         loginPage.clickLoginButton();
         loginPage.inputPassword("12345678azx");
         Thread.sleep(500);
         loginPage.clickLoginButtonNext();

         //проверка подленности почтовика
         Thread.sleep(1000);
         mailBox.userProfileButtonClick();
         String mailUser = mailBox.getUserMail();
         Assert.assertEquals("testtaras1@gmail.com", mailUser);
         Thread.sleep(1000);

         //переход во все письма
         mailBox.buttonMore();
         mailBox.buttonAllMail();

         //удаление всех писем & чистка корзины
         mailBox.deleteMail();
         mailBox.clickTrash();
         mailBox.deleteTrash();
        }



}
