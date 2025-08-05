package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.ProjectPage;
import utils.TestContextSetup;

public class DashboardPageStepDefination {

	TestContextSetup testContextSetup;
	DashboardPage dashboardPage;
	ProjectPage projectPage;

	public DashboardPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.dashboardPage = testContextSetup.pageObjectManager.getDashboardPage();
		this.projectPage = testContextSetup.pageObjectManager.getProjectPage();
	}

	@Then("user is on Dashboard")
	public void check_the_dahboard_title() {
		Assert.assertEquals(dashboardPage.getDashBoardHeadingText(), "Dashboard");
	}
	
	@And("click on the profile icon")
	public void click_on_the_profile_icon() {
	   dashboardPage.clickProfileIcon();
	}
	
	@When("Click Logout")
	public void click_logout() {
		dashboardPage.clickLogOutButton();
	}

	@When("user click on side bar Menu Projects")
	public void user_click_on_side_bar_menu_projects() {
		dashboardPage.selectProjectFromMenu();
	}
	
	@Then("user sees list of the Projects")
	public void use_sees_list_of_the_projects() {
		projectPage.verifyProjectList();
	}
}
