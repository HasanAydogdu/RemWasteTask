package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                 "html:target/default-html-reports/index.html",
//                 "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/saucedemo/step_definitions",
//      dryRun = true,
        dryRun = false,
        tags = "@buy"
)
public class CukesRunner {
}