package sel3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page{

    public WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitTime(long millis){
        try{
            Thread.sleep(millis);
        }catch (Exception e){}
    }

    public MailPage goToMailPage(){
        return new MailPage(driver);
    }
}
