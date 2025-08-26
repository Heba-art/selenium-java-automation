
package com.mycompany.selenium_automation_project;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private final WebDriver driver;
	private final By title= By.className("title"); // "Your Cart"
	private WebDriverWait wait;
	
	
	public CartPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
	
	public void waitUntilLoaded() {
        wait.until(ExpectedConditions.urlContains("/cart.html"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(title, "Your Cart"));
    }
    public boolean isLoaded() {
    	return driver.findElement(title).getText().trim().equalsIgnoreCase("Your Cart");	
    }
    
 // The cart description that contains the desired product name
    private By cartItemRowByName(String name) {
        return By.xpath("//div[@class='cart_item' and .//div[@class='inventory_item_name' and normalize-space()='" + name + "']]");
    }
	// public boolean hasItem(String name) {
	//	 return isProductInCart(name);
	// }
    public boolean isProductInCart(String name) {
        return !driver.findElements(cartItemRowByName(name)).isEmpty();
    }
 
    public void removeProductFromCart(String productName) {
        By rowLocator = cartItemRowByName(productName);

        // 1) Pick up the class before removal.
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));

        // 2) Remove button within the same row
        WebElement removeBtn;
        try {
            removeBtn = row.findElement(By.cssSelector("button.cart_button"));
        } catch (NoSuchElementException e) {
            removeBtn = row.findElement(By.xpath(".//button[contains(@id,'remove') or contains(@data-test,'remove') or normalize-space()='Remove']"));
        }

        // 3) اClick (with JS fallback if an object occurs)
        try {
            wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
        } catch (ElementClickInterceptedException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
        }

        // 4) Wait for one of the following conditions to occur:
     // - The element has become stale
     // - The element has disappeared (invisible)
     // - The number of rows that match the catches has become 0 (or less than before)
        int before = driver.findElements(rowLocator).size();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.stalenessOf(row),
                ExpectedConditions.invisibilityOfElementLocated(rowLocator),
                ExpectedConditions.numberOfElementsToBe(rowLocator, Math.max(0, before - 1))
        ));
      }

}

 

