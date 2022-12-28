package support;

import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ThankYouPage;

public class BaseStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ThankYouPage thankYouPage;

    private CheckoutPage checkoutPage;
    private static BaseStep BASE_INSTANCE = null;

    public static BaseStep getInstance() {
        if (BASE_INSTANCE == null) {
            synchronized (BaseStep.class) {
                if (BASE_INSTANCE == null) {
                    BASE_INSTANCE = new BaseStep();
                }
            }
        }
        return BASE_INSTANCE;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public ThankYouPage getThankYouPage() {
        thankYouPage = new ThankYouPage(driver);
        return thankYouPage;
    }

    public CheckoutPage getCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}