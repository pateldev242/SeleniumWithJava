import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRadioButton extends BaseTest{
    @BeforeMethod
    public void beforeTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/radio-button");
    }
    @Test
    public void testRadioButton() throws InterruptedException {
        selectOption("Impressive");
        Thread.sleep(2000);
        selectOption("Yes");
        Thread.sleep(2000);
    }
    public void selectOption(String option){
        driver.findElement(By.xpath("//label[text() = '"+option+"']")).click();
    }
    @AfterMethod
    public void afterTest(){
        closeAllBrowser();
    }
}
