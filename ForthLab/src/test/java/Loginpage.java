import org.junit.Assert;
import org.openqa.selenium.By;
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

    public Loginpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(id = "emailOrUsername")
    private WebElement login;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "submit-form")
    private WebElement bSubmitLogin;

    @FindBy(xpath = "//*[@id=\"login-card\"]/div[2]/button[3]")
    public WebElement bReg;

    public Loginpage enterLogin(String user)
    {
        login.sendKeys(user);
        return this;
    }
    public Loginpage enterPassword(String pass)
    {
        password.sendKeys(pass);
        password.submit();
        return this;
    }

    public void openPage()
    {
        driver.get(url);
    }

    public void assertLoginSuccess()
    {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"rocket-chat\"]/aside/div[2]/ul[2]/li/a/div[2]/div[1]/div[1]/div/div[2]") ).size() != 0);
    }
    public void performLogin(String user, String pass) {
        openPage();
        enterLogin(user);
        enterPassword(pass);
        assertLoginSuccess();
    }
    public void assertLoginFail()
    {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"toast-container\"]") ).size() != 0);
    }
    public void performWrongLogin(String user, String pass) {
        openPage();
        enterLogin(user);
        enterPassword(pass);
        assertLoginFail();
    }

}
