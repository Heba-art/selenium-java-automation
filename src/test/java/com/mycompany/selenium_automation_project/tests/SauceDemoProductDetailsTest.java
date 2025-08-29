package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductDetailsPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoProductDetailsTest extends BaseTest {

    @Test
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
