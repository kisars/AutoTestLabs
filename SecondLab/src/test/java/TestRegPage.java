import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.junit.Test;

public class TestRegPage {
    WebDriver driver = new SafariDriver();
    Registerpage Reg = new Registerpage(driver,10);
    private String user = "test1";
    private String email = "test1@test.com";
    private String password = "uniquepass";
    @Test
    public void TestRegFunction()  {
        Reg.performReg(user,email,password);
    }
}
