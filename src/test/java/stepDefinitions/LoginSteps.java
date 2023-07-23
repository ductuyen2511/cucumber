package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import support.BaseStep;

public class LoginSteps {
  LoginPage loginPage = BaseStep.getInstance().getLoginPage();

  @Given("I open the web base")
  public void iOpenTheWebBase() {
    loginPage.openUrl("https://www.saucedemo.com/");
  }

  @And("I input username is {string}")
  public void iInputUsernameIs(String userName) {
    loginPage.inputUserName(userName);
  }

  @And("I input password is {string}")
  public void iInputPasswordIs(String password) {
    loginPage.inputPassword(password);
  }

  @When("I click on the login button")
  public void iClickOnTheLoginButton() {
    loginPage.clickLoginButton();
  }
}
