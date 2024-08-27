import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample extends BaseTest {
    @BeforeMethod
    public void beforeTextBoxText(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/text-box");
    }
    @Test
    public void testTextBox(){
        WebElement textBoxName = driver.findElement(By.id("userName"));
        textBoxName.click();
        textBoxName.clear();
        textBoxName.sendKeys("Dev Patel");
    }
    @Test
    public void testClearTextBox() throws InterruptedException {
        WebElement textBoxAddress = driver.findElement(By.id("currentAddress"));
        Actions actions = new Actions(driver);
        actions.sendKeys(textBoxAddress, "Gujarat").build().perform();
        actions.sendKeys(textBoxAddress, "\nIndia").build().perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterTextTest(){
        closeAllBrowser();
    }
}
