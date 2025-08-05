package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/ContactPage.feature",glue="stepDefinitions", monochrome=true, tags="@SmokeTest ", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})
public class TestNGRunner2 extends AbstractTestNGCucumberTests{


}
