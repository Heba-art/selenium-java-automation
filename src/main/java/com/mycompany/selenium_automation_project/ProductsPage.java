package com.mycompany.selenium_automation_project;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By headerTitle = By.className("title");                 // "Products"
    private final By cartBadge   = By.className("shopping_cart_badge");
    private final By cartIcon    = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitUntilLoaded() {
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(headerTitle, "Products"));
    }
    
    private By addButtonByProductName(String name) {
        String key = name.toLowerCase().replace(" ", "-");
        return By.cssSelector("button[data-test='add-to-cart-" + key + "']");
        // return By.id("add-to-cart-" + key);
    }

    public void addToCart(String productName) {
        waitUntilLoaded();
        By locator = addButtonByProductName(productName);
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // scroll إلى العنصر (لو تحت)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        // انتظر قابلية الضغط
        btn = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            // fallback: JS click لو حصل اعتراض
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }

    public String getCartBadgeText() {
        try {
            return driver.findElement(cartBadge).getText().trim();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public boolean isLoaded() {
        try {
            return driver.findElement(headerTitle).getText().trim().equalsIgnoreCase("Products");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
