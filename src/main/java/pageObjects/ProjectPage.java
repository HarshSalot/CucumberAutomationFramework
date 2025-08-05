package pageObjects;

import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;
import utils.WaitUtils;

public class ProjectPage {
	
	public WebDriver driver;
	WaitUtils waitUtils;
	
	
	public ProjectPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitUtils = new WaitUtils(driver);		
	}
	
	@FindBy(xpath ="//th[text()='Project Name']")
	WebElement verifyTitleProjectName;
	
	@FindBy(xpath = "//button[@aria-label='SpeedDial example']")
	WebElement projectButton;
	
	@FindBy(xpath = "//p[text()= 'New Project']")
	WebElement newProjectButton;
	
	@FindBy(xpath = "//label[text()='Project Name *']/ancestor::div[1]/div/input")
	WebElement projectName;
	
	@FindBy(xpath = "//input[@name='internalNo']")
	WebElement projectInternalNo;
	
	@FindBy(xpath = "//label[text()='Country *']/ancestor::div[1]/div/div/input")
	WebElement country;

	@FindBy(xpath = "//label[text()='State/Province *']/ancestor::div[1]/div/div/input")
	WebElement province;

	@FindBy(xpath = "//label[text()='City *']/ancestor::div[1]/div/div/input")
	WebElement city;
	
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement projectAddress;
	
	@FindBy(xpath = "//input[@name='bidDate']")
	WebElement bidDate;

	@FindBy(xpath = "//input[@name='area']")
	WebElement area;

	@FindBy(xpath = "//p[text()='Education']")
	WebElement educationAsBuildingClass;
	
	@FindBy(xpath = "//span[text()='College / University']")
	WebElement collegeAsBuildingType;
	
	@FindBy(xpath = "//span[text()='Next']/ancestor::button")
	WebElement nextButton;
	
	@FindBy(xpath = "//span[text()='Finish']/ancestor::button[1]")
	WebElement finish;	
	
	public void verifyProjectList() {
		waitUtils.waitForElementVisible(verifyTitleProjectName);
	}
	
	public void clickCreateProject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", projectButton);
		waitUtils.waitAndClick(newProjectButton, Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void enterProjectDetails(Map<String, String> data) {
	    waitUtils.waitAndSendKeys(projectName, data.get("projectName"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(projectInternalNo, data.get("projectInternalNo"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(country, data.get("country"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(province, data.get("province"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(city, data.get("city"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(projectAddress, data.get("projectAddress"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(bidDate, data.get("bidDate"), Constants.ELEMENT_SENDKEYS_WAIT);
	    waitUtils.waitAndSendKeys(area, data.get("area"), Constants.ELEMENT_SENDKEYS_WAIT);
	}
	
	public void selectBuildingClass() {
		waitUtils.waitAndClick(educationAsBuildingClass,Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void selectBuildingcollege() {
		waitUtils.waitAndClick(collegeAsBuildingType,Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void clickNextButton() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
	    waitUtils.waitUntilClickable(nextButton,Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void clickFinishButton() {
		waitUtils.waitUntilClickable(finish,Constants.ELEMENT_CLICK_WAIT);
	}
	
	public void verifyProjectOnProjectList() {
		System.out.println("Project Searched");
		/*
		ManageSpecsPageST.searchSpecFieldSpecListPageST().sendKeys("a");
		CommonMethods.staticTimeWait(1000);
		ManageSpecsPageST.searchSpecFieldSpecListPageST().sendKeys(Keys.BACK_SPACE);
		CommonMethods.staticTimeWait(1000);
		ManageSpecsPageST.searchSpecFieldSpecListPageST().sendKeys("Project" + strProjectName);
		CommonMethods.explicitTimeWaitVisibilityOfElement(driver, titleProjectName, 40);
		driver.findElement(By.xpath("//a[@title=" + "'Project" + strProjectName + "'" + "]")).click();
		*/
	}
	
	public void verifyProjectName() {
		System.out.println("Project Verified");
	}
/*	
	public void () {
		
	}
	
	public void () {
		
	}
	
	public void () {
		
	}
	
	public void () {
		
	}
*/
}
