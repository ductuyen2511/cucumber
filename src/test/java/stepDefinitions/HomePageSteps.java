package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.BaseStep;

public class HomePageSteps {
    BaseStep baseStep = BaseStep.getInstance();

    WebElement element = null;
    By LBL_HOMEPAGE = By.cssSelector("span.title");

    @Then("I am on the home page")
    public void iAmOnTheHomePage() {
        baseStep.getHomePage().getTitlePage(LBL_HOMEPAGE);
    }
}
