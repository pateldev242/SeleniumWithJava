import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TestScrollUpDown extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://www.snapdeal.com");
    }
    @Test
    public void testScrollUpDown() {
        WebElement body = driver.findElement(By.xpath("//body"));
        body.sendKeys(Keys.CONTROL,Keys.END); // scroll to the bottom
        sleep(3);
        body.sendKeys(Keys.ARROW_UP);
        sleep(3);
        body.sendKeys(Keys.ARROW_UP);
        body.sendKeys(Keys.ARROW_UP);
        body.sendKeys(Keys.ARROW_UP);



    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
