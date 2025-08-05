package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/SpecPage.feature",glue="stepDefinitions", monochrome=true, tags="@SmokeTest ", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})
public class TestNGRunner3 extends AbstractTestNGCucumberTests{


}
