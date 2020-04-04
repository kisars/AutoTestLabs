import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Categories.class)
@Categories.IncludeCategory(SuiteCategories.Logintests.class)
@Suite.SuiteClasses({TestLoginPage.class})
public class LoginSuite {
}
