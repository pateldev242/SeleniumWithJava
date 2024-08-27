import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicProgram{

    static WebDriver driver;    //Webdriver is an interface
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","F:\\Java\\FrameWork2024\\src\\test\\resources\\binaries\\chromedriver.exe");
        driver = new ChromeDriver();   // Runtime Polymorphism
    }
}
