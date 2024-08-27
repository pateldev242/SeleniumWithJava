import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class TestRobotClass_And_CommandControl extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/dragabble");
    }
    @Test
    public void testRobotClass() throws IOException {
        robotClass();                                   //Object is created in the BaseTest
        robot.keyPress((KeyEvent.VK_ALT));                  //Press Alter
        robot.keyPress(KeyEvent.VK_F4);                     //Press F4
        robot.keyRelease(KeyEvent.VK_F4);                   //Release F4
        robot.keyRelease((KeyEvent.VK_ALT));                //Release Alter

        String command = "chromedriver.exe";
        Runtime.getRuntime().exec("taskkill /f /im "+command+" /t");   //Command to quit the driver
        System.out.println("Driver.quit successfull");

    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
