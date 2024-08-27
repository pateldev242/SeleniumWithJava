import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHoverActiveMenu extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/dragabble");
    }
    @Test
    public void testDragDrop() throws InterruptedException {
       WebElement draggableElement = driver.findElement(By.id("dragBox"));
       Actions actions = new Actions(driver);
       actions.dragAndDropBy(draggableElement, 20, 40).build().perform();
       sleep(5);
    }
    @Test
    public void testDragToSpecificElement() throws InterruptedException {
        clickOn("id", "draggableExample-tab-axisRestriction");
        sleep(1);
        Actions actions = new Actions(driver);
        WebElement xAxis = driver.findElement(By.id("restrictedX"));
        WebElement yAxis = driver.findElement(By.id("restrictedY"));
        actions.dragAndDrop(xAxis, yAxis).build().perform();
        sleep(2);
    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
