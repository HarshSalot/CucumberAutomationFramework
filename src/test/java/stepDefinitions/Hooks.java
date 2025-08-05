package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utils.PropertyUtils;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	LoginPage loginPage;
	DashboardPage dashboardPage;
//	PropertyUtils config;

	public Hooks(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		this.dashboardPage = testContextSetup.pageObjectManager.getDashboardPage();
//		this.config = new PropertyUtils("src/test/resources/global.properties");
	}
	
/*	@Before
	public void login() {
		loginPage.declineCookies();
		String username = config.getProperty("username");
		String password = config.getProperty("password");
		loginPage.userNameText(username);
		loginPage.passwordText(password);
		loginPage.loginButton();
		Assert.assertEquals(dashboardPage.getDashBoardHeadingText(), "Dashboard");
	}
	*/

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.driver;
		if (driver != null) {
			// Take screenshot
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Attach to Cucumber
			byte[] screenshotBytes = FileUtils.readFileToByteArray(src);
			scenario.attach(screenshotBytes, "image/png", "Failed Step Screenshot");
		}
	}

	@After
	public void AfterScenario() throws IOException {

		testContextSetup.testBase.WebDriverManager().quit();

	}

}
