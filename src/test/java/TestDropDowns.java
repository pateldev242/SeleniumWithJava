import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDropDowns extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/select-menu");
    }
    @Test
    public void testDropDowns() throws InterruptedException {
        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select= new Select(element);                   //When tag name is "select". This is an old options list
        select.selectByIndex(2);
        sleep(2);
        select.selectByValue("5");
        sleep(2);
        select.selectByVisibleText("Black");
        sleep(2);
    }
    @Test
    public void testDropDowns2() throws InterruptedException {
        clickOn("id", "selectOne");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click(element).sendKeys("Group 1, option 2").sendKeys(Keys.ENTER)
                .build().perform();
    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
