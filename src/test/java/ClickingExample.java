import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickingExample extends BaseTest {
    @BeforeMethod
    public void beforeClickTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/buttons");
    }
    @Test
    public void singleClicks(){
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
    }
    @Test
    public void doubleClick() throws InterruptedException {
        WebElement buttonDoubleClick = driver.findElement(By.id("doubleClickBtn"));
        WebElement buttonRightClick = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonDoubleClick).build().perform();
        Thread.sleep(2000);
        actions.contextClick(buttonRightClick).build().perform();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void afterClickTest(){
        closeAllBrowser();
    }
}
