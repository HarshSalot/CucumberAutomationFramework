package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class PageObjectManager {

	public WebDriver driver;
	public LoginPage loginPage;
	public TestBase testBase;
	public DashboardPage dashboardPage;
	public ForgetPassword forgetPasswordPage;
	public SignUpPage signUpPage;
	public ProjectPage projectPage;

	public PageObjectManager(WebDriver driver) {
		testBase = new TestBase();
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public DashboardPage getDashboardPage() {
		dashboardPage = new DashboardPage(driver);
		return dashboardPage;
	}
	
	public ForgetPassword getForgetPasswordPage() {
		forgetPasswordPage = new ForgetPassword(driver);
		return forgetPasswordPage;
	}
	
	public SignUpPage getSignUpPage() {
		signUpPage = new SignUpPage(driver);
		return signUpPage;
	}
	
	public ProjectPage getProjectPage() {
		projectPage = new ProjectPage(driver);
		return projectPage;
	}
}
