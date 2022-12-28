package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.BaseStep;

public class CheckoutSteps {

    BaseStep baseStep = BaseStep.getInstance();

    By LBL_CHECKOUT_PAGE = By.cssSelector("span.title");
    By TXT_FIRSTNAME = By.cssSelector("[id='first-name']");
    By TXT_LASTNAME = By.cssSelector("[id='last-name']");
    By TXT_CODE = By.cssSelector("[id='postal-code']");
    By BTN_CONTINUE = By.cssSelector("input.submit-button");
    By BTN_FINISH = By.cssSelector("button.cart_button");
    @Then("I am on the check out page")
    public void iAmOnTheCheckOutPage() {
        baseStep.getCheckoutPage().verifyTitlePage(LBL_CHECKOUT_PAGE);
    }

    @When("I input first name is {string}")
    public void iInputFirstNameIs(String fistName) {
        baseStep.getCheckoutPage().inputFirstName(TXT_FIRSTNAME, fistName);
    }

    @When("I input last name is {string}")
    public void iInputLastNameIs(String lastName) {
        baseStep.getCheckoutPage().inputLastName(TXT_LASTNAME, lastName);
    }

    @When("I input pose code is {string}")
    public void iInputPoseCodeIs(String postCode) {
        baseStep.getCheckoutPage().inputPostCode(TXT_CODE, postCode);
    }

    @Then("I click on continue button")
    public void iClickOnContinueButton() {
        baseStep.getCheckoutPage().clickOnContinueButton(BTN_CONTINUE);
    }

    @When("I click on finish button")
    public void iClickOnFinishButton() {
        baseStep.getCheckoutPage().clickOnFinishButton(BTN_FINISH);
    }
}
