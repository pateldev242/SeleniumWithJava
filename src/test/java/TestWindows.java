import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestWindows extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
        openURL("https://demoqa.com/browser-windows");
    }
    @Test
    public void testWindow(){
        String mainWindow = driver.getWindowHandle();               //Get initial Window Handle
        clickOn("id","tabButton");                                //Click on tab which navigates to a new window
        Set<String> allWindows = driver.getWindowHandles();         //get all window handles in a Set(For Uniqueness)
        List<String> listWindows = new ArrayList<>(allWindows);     //convert to list (for Get method)
        driver.switchTo().window(listWindows.get(1));               //take driver to second window using get method
        System.out.println(driver.getCurrentUrl());                 //verify the url of second window
        driver.switchTo().window(mainWindow);                       //go back to the main window
        System.out.println(driver.getCurrentUrl());                 //verify the URL
    }
    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
