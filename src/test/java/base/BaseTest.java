package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import pages.CompleteWebForm;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;




public class BaseTest {

   // private WebDriver driver; //for 1 to 12 chapters
    private EventFiringWebDriver driver; //for 12 chapters
    protected HomePage homePage;
   // protected EmailSentPage emailSentPage;

 //   protected CompleteWebForm completewebForm;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
      //  driver = new ChromeDriver(); //for 1 to 12 chapters

//        driver = new EventFiringWebDriver(new ChromeDriver());//chapter 13
//        driver.register(new EventReporter());

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions())); //chapter 14
        driver.register(new EventReporter());
//Alternately, this can be done as:
//driver = new ChromeDriver(getChromeOptions());


       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
//        driver.get("https://the-internet.herokuapp.com/");
//        //driver.get("https://formy-project.herokuapp.com/form");

//
//        homePage = new HomePage(driver);
       // emailSentPage = new EmailSentPage(driver);
       // completewebForm = new CompleteWebForm(driver);

        setCookie(); // cookies ch14

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

//    @AfterMethod
//    public void takeScreenshot(){
//        var camera = (TakesScreenshot)driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//      //  System.out.println("Screenshot taken: " + screenshot.getAbsolutePath()); // find absolute path where image saved
//        try {
//            Files.move(screenshot, new File("resources/screenshots/test.png"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }


    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/"+ result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
       // options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("Dtest", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
