package configuration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/testcases",
        glue={"stepDefinitions","configuration"}
        ,plugin = {"json:target/cucumber.json",
                    "pretty",
                    "json:target/cucumber-report/cucumber.json",
                    "html:target/cucumber-report/cucumber.html"}
)

public class CucumberTestRunner {

}