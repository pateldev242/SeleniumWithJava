import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.List;

public class TestTableAndGrabValues extends BaseTest{
    @BeforeMethod
    public void beforeWindowTest(){
        openBrowser("Chrome");
    }
    @Test
    public void testFetchTableData() {
        openURL("https://www.w3schools.com");
        clickOn("xpath", "//a[text()='HTML']");
        clickOn("xpath", "//*[@id=\"leftmenuinnerinner\"]/a[19]");
        clickOn("xpath", "//*[@id=\"leftmenuinnerinner\"]/div[4]/a[1]");
        List<WebElement> elementsInRow = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        System.out.println(elementsInRow.size());
        for (int i = 2; i<=elementsInRow.size(); i++){
            System.out.println("---");
            List<WebElement>  elementsInCol = driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td"));
            System.out.println("columns "+elementsInCol.size());
            for (int j=1;j<=elementsInCol.size();j++){
                WebElement  colAndRowElement = driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]"));
                System.out.print(colAndRowElement.getText()+" | ");
            }
        }
    }
    @Test
    public void codeForCalenderSelection(){
        openURL("https://www.goibibo.com/");
        if(driver.findElement(By.xpath("//span[@class='logSprite icClose']")).isDisplayed()){
            clickOn("xpath", "//span[@class='logSprite icClose']");      // Advertise to ignore
        }
        clickOn("xpath", "//span[text()='Departure']");
        List<WebElement> rows = driver.findElements(By.xpath(
                "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Week']"));

        for (int rowIndex=1;rowIndex<rows.size();rowIndex++){
            List<WebElement> columns = driver.findElements(By.xpath(
                    "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Week']["+rowIndex+"]//div"));

            for(int columnIndex=1;columnIndex<=columns.size();columnIndex++){
                WebElement day = driver.findElement(By.xpath(
                        "//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Week']["+rowIndex+"]//div["+columnIndex+"]"));
                System.out.print(day.getText()+":");

                if(day.getText().equalsIgnoreCase("20")){
                    day.click();
                    sleep();
                    robotClass();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    sleep();
                    break;
                }
            }

        }
    }

    @AfterMethod
    public void afterWindowTest(){
        closeAllBrowser();
    }
}
