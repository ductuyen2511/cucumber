package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.ThankYouPage;
import support.BaseStep;

public class ThankYouSteps {

  ThankYouPage thankYouPage = BaseStep.getInstance().getThankYouPage();
  private final By LBL_THANK_YOU = By.cssSelector("h2.complete-header");
  @Then("I am on the thank you page")
  public void iAmOnTheThankYouPage() {
    thankYouPage.verifyTitlePage(LBL_THANK_YOU);
  }
}
