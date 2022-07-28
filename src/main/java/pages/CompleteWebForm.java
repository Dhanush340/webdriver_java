package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteWebForm {
    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By jobTitleField = By.id("job-title");
    private By highestLevelOfEdu = By.cssSelector("div.container form:nth-child(4) div.form-group div.input-group:nth-child(7) > div.col-sm-8.col-sm-offset-2:nth-child(2)");
            //By.id("job-radio-button-1");


    private By sex = By.id("checkbox-1");
    private By selectMenu = By.id("select-menu");
    private By selectMenuItem = By.id("select-menu");
    private By loginButton = By.cssSelector("div.container form:nth-child(4) div.form-group div.col-sm-4.col-sm-offset-2:nth-child(15) > a.btn.btn-lg.btn-primary");

    public CompleteWebForm(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setJobTitle(String jobTitle){
        driver.findElement(jobTitleField).sendKeys(jobTitle);
    }

    public void clickHighestLevelOfEdu(){
        driver.findElement(highestLevelOfEdu).click();
    }

    public ThanksPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new ThanksPage(driver);
    }
}
