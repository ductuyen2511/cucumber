package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtil;

public class ThankYouPage extends DriverUtil {

    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTitlePage(By lblThankYou) {
        String title = getText(webDriver, lblThankYou);
        Assert.assertEquals("Verify title is display correctly", "Thank you for your order!", title);
    }
}
