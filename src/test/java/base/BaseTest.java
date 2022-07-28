package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import pages.CompleteWebForm;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
   // protected EmailSentPage emailSentPage;

 //   protected CompleteWebForm completewebForm;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
//        driver.get("https://the-internet.herokuapp.com/");
//        //driver.get("https://formy-project.herokuapp.com/form");
        homePage = new HomePage(driver);
//
//        homePage = new HomePage(driver);
       // emailSentPage = new EmailSentPage(driver);
       // completewebForm = new CompleteWebForm(driver);

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }
    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
