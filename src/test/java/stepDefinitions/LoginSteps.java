package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.minidev.json.parser.ParseException;
import org.eclipse.jetty.server.Authentication;
import pages.LoginPage;
import support.BaseStep;
import utils.Credential;
import utils.User;
import utils.UserHelpers;

import java.io.FileNotFoundException;

public class LoginSteps {
  LoginPage loginPage = BaseStep.getInstance().getLoginPage();

  @Given("I open the web base")
  public void iOpenTheWebBase() {
    loginPage.openUrl("https://www.saucedemo.com/");
  }

  @When("I click on the login button")
  public void iClickOnTheLoginButton() {
    loginPage.clickLoginButton();
  }

  @Given("I input credential with username is {string}")
  public void iInputCredentialWithUsernameIs(String userName) throws Exception {
    User user = UserHelpers.inputUser(userName);
    loginPage.inputCredential(new Credential(user.username, user.password));
  }
}
