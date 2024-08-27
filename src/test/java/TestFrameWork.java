import org.example.PropertiesFIleReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFrameWork extends BaseTest{
    @BeforeMethod
    public void initializeFrameWork(){
        openBrowser("chrome");
        openURL("https://opensource-demo.orangehrmlive.com");
    }
    @Test
    public void testFramework(){
        String testData_Username = BaseTest.readPropsTestData("OrangeHRM", "orangeHRM.validate_Username.username");
        String testData_Password = BaseTest.readPropsTestData("OrangeHRM", "orangeHRM.validate_Username.password");
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        sleep();
        typeOn("name","username",testData_Username);
        typeOn("name", "password", testData_Password);
        userName.sendKeys(testData_Password);

        driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    }
    @AfterMethod
    public void completeTheTesting(){
        closeAllBrowser();
    }
}
