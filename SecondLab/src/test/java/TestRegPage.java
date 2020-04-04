import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

public class TestRegPage {
    WebDriver driver = new ChromeDriver();
    Registerpage Reg = new Registerpage(driver);
    private String user = "test1";
    private String email = "test1@test.com";
    private String password = "uniquepass";
    @Test
    public void TestRegFunction()  {
        Reg.performReg(user,email,password);
        driver.quit();
    }
    @Test
    public void TestRegFailFunction()  {
        email="test";
        Reg.performWrongReg(user,email,password);
        driver.quit();
    }
}
