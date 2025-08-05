package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForgetPassword;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class ForgetPageStepDefination {

	TestContextSetup testContextSetup;
	ForgetPassword forgetPassword;
	
	public ForgetPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.forgetPassword = testContextSetup.pageObjectManager.getForgetPasswordPage();
	}
	
	@And("user enters emailaddress {string}")
	public void user_enters_email(String emailAddress) {
		forgetPassword.enterEmailAddress(emailAddress);
	}
	
	@And("click on rest password button")
	public void click_on_rest_password_button() {
		forgetPassword.clickResetPassword();
	}
	
	@Then("check your email page appears")
	public void check_your_email_page_appears() {
		forgetPassword.checkEmailResetMessage();
	}

}
