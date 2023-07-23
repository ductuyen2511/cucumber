package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.HomePage;
import support.BaseStep;

public class HomePageSteps {
  HomePage homePage = BaseStep.getInstance().getHomePage();
  private final By LBL_HOMEPAGE = By.cssSelector("span.title");
  private final By IC_CART = By.cssSelector("[id=shopping_cart_container]");
  private final By BTN_CHECKOUT = By.cssSelector(".checkout_button");

  @Then("I am on the home page")
  public void iAmOnTheHomePage() {
    homePage.verifyTitlePage(LBL_HOMEPAGE);
  }

  @When("I add {string} product to cart")
  public void iAddProductToCart(String productName) {
    String BTN_CARD = String.format("//*[text()='%s']/ancestor::*[@class='inventory_item_label']/following-sibling::*//button", productName);
    homePage.addProductToCart(BTN_CARD);
  }

  @And("I click on cart icon")
  public void iClickOnCartIcon() {
    homePage.clickOnCartIcon(IC_CART);
  }

  @And("I click on checkout button")
  public void iClickOnCheckoutButton() {
    homePage.clickOnCheckoutButton(BTN_CHECKOUT);
  }
}
