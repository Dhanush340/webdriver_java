package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanksPage {
    private WebDriver driver;
    //private By status = By.cssSelector("body:nth-child(2) div.container > h1:nth-child(2)");

    public ThanksPage(WebDriver driver){
        this.driver = driver;
    }
   // public String getAlertText(){
//        return driver.findElement(status).getText();
//    }
}
