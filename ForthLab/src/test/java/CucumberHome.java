import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHome {
    private WebDriver driver = new ChromeDriver();
    private Homepage home = new Homepage(driver);
    @Given("^Home Page is open$")
    public void loginPageOpen()
    {
        home.openPage();
    }

    @When("^Send message$")
    public void sendMessage()
    {
        home.sendMessage();
    }
    @When("^Change status$")
    public void changeStatus()
    {
        home.changeStatus();
    }

    @Then("^Message has been sent successfully$")
    public void tryLogInFail()
    {
        home.checkMessage();
        driver.quit();
    }
    @Then("^Status has been changed successfully$")
    public void tryLogInSucccess()
    {
        home.checkStatus();
        driver.quit();
    }
}