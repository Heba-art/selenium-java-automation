package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoLogoutProtectionTest extends BaseTest{
	
	@Test
    public void TC_SD_009_logoutAndAccessProtection() {
       // Arrange: Login
        LoginPage login = new LoginPage(driver);
        login.open(baseUrl);
        login.login("standard_user", "secret_sauce");
       // On Products page
        ProductsPage products = new ProductsPage(driver);
        products.waitUntilLoaded();
      // Act: Open menu → Logout
        products.openMenu();
        login = products.clickLogout();
        // Assert: now on Login page
        Assert.assertTrue(login.isLoaded(), "Should be redirected to Login page after logout");
     // Try to access inventory directly
        driver.get(baseUrl + "inventory.html");
     // Assert: access denied → redirected back to Login
        login.waitUntilLoaded();
        Assert.assertTrue(login.isLoaded(), "Access to inventory should be blocked after logout");
    }

}
