package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonSteps {
  WebElement element = null;

  public WebDriver webDriver;

  public CommonSteps(WebDriver driver) {
    this.webDriver = driver;
  }

  public void enterText(WebDriver driver, By locator, String text) {
    element = driver.findElement(locator);
    element.sendKeys(text);
  }

  public void click(WebDriver driver, By locator) {
    element = driver.findElement(locator);
    element.click();
  }

  public String getText(WebDriver driver, By locator) {
    element = driver.findElement(locator);
    return element.getText();
  }

  public void openUrl(String url) {
    webDriver.get(url);
  }
}
