package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.CommonSteps;

public class LoginPage extends CommonSteps {
  private final By TXT_USERNAME = By.cssSelector("[id='user-name']");
  private final By TXT_PASSWORD = By.cssSelector("[id='password']");
  private final By BTN_LOGIN = By.cssSelector("[id='login-button']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void inputUserName(String userName) {
    enterText(webDriver, TXT_USERNAME, userName);
  }

  public void inputPassword(String password) {
    enterText(webDriver, TXT_PASSWORD, password);
  }

  public void clickLoginButton() {
    click(webDriver, BTN_LOGIN);
  }

  public void openWebPage(String url) {
    webDriver.get(url);
  }
}
