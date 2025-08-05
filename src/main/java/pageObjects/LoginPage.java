package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	// Page Factory - OR:
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	public
	@FindBy(xpath = "//span[text()='Log In']/ancestor::button[@type='submit']") // (//span[text()='Log In'])[2]
	WebElement loginBtn;
	
	@FindBy(xpath = "//div/a[text()='Decline']")
	WebElement declineBtn;
	
	@FindBy (xpath = "//div/a[text()='Forget password?']")
	WebElement forgetPassword;
	
	@FindBy (xpath = "//input[@name='email']")
	WebElement enterEmail;
	
	@FindBy(xpath = "//span[text()='RESET PASSWORD']")
	WebElement resetPasswordBtn;
	
	@FindBy(xpath = "//h4[text()='Check Your Email!']")
	WebElement checkEmailResetLink;	
	
	@FindBy(xpath = "//span[text()='Sign Up']/ancestor::button")
	WebElement signUpTab;


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void userNameText(String enterUsername) {
		userName.sendKeys(enterUsername);
	}

	public void passwordText(String enterPassword) {
		password.sendKeys(enterPassword);
	}

	public void loginButton() {
		loginBtn.click();
	}
	
	public void declineCookies() {
		 declineBtn.click();
	}
	
	public void clickForgetPassword() {
		forgetPassword.click();
	}
	
	public void clickSignUpTab() {
		signUpTab.click();
	}
}