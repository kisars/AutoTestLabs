import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import java.io.File;
public class TestLoginPage {
    WebDriver driver = new ChromeDriver();
    Loginpage login = new Loginpage(driver);
    private String user = "test";
    private String password = "uniquepass";
    @Test
    public void TestLoginFunction()  {
        login.performLogin(user,password);
        driver.quit();
    }
    @Test
    public void TestLoginFailFunction()  {
        password = "12345467";
        login.performWrongLogin(user,password);
        driver.quit();
    }
}
