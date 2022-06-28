package support;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class BaseStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
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
}