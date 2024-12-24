package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonSteps {
  private static final Logger log = LoggerFactory.getLogger(CommonSteps.class);
  WebElement element = null;

  public WebDriver webDriver;

  public CommonSteps(WebDriver driver) {
    this.webDriver = driver;
  }

  public void enterText(WebDriver driver, By locator, String text) {
    try{
      element = driver.findElement(locator);
      element.clear();
      element.sendKeys(text);
    } catch (Exception e) {
        log.info("unable to enter text to element: {}", e.getMessage());
    }
  }

  public void click(WebDriver driver, By locator) {
    try{
      element = driver.findElement(locator);
      element.click();
    }catch (Exception e){
      log.info("unable to click on element: {}", e.getMessage());
    }
  }

  public String getText(WebDriver driver, By locator) {
    try{
      element = driver.findElement(locator);
      return element.getText();
    }catch (Exception e){
      log.info("unable to get text of element: {}", e.getMessage());
      return "Error: Element not found or unable to retrieve text.";
    }
  }

  public void openUrl(String url) {
    webDriver.get(url);
  }
}
