import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestTakeScreenShot extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://www.snapdeal.com");
    }
    @Test (invocationCount = 2)
    public void testScrollUpDown() throws IOException {
        TakesScreenshot X = (TakesScreenshot) driver;
        File S = X.getScreenshotAs(OutputType.FILE);
        File location = new File("Screenshots/amazonpage.png");
        FileUtils.copyFile(S,location);
    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
