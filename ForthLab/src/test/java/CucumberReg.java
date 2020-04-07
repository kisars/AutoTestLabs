import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CucumberReg {
    private WebDriver driver = new ChromeDriver();
    private Registerpage reg = new Registerpage(driver);
    @Given("^Register Page is open$")
    public void regPageOpen()
    {
        reg.openPage();
    }
    @When("^Enter Registration Login \"([^\"]*)\"$")
    public void enterRegLogin(String user)
    {
        reg.enterLogin(user);
    }

    @When("^Enter Registration Email \"([^\"]*)\"$")
    public void enterRegEmail(String email)
    {
        reg.enterEmail(email);
    }

    @When("^Enter Registration Password \"([^\"]*)\"$")
    public void enterRegPass(String pass)
    {
        reg.enterPassword(pass);
    }

    @When("^Enter Confirm Password \"([^\"]*)\"$")
    public void enterRegConfPass(String pass) { reg.enterConfPassword(pass); }

    @Then("^Registration is Successful$")
    public void tryRegSucccess()
    {
        reg.assertRegSuccess();
        driver.quit();
    }

    @Then("^Registration is Failed$")
    public void tryRegFail()
    {
        reg.assertRegFail();
        driver.quit();
    }

}
