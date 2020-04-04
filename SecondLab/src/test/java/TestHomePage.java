import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

public class TestHomePage {
    WebDriver driver = new ChromeDriver();
    Homepage home = new Homepage(driver);
    @Test
    public void TestSendFunction()  {
        home.sendMessage();
        driver.quit();
    }
    @Test
    public void TestStatusChangeFunction()  {
        home.changeStatus();
        driver.quit();
    }
}
