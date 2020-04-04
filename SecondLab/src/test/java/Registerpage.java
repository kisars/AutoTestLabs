import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class Registerpage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private String url = "https://chat.kiselevaa.ru";

    public Registerpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(id = "name")
    private WebElement login;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "confirm-pass")
    private WebElement confPassword;

    private Registerpage enterLogin(String user)
    {
        login.sendKeys(user);
        return this;
    }
    private Registerpage enterEmail(String emails)
    {
        email.sendKeys(emails);
        return this;
    }
    private Registerpage enterPassword(String pass)
    {
        password.sendKeys(pass);
        password.submit();
        return this;
    }

    private Registerpage enterConfPassword(String pass)
    {
        confPassword.sendKeys(pass);
        confPassword.submit();
        return this;
    }

    private void openPage()
    {
        driver.get(url);
        Loginpage login = new Loginpage(driver);
        login.bReg.click();
    }

    private void assertRegSuccess()
    {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"login-card\"]/header/h2")).size() != 0);
    }
    private void assertRegFail()
    {
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"login-card\"]/div[1]/div[2]/label/div/div")).size() != 0);
    }
    public void performReg(String user,String emails, String pass) {
        openPage();
        enterLogin(user);
        enterEmail(emails);
        enterPassword(pass);
        enterConfPassword(pass);
        assertRegSuccess();
    }
    public void performWrongReg(String user,String emails, String pass) {
        openPage();
        enterLogin(user);
        emails="test";
        enterEmail(emails);
        enterPassword(pass);
        enterConfPassword(pass);
        assertRegFail();
    }
}
