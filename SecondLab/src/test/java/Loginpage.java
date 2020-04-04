import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class Loginpage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private String url = "https://chat.kiselevaa.ru";

    public Loginpage(WebDriver driver, long timeOutInSeconds) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @FindBy(id = "emailOrUsername")
    private WebElement login;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "submit-form")
    private WebElement bSubmitLogin;

    @FindBy(id = "login-card")
    public WebElement bReg;

    private Loginpage enterLogin(String user)
    {
        login.sendKeys(user);
        return this;
    }
    private Loginpage enterPassword(String pass)
    {
        password.sendKeys(pass);
        password.submit();
        return this;
    }

    private void openPage()
    {
        driver.get(url);
    }

    private void assertLoginSuccess()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }
    public void performLogin(String user, String pass) {
        openPage();
        enterLogin(user);
        enterPassword(pass);
        assertLoginSuccess();
    }
}
