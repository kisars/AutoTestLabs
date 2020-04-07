import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homepage {

    private WebDriver driver;
    private String url = "https://chat.kiselevaa.ru";

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @FindBy(xpath = "//*[@id=\"rocket-chat\"]/aside/div[2]/ul[2]/li/a/div[2]/div[1]/div[1]/div/div[2]")
    public WebElement bMenu;

    @FindBy(xpath = "//*[@id=\"chat-window-GENERAL\"]/div/div/footer/div/label/textarea")
    public WebElement chatInput;

    @FindBy(xpath = "//*[@id=\"rocket-chat\"]/aside/header/div[1]/div[1]/img")
    public WebElement icon;

    @FindBy(xpath = "//*[@id=\"rocket-chat\"]/aside/header/div[1]/div[2]")
    public WebElement status;

    public void openPage()
    {
        driver.get(url);
        Loginpage login = new Loginpage(driver);
        login.performLogin("test","uniquepass");
        bMenu.click();
    }

    public void checkMessage()
    {
        WebElement message = driver.findElement(By.xpath("//*[@id=\"chat-window-GENERAL\"]/div/div/div[3]/div[3]/ul"));
        List<WebElement> messages = message.findElements(By.tagName(("li")));
        String s = messages.get(messages.size()-1).getText();

        Assert.assertTrue(s.contains("Hello everybody!This is a test message,please don't reply!"));
    }
    public boolean checkStatus() {
        String classes = status.getAttribute("class");
       if (classes.contains("busy"))
                return true;
        Assert.assertTrue(false);
        return false;
    }
    public void changeStatus()
    {
        icon.click();
        WebElement change = driver.findElement(By.xpath("/html/body/div[8]/div/div/ul[2]/li[3]/span[2]"));
        change.click();
    }
    public void sendMessage() {
        chatInput.sendKeys("Hello everybody!This is a test message,please don't reply!",Keys.ENTER);
        chatInput.sendKeys(Keys.ENTER);
    }
}
