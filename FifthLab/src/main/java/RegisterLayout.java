import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RegisterLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    MobileElement newregisterButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    MobileElement regEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    MobileElement regUsername;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    MobileElement regPass;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    MobileElement regPassConfirm;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    MobileElement regButton;


    public RegisterLayout(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void enterEmailUserPassword(String email,String user, String password) {
        newregisterButton.click();
        regEmail.sendKeys(email);
        regUsername.sendKeys(user);
        regPass.sendKeys(password);
        regPassConfirm.sendKeys(password);
        regButton.click();
    }

}