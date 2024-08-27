import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestFrames extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/frames");
    }
    @Test
    public void testFrames(){
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.id("sampleHeading"));
        System.out.println(element.getText());
        driver.switchTo().defaultContent();
        String Verification = driver.findElement(By.xpath("//span[text()='Modal Dialogs']")).getText();
        System.out.println(Verification);

    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
