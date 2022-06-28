package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.CommonSteps;

public class HomePage extends CommonSteps {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getTitlePage(By locator) {
        String title = getText(webDriver, locator);
        Assert.assertEquals("Verify title is display correctly", "PRODUCTS", title);
    }
}
