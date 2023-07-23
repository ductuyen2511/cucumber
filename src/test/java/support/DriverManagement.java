package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagement {
  private final String browser;
  private WebDriver driver = null;

  public DriverManagement(String browser, String path) {
    this.browser = browser;
  }

  public WebDriver setupDriver() throws Exception {
    switch (browser) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        //options.addArguments("window-size=1920,900");
        driver = new ChromeDriver(options);
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //todo
      default:
        throw new Exception(String.format("the browser type is not support: %s", browser));
    }
    return driver;
  }
}
