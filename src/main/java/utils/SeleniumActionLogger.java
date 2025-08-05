package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class SeleniumActionLogger implements WebDriverListener {

    public void beforeClick(WebElement element) {
        System.out.println("Clicking on: " + getElementInfo(element));
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigating to: " + url);
    }

    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Finding element by: " + locator.toString());
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Typing in: " + getElementInfo(element) + " | Keys: " + String.join("", keysToSend));
    }

    private String getElementInfo(WebElement element) {
        try {
            return element.toString();
        } catch (Exception e) {
            return "[unknown element]";
        }
    }
}
