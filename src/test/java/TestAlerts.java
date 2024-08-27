import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAlerts extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/alerts");
    }
    @Test
    public void testFrames() throws InterruptedException {
       clickOn("id", "alertButton");
       Thread.sleep(2000);

       Alert alert = driver.switchTo().alert();              // Create a variable with alert interface
       alert.dismiss();                                      //alert hase 4 methods dismiss, enter-name, get text, confirm

    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
