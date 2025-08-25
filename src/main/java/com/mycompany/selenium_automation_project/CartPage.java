package com.mycompany.selenium_automation_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private final WebDriver driver;
	private final By title= By.className("title"); // "Your Cart"
	
	public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoaded() {
    	return driver.findElement(title).getText().trim().equalsIgnoreCase("Your Cart");	
    }
    
    private By cartItemByName (String name) {
    	// each cart row contains .inventory_item_name with the product name
        return By.xpath("//div[@class='inventory_item_name' and normalize-space()='" + name + "']");	
    }
    
 public boolean hasItem(String name) {
	 return !driver.findElements(cartItemByName(name)).isEmpty();
 }
     
}
