import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssertions extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest() throws InterruptedException {
        openBrowser("Chrome");
        openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }
    @Test
    public void testFrames() throws InterruptedException {
        typeOn("name","username","Admin");
        typeOn("name", "password", "admin123");
        clickOn("xpath", "//button[@type='submit']");
        Thread.sleep(5000);
        String value = getTextOf("xpath", "//p[@class='oxd-userdropdown-name']");
        System.out.println(value);

        SoftAssert sA = new SoftAssert();
        sA.assertTrue(value.equalsIgnoreCase("Paul Collings"), "Not on correct page");
        sA.assertAll();              //This is important to write in the end
    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
