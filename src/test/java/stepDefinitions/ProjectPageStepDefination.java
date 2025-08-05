package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.ProjectPage;
import utils.TestContextSetup;

public class ProjectPageStepDefination {

	TestContextSetup testContextSetup;
	DashboardPage dashboardPage;
	ProjectPage projectPage;

	public ProjectPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.dashboardPage = testContextSetup.pageObjectManager.getDashboardPage();
		this.projectPage = testContextSetup.pageObjectManager.getProjectPage();
	}

	@Given("User navigates to the {string} page")
	public void user_navigates_to_the_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the Projects page")
	public void user_is_on_the_projects_page() {
		// Write code here that turns the phrase above into concrete actions
            
	}

	@When("User clicks on Create New Project")
	public void user_clicks_on_create_new_project() {
		projectPage.clickCreateProject();
	}

	@When("User enters Project details from {string}")
	public void user_enters_project_details_from(String fileName) throws IOException{
	    String filePath = "src/test/resources/testdata/" + fileName;
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, String> projectData = mapper.readValue(new File(filePath), new TypeReference<Map<String, String>>(){});
	        projectPage.enterProjectDetails(projectData);
	}

	@When("select building class Education")
	public void select_building_class_education() {
		projectPage.selectBuildingClass();
	}

	@When("select building type college")
	public void select_building_type_college() {
		projectPage.selectBuildingcollege();
	}
	
	@And("click Next button on project page")
	public void click_next_button_on_project_page() {
		projectPage.clickNextButton();
	}

	@When("click finish button")
	public void click_finish_button() {
		projectPage.clickFinishButton();
	}

	@Then("A new project is created and visible on the project list")
	public void a_new_project_is_created_and_visible_on_the_project_list() {
		dashboardPage.selectProjectFromMenu();
		projectPage.verifyProjectOnProjectList();
	}

	@Then("The displayed project name should be {string}")
	public void the_displayed_project_name_should_be(String string) {
		projectPage.verifyProjectName();
	}

	/*
	@When("User search the project {string}")
	public void user_search_the_project(String string) {
		projectPage.
	}

	@When("User clicks on Actions")
	public void user_clicks_on_actions() {
		projectPage.
	}

	@When("User clicks on Delete options")
	public void user_clicks_on_delete_options() {
		projectPage.
	}

	@When("User confirms the deletion")
	public void user_confirms_the_deletion() {
		projectPage.
	}

	@Then("The project {string} should no longer be visible in the project list")
	public void the_project_should_no_longer_be_visible_in_the_project_list(String string) {
		projectPage.
	}
	*/

}
