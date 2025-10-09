package com.mycompany.selenium_automation_project.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Wait until element is visible
    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Safe click (with scroll and JS fallback)
    protected void safeClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // Click and wait until URL contains a specific text
    protected void clickAndWaitUrl(By locator, String partialUrl) {
        WebElement el = waitVisible(locator);
        safeClick(el);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.stalenessOf(el));
        } catch (Exception ignored) {}
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }
    protected void waitReplaced(WebElement oldElement, By newLocator) {
        try {
            wait.until(ExpectedConditions.stalenessOf(oldElement));
        } catch (Exception ignored) { }
        wait.until(ExpectedConditions.visibilityOfElementLocated(newLocator));
    }


}
