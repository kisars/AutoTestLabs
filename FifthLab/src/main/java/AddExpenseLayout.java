import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AddExpenseLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    MobileElement newexpenseButton;


    public AddExpenseLayout(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void addExpense() {
        newexpenseButton.click();
    }

}