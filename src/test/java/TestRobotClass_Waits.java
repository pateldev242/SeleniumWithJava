import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TestRobotClass_Waits extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://www.naukrigulf.com");
    }
    @Test
    public void testImplicitWait() throws IOException {
        clickOn("xpath", "//a[text()='Register']");
        clickOn("xpath", "//label[@class='resume-label']");
        sleep();
        StringSelection filename = new StringSelection    //file name already copied here
                ("C:\\Users\\Dev Patel\\Downloads\\AE-December-2019-16-Mec-B9");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filename, null);
        robotClass();                                   //Object is created in the BaseTest
        robot.keyPress((KeyEvent.VK_CONTROL));
        robot.keyPress((KeyEvent.VK_V));
        robot.keyRelease((KeyEvent.VK_V));
        robot.keyRelease((KeyEvent.VK_CONTROL));
        robot.keyPress(KeyEvent.VK_ENTER);
        WebElement uploadCheck = driver.findElement(By.xpath("//span[@class='upload-filename']"));
        softAssert();
        softAssert.assertTrue(uploadCheck.getText().contains("original"));
        softAssert.assertAll();
        System.out.println(uploadCheck.getText());

    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
