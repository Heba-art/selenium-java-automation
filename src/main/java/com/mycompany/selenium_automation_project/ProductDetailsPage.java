package com.mycompany.selenium_automation_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	private final WebDriver driver;
    private final WebDriverWait wait;
    
    private final By backBtn = By.id("back-to-products");
    private final By title   = By.className("inventory_details_name");

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void waitUntilLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }
    public String getProductTitle() {
        return driver.findElement(title).getText().trim();
    }
    public ProductsPage clickBackToProducts() {
    wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();	
    ProductsPage products = new ProductsPage(driver);
    products.waitUntilLoaded();
    return products;	
    }
}
