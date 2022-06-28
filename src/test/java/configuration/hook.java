package configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import support.BaseStep;
import support.DriverManagement;
import support.ScenarioContext;

public class hook {
    WebDriver driver;
    BaseStep baseStep = BaseStep.getInstance();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    private final static Logger logger = Logger.getLogger(hook.class);

    @Before
    public void beforeScenario() throws Exception {
        logger.info("---------before scenario---------");
        String browser = "chrome";
        String path = System.getProperty("user.dir");
        String driverPath = path + "/driver/";
        scenarioContext = new ScenarioContext();
        driver = new DriverManagement(browser, driverPath).setupDriver();
        baseStep.setDriver(driver);
    }

    @After
    public void afterScenario() {
        logger.info("---------after scenario---------");
        driver.quit();
    }
}
