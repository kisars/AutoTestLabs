import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.junit.Test;

public class TestLoginPage {
    WebDriver driver = new SafariDriver();
    Loginpage login = new Loginpage(driver,10);
    private String user = "test";
    private String password = "uniquepass";
    @Test
    public void TestLoginFinction()  {
        login.performLogin(user,password);
    }
}
