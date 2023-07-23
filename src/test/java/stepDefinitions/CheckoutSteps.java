package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CheckoutPage;
import support.BaseStep;

public class CheckoutSteps {
  CheckoutPage checkoutPage = BaseStep.getInstance().getCheckoutPage();
  private final By LBL_CHECKOUT_PAGE = By.cssSelector("span.title");
  private final By TXT_FIRSTNAME = By.cssSelector("[id='first-name']");
  private final By TXT_LASTNAME = By.cssSelector("[id='last-name']");
  private final By TXT_CODE = By.cssSelector("[id='postal-code']");
  private final By BTN_CONTINUE = By.cssSelector("input.submit-button");
  private final By BTN_FINISH = By.cssSelector("button.cart_button");

  @Then("I am on the check out page")
  public void iAmOnTheCheckOutPage() {
    checkoutPage.verifyTitlePage(LBL_CHECKOUT_PAGE);
  }

  @When("I input first name is {string}")
  public void iInputFirstNameIs(String fistName) {
    checkoutPage.inputFirstName(TXT_FIRSTNAME, fistName);
  }

  @When("I input last name is {string}")
  public void iInputLastNameIs(String lastName) {
    checkoutPage.inputLastName(TXT_LASTNAME, lastName);
  }

  @When("I input pose code is {string}")
  public void iInputPoseCodeIs(String postCode) {
    checkoutPage.inputPostCode(TXT_CODE, postCode);
  }

  @Then("I click on continue button")
  public void iClickOnContinueButton() {
    checkoutPage.clickOnContinueButton(BTN_CONTINUE);
  }

  @When("I click on finish button")
  public void iClickOnFinishButton() {
    checkoutPage.clickOnFinishButton(BTN_FINISH);
  }
}
