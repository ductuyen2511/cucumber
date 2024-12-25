package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtil;
import utils.Credential;

public class LoginPage extends DriverUtil {
  private final By TXT_USERNAME = By.cssSelector("[id='user-name']");
  private final By TXT_PASSWORD = By.cssSelector("[id='password']");
  private final By BTN_LOGIN = By.cssSelector("[id='login-button']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void clickLoginButton() {
    click(webDriver, BTN_LOGIN);
  }

  public void inputCredential(Credential credential) {
    enterText(webDriver, TXT_USERNAME, credential.getUsername());
    enterText(webDriver, TXT_PASSWORD, credential.getPassword());
  }
}
