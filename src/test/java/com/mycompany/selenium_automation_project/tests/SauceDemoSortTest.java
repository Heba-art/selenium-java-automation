package com.mycompany.selenium_automation_project.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoSortTest extends BaseTest{
	
	 @Test
	    public void TC_SD_007_sortByPriceLowToHigh() {

		// Login
	        LoginPage login = new LoginPage(driver);
	        login.open(baseUrl);
	        login.login("standard_user", "secret_sauce");
		 
	        // Go to Products and sort
	        ProductsPage products = new ProductsPage(driver);
	        products.waitUntilLoaded();
	        products.sortByPriceLowToHigh();
	        
	        // Get prices and assert ascending
	        List<Double> prices= products.getDisplayedPrices();
	        Assert.assertTrue(prices.size() > 0, "Prices should be visible");
	        Assert.assertTrue(ProductsPage.isSortedAscending(prices), "Prices should be sorted ascending (low→high)");
	        //DEBUG
	        products.waitUntilLoaded();
	        System.out.println("DEBUG URL:   " + driver.getCurrentUrl());
	        System.out.println("DEBUG Title: " + driver.getTitle());
	        System.out.println("DEBUG has sort by class? " + !driver.findElements(By.cssSelector("select.product_sort_container")).isEmpty());//True
	        System.out.println("DEBUG has sort by data?  " + !driver.findElements(By.cssSelector("select[data-test='product_sort_container']")).isEmpty());//false

	       


	 }	 
		 
}
