package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import support.BaseStep;

public class ThankYouSteps {

    BaseStep baseStep = BaseStep.getInstance();
    By LBL_THANK_YOU = By.cssSelector("h2.complete-header");

    @Then("I am on the thank you page")
    public void iAmOnTheThankYouPage() {
        baseStep.getThankYouPage().verifyTitlePage(LBL_THANK_YOU);
    }
}
