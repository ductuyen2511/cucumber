package configuration;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import support.BaseStep;
import support.DriverManagement;
import support.ScenarioContext;
import utils.ScreenshotUtil;

@CucumberOptions
public class hook {
    WebDriver driver;
    BaseStep baseStep = BaseStep.getInstance();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private String scenarioName;

    private final static Logger logger = Logger.getLogger(hook.class);

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        logger.info("---------before scenario---------");
        String browser = "edge";
        scenarioContext = new ScenarioContext();
        scenarioName = scenario.getName();
        driver = new DriverManagement(browser).setupDriver();
        baseStep.setDriver(driver);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Capture the screenshot for every step
        if (scenario.getStatus().equals(Status.PASSED)) {
            ScreenshotUtil.captureScreenshot(driver, scenarioName, scenario.getStatus());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("---------after scenario---------");
        if (scenario.isFailed()) {
            // Capture screenshot if the scenario fails
            ScreenshotUtil.captureScreenshot(driver, scenarioName, scenario.getStatus());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
