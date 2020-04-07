
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberLogin {
    private WebDriver driver = new ChromeDriver();
    private Loginpage login = new Loginpage(driver);
    @Given("^Login Page is open$")
    public void loginPageOpen()
    {
        login.openPage();
    }

    @When("^Enter Login \"([^\"]*)\"$")
    public void enterLogin(String user)
    {
        login.enterLogin(user);
    }

    @When("^Enter Password and Log in \"([^\"]*)\"$")
    public void enterPass(String pass)
    {
        login.enterPassword(pass);
    }

    @Then("^Login is Failed$")
    public void tryLogInFail()
    {
        login.assertLoginFail();
        driver.quit();
    }
    @Then("^Login is Successful$")
    public void tryLogInSucccess()
    {
        login.assertLoginSuccess();
        driver.quit();
    }
}
