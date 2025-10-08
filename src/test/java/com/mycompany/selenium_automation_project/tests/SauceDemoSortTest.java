package com.mycompany.selenium_automation_project.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SauceDemoSortTest extends BaseTest{
	
	@Epic("SauceDemo Automation")
	@Feature("Products")
	@Story("Sort products by price (Low → High)")
	@Severity(SeverityLevel.MINOR)
	@Owner("Heba Al-Rubaye")
	@Description("Verify that selecting 'Price (low to high)' from the sort dropdown correctly arranges products in ascending order by price.")
	@Test(priority = 7)
	
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
        System.out.println("DEBUG has sort by data?  " + !driver.findElements(By.cssSelector("select[data-test='product_sort_container']")).isEmpty());//False

	       


	 }	 
		 
}
