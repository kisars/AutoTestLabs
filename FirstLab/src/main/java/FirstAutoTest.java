import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class FirstAutoTest {
    public static void main(String[] args) {
        //using Safari Browser
        WebDriver driver = new SafariDriver();
        final String searchRequest = "4pda";
        final String expectedLink = "4pda.ru";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        System.out.println("Search page title is: " + driver.getTitle());
        //performing the search request
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchRequest);
        element.submit();
        //Waiting for performing a search request
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(searchRequest);
            }
        });
        System.out.println("Searching: " + driver.getTitle());
        //Locating the first suggestion element by it's xpath
        WebElement firstSuggestion = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite"));
        System.out.println("First element is - " + firstSuggestion.getText());
        //Check the result
        Boolean isEqual = firstSuggestion.getText().equals(expectedLink);
        Assert.assertTrue("Error: Result link is - " + firstSuggestion + ". Expected link : " + expectedLink , isEqual);
        System.out.println("Expected Link was: " + expectedLink);
        //Close the browser
        driver.quit();
    }
}


