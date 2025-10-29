package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductDetailsPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SauceDemoProductDetailsTest extends BaseTest {

	@Epic("SauceDemo Automation")
	@Feature("Products")
	@Story("View product details and return to product list")
	@Severity(SeverityLevel.MINOR)
	@Owner("Heba Al-Rubaye")
	@Description("Verify that clicking a product name opens its details page, and using the 'Back to Products' button correctly returns to the main product list.")
	@Test(priority = 10)
	
    public void TC_SD_010_productDetailsAndBack() {
        final String product = "Sauce Labs Backpack";
          
	 // 1) Login
    LoginPage login = new LoginPage(driver);
    login.open(baseUrl);
    login.login("standard_user", "secret_sauce");  
    // 2) Open product details
    ProductsPage products = new ProductsPage(driver);
    products.waitUntilLoaded();
    ProductDetailsPage details = products.openProductByName(product);
    // 3) Verify details page loaded
    Assert.assertEquals(details.getProductTitle(), product, "Product details title should match");
    // 4) Back to products
    products = details.clickBackToProducts();
    Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "Should return to Products page");
}
    }
