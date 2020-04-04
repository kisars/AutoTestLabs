
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestLoginPage {
    WebDriver driver = new ChromeDriver();
    Loginpage login = new Loginpage(driver);
    private String user = "test";
    private String password = "uniquepass";

    @Test
    @Category(Categories.Logintests.class)
    public void TestLoginFunction()  {
        login.performLogin(user,password);
        driver.quit();
    }

    @Test
    @Category(Categories.Logintests.class)
    public void TestLoginFailFunction()  {
        password = "12345467";
        login.performWrongLogin(user,password);
        driver.quit();
    }
}
