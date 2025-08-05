package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait explicitWait;

        public WaitUtils(WebDriver driver) {
            this.driver = driver;
            this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

        // ============================
        // EXPLICIT WAITS - LOCATOR BASED
        // ============================

        public void waitForElementVisible(By locator) {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public void waitForElementClickable(By locator) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public void waitForPresence(By locator) {
            explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        public void waitForTextToBePresent(By locator, String text) {
            explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }

        public void waitForAttributeToBe(By locator, String attr, String value) {
            explicitWait.until(ExpectedConditions.attributeToBe(locator, attr, value));
        }

        public void waitForInvisibility(By locator) {
            explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
        
        // ✅ Explicit wait and sendKeys with timeout (By locator)
        public void waitAndSendKeys(By locator, String text, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        }
        
        // ✅ Explicit wait and click with timeout (By locator)
        public void waitAndClick(By locator, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }

        // ============================
        // EXPLICIT WAITS - WEBELEMENT BASED
        // ============================

        public void waitForElementVisible(WebElement element) {
            explicitWait.until(ExpectedConditions.visibilityOf(element));
        }

        public void waitForElementClickable(WebElement element) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        }

        public void waitForTextToBePresent(WebElement element, String text) {
            explicitWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }

        public void waitForAttributeToBe(WebElement element, String attr, String value) {
            explicitWait.until(ExpectedConditions.attributeToBe(element, attr, value));
        }

        public void waitForInvisibility(WebElement element) {
            explicitWait.until(ExpectedConditions.invisibilityOf(element));
        }
        
        // ✅ Explicit wait and sendKeys with timeout (WebElement)
        public void waitAndSendKeys(WebElement element, String text, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }

        // ✅ Explicit wait and click with timeout (WebElement)
        public void waitAndClick(WebElement element, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        
        public void waitUntilClickable(WebElement element, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        
        // ============================
        // FLUENT WAIT - LOCATOR
        // ============================

        public WebElement fluentWait(By locator, int timeoutSec, int pollingMillis) {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

            return fluentWait.until(driver -> {
                WebElement element = driver.findElement(locator);
                return (element.isDisplayed()) ? element : null;
            });
        }

        // ============================
        // FLUENT WAIT - WEBELEMENT
        // ============================

        public WebElement fluentWait(WebElement element, int timeoutSec, int pollingMillis) {
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

            return fluentWait.until(driver -> (element.isDisplayed()) ? element : null);
        }
        
        // ✅ Static Wait (Hardcoded)
        public static void staticWait(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset interrupted status
                e.printStackTrace();
            }
        }
    }
