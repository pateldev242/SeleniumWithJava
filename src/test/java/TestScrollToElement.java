import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScrollToElement extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://www.snapdeal.com");
    }
    @Test
    public void testScrollUpDown() {
        actionsClass();
        WebElement element = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
        actions.moveToElement(element).build().perform();
        sleep(5);
        element = driver.findElement(By.xpath("//span[text()='Hobbies']"));
        actions.moveToElement(element).build().perform();
        sleep(5);



    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
