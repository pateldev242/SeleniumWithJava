import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    public void openBrowser(String browserName) {            // It opens the required browser as per specific test
        if (browserName.equalsIgnoreCase("chrome")) {    //check for chrome
            System.setProperty("webdriver.chrome.driver", "F:\\Java\\FrameWork2024\\src\\test\\resources\\binaries\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {     //check for edge
            System.setProperty("webdriver.edge.driver", "F:\\Java\\FrameWork2024\\src\\test\\resources\\binaries\\edgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();             // this will maximize the window
       // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.close();           // to close a window
    }

    public void openURL(String URL) {
        driver.navigate().to(URL);          // using "navigate to" to move forward and back in the browser.
       // driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
    }

    public void closeAllBrowser() {
        driver.quit();
    }   // kill the driver
    public static String readPropsTestData(String fileName, String key){   // to read test data from object repository
        try {
            FileInputStream F = new FileInputStream("TestData/"+fileName+"_testData.properties");
            Properties P = new Properties();
            P.load(F);
            return P.getProperty(key);
        } catch (Exception e) {

        }
        return null;
    }

    FluentWait F;
    public void fluentWaitMethod() {       // explicit wait for an element to be visible or clickable
        F = new FluentWait<>(driver);
        F.withTimeout(Duration.ofSeconds(30));        // it will wait for 30 seconds
        F.pollingEvery(Duration.ofMillis(2000));     // it will check for element every 2 seconds till 30 seconds
        F.ignoring(StaleElementReferenceException.class);
    }

    public void clickOn(String locator, String path) {   // Will add all the locators later after completing all necessary actions
        fluentWaitMethod();
        WebElement element;
        switch (locator) {
            case ("xpath"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.click();
                break;
            case ("id"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.click();
                break;
            case ("name"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.click();
                break;
        }
    }

    public void typeOn(String locator, String path, String text) {
        fluentWaitMethod();
        WebElement element;
        switch (locator) {
            case ("xpath"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.clear();
                element.sendKeys(text);
                break;
            case ("id"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.clear();
                element.sendKeys(text);
                break;
            case ("name"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                actionsClass();
                actions.moveToElement(element).build().perform();
                element.clear();
                element.sendKeys(text);
                break;
        }
    }

    public String getTextOf(String locator, String path) {
        fluentWaitMethod();
        String value = "";
        WebElement element;
        switch (locator) {
            case ("xpath"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                value = element.getText();
                break;
            case ("id"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                value = element.getText();
                break;
            case ("name"):
                element = (WebElement) F.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                value = element.getText();
                break;
        }
        return value;
    }

    public void sleep(int seconds) {   // method override to add specific time
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.Sleep exception");
        }
    }
    public void sleep(){            // default 2 second wait
        try {Thread.sleep(2000);}
        catch (InterruptedException e){System.out.println("Thread.Sleep exception");}
    }

    static Robot robot;
    public void robotClass() {    // creating object and handling exception
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    static SoftAssert softAssert;

    public void softAssert() {
        softAssert = new SoftAssert();
    }
    Actions actions;
    public void actionsClass(){
        actions= new Actions(driver);
    }

    public void printScreen(String fileName) {            // screenshot naming and storing
        try {
            TakesScreenshot X = (TakesScreenshot) driver;
            File S = X.getScreenshotAs(OutputType.FILE);
            File location = new File("Screenshots/"+fileName+".png");
            FileUtils.copyFile(S, location);
    }catch (Exception e){
            System.out.println("ScreenShot Failure");
        }
    }
}
