package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WisiwyngPage {
    private WebDriver driver;
    private String editorIFrameId = "mce_0_ifr";
    private By contentArea = By.id("tinymce");

   // private By decreasedIndentButton = By.cssSelector("#indentation button");
    private By decreasedIndentButton = By.xpath("//button[@title='Increase indent']");
  // private By decreasedIndentButton = By.xpath("//button[@title='Increase indent']//span[@class='tox-icon tox-tbtn__icon-wrap']//*[name()='svg']");

    public WisiwyngPage(WebDriver driver){
        this.driver = driver;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIFrameId);
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(contentArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(contentArea).sendKeys(text);
        switchToMainArea();
    }
    public void decreaseIndention(){
        driver.findElement(decreasedIndentButton).click();
    }
     public String getTextFromEditor(){
         switchToEditArea();
         String text = driver.findElement(contentArea).getText();
         switchToMainArea();
         return text;
     }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

//    public void setContentArea(String content){
//        driver.findElement(contentArea).sendKeys(content);
//    }
}
