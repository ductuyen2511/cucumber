package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.BaseStep;

public class HomePageSteps {
    BaseStep baseStep = BaseStep.getInstance();

    By LBL_HOMEPAGE = By.cssSelector("span.title");
    By IC_CART = By.cssSelector("[id=shopping_cart_container]");

    By BTN_CHECKOUT = By.cssSelector(".checkout_button");

    @Then("I am on the home page")
    public void iAmOnTheHomePage() {
        baseStep.getHomePage().verifyTitlePage(LBL_HOMEPAGE);
    }

    @When("I add {string} product to cart")
    public void iAddProductToCart(String productName) {
        String BTN_CARD = String.format("//*[text()='%s']/ancestor::*[@class='inventory_item_label']/following-sibling::*//button", productName);
        baseStep.getHomePage().addProductToCart(BTN_CARD);
    }

    @And("I click on cart icon")
    public void iClickOnCartIcon() {
        baseStep.getHomePage().clickOnCartIcon(IC_CART);
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        baseStep.getHomePage().clickOnCheckoutButton(BTN_CHECKOUT);
    }
}
