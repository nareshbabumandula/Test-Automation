package runnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\featureFiles\\Github.feature",
				 plugin ={"pretty","html:target/cucumber-reports.html","rerun:target/failedrerun.txt"},
				 glue= {"stepDef", "resources"},
				 tags = "@delete")
public class TestRunner {

}
