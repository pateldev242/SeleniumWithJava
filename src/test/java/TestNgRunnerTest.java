import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgRunnerTest extends BaseTest{

    @BeforeMethod
    public void initializeBrowser(){
        openBrowser("Chrome");
        openURL("https://google.com");
    }
    @Test
    public void launchBrowserAndURL(){
        if(driver.getTitle().equalsIgnoreCase("Google")){
            System.out.println("I am on Google Page");
        }else {
        System.out.println("I am not on Google Page");
    }
    }
    @AfterMethod
    public void destroyBrowsers(){
        closeAllBrowser();

    }

}
