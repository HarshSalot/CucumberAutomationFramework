package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.WaitUtils;

public class DashboardPage {

	public WebDriver driver;
	WaitUtils waitUtils;
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		waitUtils = new WaitUtils(driver);
	}
	
	By dashBoardHeadingText = By.xpath("//h6[text()='Dashboard']");
	
	By logOutBtn = By.xpath("//div[text()='Log Out']");
	
	By profileIcon = By.xpath("//h6[@id='pageTitle']/ancestor::div[1]/div[2]/button");
	
	By manageTabST =  By.xpath("//span[text()='Manage']/ancestor::div[2]");
	
	By selectProjectsTabST = By.xpath("//span[text()='Projects']/ancestor::a");
			

	public String getDashBoardHeadingText() {
		waitUtils.waitForElementVisible(dashBoardHeadingText);
		return driver.findElement(dashBoardHeadingText).getText();
	}
	
	public void clickProfileIcon() {
		driver.findElement(profileIcon).click();
	}
	
	public void clickLogOutButton() {
		driver.findElement(logOutBtn).click();
	}
	
	public void selectProjectFromMenu() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(selectProjectsTabST));
		//waitUtils.waitUntilClickable(driver.findElement(selectProjectsTabST), Constants.ELEMENT_CLICK_WAIT);	
	}
	
	
	
	
}
