import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
public class ExpenseLayout {
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    MobileElement title;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    MobileElement summ;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    MobileElement date;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    MobileElement category;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    MobileElement saveButton;

    public ExpenseLayout(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void fillExpense(String titles,String summs,String dates,String categorys){
        title.sendKeys(titles);
        summ.sendKeys(summs);
        date.sendKeys(dates);
        category.sendKeys(categorys);
        saveButton.click();
    }
}
