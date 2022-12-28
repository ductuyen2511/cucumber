package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.CommonSteps;

public class CheckoutPage extends CommonSteps {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTitlePage(By lblCheckoutPage) {
        String title = getText(webDriver, lblCheckoutPage);
        Assert.assertEquals("Verify title is display correctly", "CHECKOUT: YOUR INFORMATION", title);
    }

    public void inputFirstName(By txtFirstname, String fistName) {
        enterText(webDriver, txtFirstname, fistName);
    }

    public void inputLastName(By txtLastname, String lastName) {
        enterText(webDriver, txtLastname, lastName);
    }

    public void inputPostCode(By txtCode, String postCode) {
        enterText(webDriver, txtCode, postCode);
    }

    public void clickOnContinueButton(By btnContinue) {
        click(webDriver, btnContinue);
    }

    public void clickOnFinishButton(By btnFinish) {
        click(webDriver, btnFinish);
    }
}
