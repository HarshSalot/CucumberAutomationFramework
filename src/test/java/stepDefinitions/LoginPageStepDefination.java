package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import utils.ExcelUtils;
import utils.PropertyUtils;
import utils.TestContextSetup;

public class LoginPageStepDefination {

	TestContextSetup testContextSetup;
	LoginPage loginPage;
	SignUpPage signUpPage;
	DashboardPage dashboardPage;
	PropertyUtils config;

	public LoginPageStepDefination(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		this.signUpPage = testContextSetup.pageObjectManager.getSignUpPage();
		this.dashboardPage = testContextSetup.pageObjectManager.getDashboardPage();
		this.config = new PropertyUtils("src/test/resources/global.properties");
	}

	@Given("User is on the Spectool Login Page")
	public void user_is_on_the_spectool_login_page() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.declineCookies();
	}

	@When("user enters username")
	public void user_enters_username() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.userNameText(config.getProperty("username"));
	}

	@And("user enters password")
	public void user_enters_password() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.passwordText(config.getProperty("password"));
	}

	@And("click on login button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.loginButton();
	}

	@When("user clicks forget password")
	public void user_clicks_forget_password() {
		loginPage.clickForgetPassword();
	}

	@Then("User logout")
	public void user_logout() {
		loginPage.loginBtn.isDisplayed();
	}

	@When("user clicks sign up tab")
	public void user_clicks_sign_up_tab() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.clickSignUpTab();
	}

	@When("user enters account details")
	public void user_enters_account_details(DataTable table) {
		Map<String, String> data = table.asMap();
		signUpPage.enterEmailAddress(data.get("Email"));
		signUpPage.enterFirstName(data.get("First Name"));
		signUpPage.enterLastName(data.get("Last Name"));
		signUpPage.enterPassword(data.get("Password"));
		signUpPage.enterConfirmPassword(data.get("Confirm Password"));
	}

	@And("click Continue button")
	public void click_continue_button() {
		signUpPage.clickContinue();
	}

	@And("user enters company details")
	public void user_enters_company_details(List<String> signUpDetails) {
		signUpPage.enterCompanyName(signUpDetails.get(0));
		signUpPage.enterCompanyAddress(signUpDetails.get(1));
		signUpPage.enterCountryName(signUpDetails.get(2));
		signUpPage.enterProvinceName(signUpDetails.get(3));
		signUpPage.enterCityName(signUpDetails.get(4));
		signUpPage.enterPostalCode(signUpDetails.get(5));
		signUpPage.selectOrganizationType();
	}

	@And("click Next button")
	public void click_next_button() {
		signUpPage.clickNextBtn();
	}

	@And("select your role {string}")
	public void select_your_role(String string) {
		signUpPage.selectYourRole();
	}

	@And("click Sign Up button")
	public void click_sign_up_button() {
		signUpPage.clickSignupButton();
	}

	@Then("check your email for account activation")
	public void check_your_email_for_account_activation() {
		signUpPage.verifySuccessfullSignUp();
	}

	@When("User logs in with data from excel {string}")
	public void login_with_excel_data(String excelsheet) throws IOException {
	    String path = "src/test/resources/testdata/"+excelsheet;
	    List<Map<String, String>> data = ExcelUtils.readExcelData(path, "LoginData");
	    String URL = testContextSetup.driver.getCurrentUrl();
	    System.out.println(URL);
	    for (int i = 0; i < data.size(); i++) {
	        Map<String, String> row = data.get(i);
	        String username = row.get("Username");
	        String password = row.get("Password");
	        String expected = "ExpectedResult";
	        String result = "FAIL"; // default to fails	     

	        // Skip blank or empty rows
	        if (username == null || username.trim().isEmpty()) {
	            continue;
	        }

	        try {
	            loginPage.userNameText(username);
	            loginPage.passwordText(password);
	            loginPage.loginButton();
	            String dashboardText = dashboardPage.getDashBoardHeadingText();
	            boolean isSuccess = dashboardText.equalsIgnoreCase("Dashboard");
	            result = isSuccess ? "PASS" : "FAIL";

	            // Logout if login was successful
	            if (isSuccess) {
	                dashboardPage.clickProfileIcon();
	                dashboardPage.clickLogOutButton();
	            }
	        } catch (Exception e) {
	            result = "FAIL"; // retain FAIL
	            System.out.println("Login failed for row " + (i + 1) + ": " + e.getMessage());
	        }

	        ExcelUtils.writeResult(path, "LoginData", i + 1, expected, result);
	        testContextSetup.driver.get(URL);
	    }
	}
}
