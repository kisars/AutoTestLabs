import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    static AppiumDriver driver;
    private LoginLayout loginLayout;
    private RegisterLayout registerLayout;
    private AddExpenseLayout addExpenseLayout;
    private ExpenseLayout expenseLayout;
    private static final String login = "hello";
    private static final String email = "hello@sad.ru";
    private static final String pass = "hello123";
    private static final String title = "hello";
    private static final String sum = "100";
    private static final String date = "01/01/20";
    private static final String category = "something";
    @BeforeClass
    public static void prepareTest() throws Exception {

        URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_29");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Ars\\IdeaProjects\\AppiumTest\\app-debug.apk");


        System.out.println("Step 1. Create new driver");
        driver = new AndroidDriver(serverURL, capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 30);

    }

    @Before
    public void initPageObject() {
        driver.launchApp();
        loginLayout = new LoginLayout(driver);
        registerLayout = new RegisterLayout(driver);
        addExpenseLayout = new AddExpenseLayout(driver);
        expenseLayout = new ExpenseLayout(driver);
    }
    @After
    public void closeApp() {
        driver.closeApp();
    }

    @Test
    public void testRegistration() throws InterruptedException {
        registerLayout.enterEmailUserPassword(email,login,pass);
        Assert.assertTrue(loginLayout.signInButton.isDisplayed());
        Thread.sleep(1000);

    }
    @Test
    public void testLogin() throws InterruptedException {
        registerLayout.enterEmailUserPassword(email,login,pass);
        loginLayout.enterEmailAndPassword(email, pass);
        Assert.assertTrue(addExpenseLayout.newexpenseButton.isDisplayed());
        Thread.sleep(1000);
    }
    @Test
    public void testAddExpense() throws InterruptedException {
        registerLayout.enterEmailUserPassword(email,login,pass);
        loginLayout.enterEmailAndPassword(email, pass);
        addExpenseLayout.addExpense();
        expenseLayout.fillExpense(title,sum,date,category);
        expenseLayout = new ExpenseLayout(driver);
        Thread.sleep(1000);
        Assert.assertTrue(addExpenseLayout.newexpenseButton.isDisplayed());
    }
}
