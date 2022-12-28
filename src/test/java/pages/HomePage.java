package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.CommonSteps;

public class HomePage extends CommonSteps {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyTitlePage(By locator) {
        String title = getText(webDriver, locator);
        Assert.assertEquals("Verify title is display correctly", "PRODUCTS", title);
    }

    public void addProductToCart(String btnCard) {
        WebElement element = webDriver.findElement(By.xpath(btnCard));
        element.click();
    }

    public void clickOnCartIcon(By icCart) {
        click(webDriver, icCart);
    }

    public void clickOnCheckoutButton(By btnCheckout) {
        click(webDriver, btnCheckout);
    }
}
