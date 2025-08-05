package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.WaitUtils;

public class SignUpPage {
	
	public WebDriver driver;
	WaitUtils waitUtils;
	
	@FindBy(xpath = "//label[text()='Email: *']/ancestor::div[1]/div/input")
	WebElement emailSignUp;

	@FindBy(xpath = "//label[text()='First Name: *']/ancestor::div[1]/div/input")
	WebElement firstNameSignUp;

	@FindBy(xpath = "//label[text()='Last Name: *']/ancestor::div[1]/div/input")
	WebElement lastNameSignUp;

	@FindBy(xpath = "//label[text()='Password: *']/ancestor::div[1]/div/input")
	WebElement passwordSignUp;

	@FindBy(xpath = "//label[text()='Confirm Password: *']/ancestor::div[1]/div/input")
	WebElement confirmPasswordSignUp;

	@FindBy(xpath = "//label[text()='Company Name *']/ancestor::div[1]/div/input")
	WebElement companyNameSignUp;

	@FindBy(xpath = "//label[text()='Company Address *']/ancestor::div[1]/div/input")
	WebElement companyAddressSignUp;

	@FindBy(xpath = "//label[text()='Country *']/ancestor::div[1]/div/div/input")
	WebElement countrySignUp;

	@FindBy(xpath = "//label[text()='State/Province *']/ancestor::div[1]/div/div/input")
	WebElement provinceSignUp;

	@FindBy(xpath = "//label[text()='City *']/ancestor::div[1]/div/div/input")
	WebElement citySignUp;

	@FindBy(xpath = "//label[text()='Zip/Postal Code *']/ancestor::div[1]/div/input")
	WebElement postalCodeSignUp;

	@FindBy(xpath = "//label[text()='Organization Type *']/ancestor::div[1]/div/div")
	WebElement organizationTypeOptionSignUp;
	
	@FindBy(xpath ="//li[text()='Engineering Firm']")
	WebElement selectOrganizationEngineeringFirm;
	
	@FindBy(xpath ="//p[text()='Owner/Partner']")
	WebElement selectRoleOwner;
	
	@FindBy(xpath = "//span[text()='sign up']/ancestor::button")
	WebElement signUpButton;

	@FindBy(xpath = "//span[text()='Continue']/ancestor::button")
	WebElement continueSignUp;

	@FindBy(xpath = "//span[text()='Next']/ancestor::button")
	WebElement nextSignUp;

	@FindBy(xpath = "//a[text()='return to login page']/ancestor::div[1]/h2")
	WebElement thanksForSigningUpText;

	@FindBy(xpath = "//span[text()='Reset Password']/ancestor::button")
	WebElement resetPassword;

	@FindBy(xpath = "//h4[text()='Check Your Email!']/ancestor::div[2]/div[2]/p")
	WebElement resultResetPassword;
	
	@FindBy(xpath = "//span[text()='Canada']")
	WebElement countrySelectionCanada;

	@FindBy(xpath = "//span[text()='Ontario']")
	WebElement countrySelectionOntario;
	
	@FindBy(xpath = "//span[text()='Toronto']")
	WebElement countrySelectionToronto;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		waitUtils = new WaitUtils(driver);
	}
	
	public void enterEmailAddress(String email ) {
		waitUtils.waitAndSendKeys(emailSignUp, email,10);
	}
	
	public void enterFirstName(String firstName ) {
		firstNameSignUp.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName ) {
		lastNameSignUp.sendKeys(lastName);
	}
	
	public void enterPassword(String password) {
		passwordSignUp.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		waitUtils.waitAndSendKeys(confirmPasswordSignUp, confirmPassword, Constants.ELEMENT_SENDKEYS_WAIT);
	}

	public void clickContinue() {
		continueSignUp.click();
	}

	public void enterCompanyName(String companyName) {
		waitUtils.waitAndSendKeys(companyNameSignUp, companyName, Constants.ELEMENT_SENDKEYS_WAIT);
	}

	public void enterCompanyAddress(String companyAddress) {
		waitUtils.waitAndSendKeys(companyAddressSignUp, companyAddress, Constants.ELEMENT_SENDKEYS_WAIT);
	}

	public void enterCountryName(String countryName) {
		WaitUtils.staticWait(2);
		countrySignUp.sendKeys(countryName);
		waitUtils.waitAndClick(countrySelectionCanada,Constants.ELEMENT_CLICK_WAIT);
	}

	public void enterProvinceName(String provinceName) {
        provinceSignUp.sendKeys(provinceName);
        waitUtils.waitAndClick(countrySelectionOntario, Constants.ELEMENT_CLICK_WAIT);
	}

	public void enterCityName(String cityName) {
		WaitUtils.staticWait(2);
	     citySignUp.sendKeys(cityName);
	}

	public void enterPostalCode(String postalCode) {
	     postalCodeSignUp.sendKeys(postalCode);
	}

	public void selectOrganizationType() {
	  organizationTypeOptionSignUp.click();
	  waitUtils.waitAndClick(selectOrganizationEngineeringFirm, Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void clickNextBtn() {
		nextSignUp.click();
	}
	
	public void selectYourRole() {
		waitUtils.waitAndClick(selectRoleOwner, Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void clickSignupButton() {
		signUpButton.click();
	}
	
	public void verifySuccessfullSignUp() {
		waitUtils.waitForElementVisible(thanksForSigningUpText);
	}

}
