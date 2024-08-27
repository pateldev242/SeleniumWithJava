import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest extends BaseTest{
    @BeforeMethod
    public void initialize(){
        openBrowser("chrome");
        openURL("https://www.google.com");
    }
    @Test
    public void testingGoogle() throws InterruptedException {
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();
        Thread.sleep(5000);
    }
    @Test
    public void testingGooglePartialLinkText() throws InterruptedException {
        WebElement aboutPartialLink = driver.findElement(By.partialLinkText("Search works"));
        aboutPartialLink.click();
        Thread.sleep(5000);
    }
    @Test
    public void testingGoogleFindALink() throws InterruptedException {
        WebElement aboutTagA = driver.findElement(By.tagName("a"));
        System.out.println(aboutTagA.getText());
        aboutTagA.click();
        Thread.sleep(5000);
    }
    @Test
    public void testingGoogleFindAllLinksByTag() throws InterruptedException {
        List<WebElement> listTagA = driver.findElements(By.tagName("a"));       //Store all elements in a lIst
        for(int i=0;i<listTagA.size();i++){                                     //Use for loop to check all elements
            WebElement element = listTagA.get(i);                               // Store each Web element
            System.out.println(element.getText());                              // Print the Text of the element
            if(element.getText().equalsIgnoreCase("Privacy")){       //Check the element has this text
                element.click();                                                //click on that element
                driver.navigate().back();                                       //go back to the initial page
            }
        }
        Thread.sleep(5000);
    }
    @Test
    public void testingGoogleFindAllImages() {
        List<WebElement> listOfImages = driver.findElements(By.tagName("img"));// Tag name for images on web application is img
        for(int i=0;i<listOfImages.size();i++){
            WebElement image = listOfImages.get(i);
            System.out.println(image.getAttribute("scr"));                  //src is the attribute to search particular image
        }
    }
    @AfterMethod
    public void afterTest(){
        closeAllBrowser();
    }
}
