package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"
        },  //to add an HTML report
        features = "src/test/resources/features",
        glue = "com/zerobank/step_definitions",
        dryRun = true,
        tags = "@wip"
)
public class CukesRunner {
}
