package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Appfeatures"},
        glue = {"stepdefinitions","AppHooks"},
        plugin = {"pretty",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                   "timeline:test-output-thread/",
                   "rerun:target/failedrerun.txt"
                  }
                )

public class MyTestRunner {
}




























