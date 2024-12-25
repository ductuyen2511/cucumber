package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverUtil {
    private static final Logger log = LoggerFactory.getLogger(DriverUtil.class);
    WebElement element = null;

    public WebDriver webDriver;


    public DriverUtil(WebDriver driver) {
        this.webDriver = driver;
    }

    public WebElement waitForElementToBeVisibleLocatedBy(WebDriver driver, By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            String message = String.format("Element is not visible as expected. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public Boolean waitForElementToBeInvisibleLocatedBy(WebDriver driver, By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            String message = String.format("Element is not invisible as expected. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public List<WebElement> waitForAllElementsToBeVisibleLocatedBy(WebDriver driver, By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            String message = String.format("Elements are not visible as expected. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public Boolean waitForTextToBePresentInElementLocatedBy(WebDriver driver, By locator, String text) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (Exception e) {
            String message = String.format("Text are not present in element as expected. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public WebElement waitForElementToBePresent(WebDriver driver, By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            String message = String.format("element is not present as expected. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, By locator) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            String message = String.format("Element is not clickable. Element: %s", locator);
            throw new Exception(message, e);
        }
    }

    public void waitForAlertPresent(WebDriver driver) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            throw new Exception("alert is not present!", e);
        }
    }

    public void enterText(WebDriver driver, By locator, String text) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            String message = String.format("Error occur while entering text to element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void enterSpecialKey(WebDriver driver, By locator, String specialKey) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            element.clear();
            switch (specialKey.toLowerCase()) {
                case "enter":
                    element.sendKeys(Keys.ENTER);
                    break;
                case "tab":
                    element.sendKeys(Keys.TAB);
                    break;
                default:
                    throw new Exception(String.format("no support key: %s", specialKey));
            }
        } catch (Exception e) {
            String message = String.format("Error occur while sending special Key. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void click(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            element.click();
        } catch (Exception e) {
            String message = String.format("Error occur while clicking on element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public String getText(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);
            return element.getText();
        } catch (Exception e) {
            String message = String.format("Error occur while getting text of element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void selectValueFromDropdown(WebDriver driver, By locator, String value) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            String message = String.format("Error occur while select value from dropdown. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void selectValueFromLongDropdown(WebDriver driver, By locator, String expectedText) {
        try {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            List<WebElement> elements;
            elements = waitForAllElementsToBeVisibleLocatedBy(driver, locator);

            for(WebElement element: elements){
                if(element.getText().equals(expectedText)){
                    element.click();
                }else{
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                    javascriptExecutor.executeScript("arguments[0].click();", element);
                }
            }
        } catch (Exception e) {
            String message = String.format("Error occur while click on value of element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void switchToIframe(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            driver.switchTo().frame(element);
        } catch (Exception e) {
            String message = String.format("Error occur while switch to iframe. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public String getAttribute(WebDriver driver, By locator, String attribute) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            return element.getAttribute(attribute);
        } catch (Exception e) {
            String message = String.format("Error occur while getting attribute of element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void removeAttribute(WebDriver driver, By locator, String attribute) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
        } catch (Exception e) {
            String message = String.format("Error occur while remove attribute of element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void hoverMouseOnAndClick(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            hoverMouseOn(driver, locator);

            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            String message = String.format("Error occur while hover mouse and click on element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public void hoverMouseOn(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            Actions action = new Actions(driver);
            action.moveToElement(element);
        } catch (Exception e) {
            String message = String.format("Error occur while hover mouse on element. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public boolean isSelected(WebDriver driver, By locator) {
        try {
            element = waitForElementToBeVisibleLocatedBy(driver, locator);

            return element.isSelected();
        } catch (Exception e) {
            String message = String.format("Error occur while get element selected. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public List<String> getTextElements(WebDriver driver, By locator) {
        try {
            List<WebElement> elements;
            elements = waitForAllElementsToBeVisibleLocatedBy(driver, locator);

            return elements.stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception e) {
            String message = String.format("Error occur while getting text of elements. Element: %s", locator);
            throw new RuntimeException(message, e);
        }
    }

    public String getTextAlert(WebDriver driver) throws Exception {
        waitForAlertPresent(driver);
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(WebDriver driver) throws Exception {
        waitForAlertPresent(driver);
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) throws Exception {
        waitForAlertPresent(driver);
        driver.switchTo().alert().dismiss();
    }

    public void switchToNewWindow(WebDriver driver)
    {
        try
        {
            String currentWindowHandle = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for(String windowHandle : windowHandles)
            {
                if (!Objects.equals(windowHandle, currentWindowHandle))
                {
                    driver.close();
                    driver.switchTo().window(windowHandle);
                }
            }
        }
        catch (Exception e)
        {
            String message = "An error happens when trying to switch to new window";
            throw new RuntimeException(message, e);
        }
    }

    public void openUrl(String url) {
        webDriver.get(url);
    }
}
