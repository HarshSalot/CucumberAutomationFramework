package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgetPassword {
	
	public WebDriver driver;
	
	
	@FindBy (xpath = "//input[@name='email']")
	WebElement enterEmail;
	
	@FindBy(xpath = "//span[text()='RESET PASSWORD']")
	WebElement resetPasswordBtn;
	
	@FindBy(xpath = "//h4[text()='Check Your Email!']")
	WebElement checkEmailResetLink;	
	
	public ForgetPassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterEmailAddress(String emailAddress) {
		enterEmail.sendKeys(emailAddress);
	}
	
	public void clickResetPassword () {
		resetPasswordBtn.click();
	}
	
	public void checkEmailResetMessage () {
		checkEmailResetLink.isDisplayed();
	}


}
