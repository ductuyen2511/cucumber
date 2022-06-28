package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import support.BaseStep;

public class LoginSteps {
    BaseStep baseStep = BaseStep.getInstance();

    @Given("I open the web base")
    public void iOpenTheWebBase() {
        baseStep.getLoginPage().openUrl("https://www.saucedemo.com/");
    }

    @And("I input username is {string}")
    public void iInputUsernameIs(String userName) {
        baseStep.getLoginPage().inputUserName(userName);
    }

    @And("I input password is {string}")
    public void iInputPasswordIs(String password) {
        baseStep.getLoginPage().inputPassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        baseStep.getLoginPage().clickLoginButton();
    }
}
