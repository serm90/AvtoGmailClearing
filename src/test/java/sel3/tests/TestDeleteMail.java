package sel3.tests;

import sel3.pages.Methods;
import org.testng.annotations.Test;

public class TestDeleteMail extends BeforeAfterTest{

    @Test
     public void loginTest() throws InterruptedException {

        Methods mailBox = new Methods(driver);

        //логин юзера
        mailBox.loginUser();

         //проверка подленности почтовика после входа
         mailBox.registrationTest();

         //удаление всех писем & чистка корзины
        mailBox.deleteAllMail();
        }

}
