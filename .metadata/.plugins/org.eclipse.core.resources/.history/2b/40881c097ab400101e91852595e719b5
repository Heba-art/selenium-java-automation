package com.mycompany.selenium_automation_project.tests;

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

public class SauceDemoLogoutProtectionTest extends BaseTest{
	
	@Epic("SauceDemo Automation")
	@Feature("Security")
	@Story("Logout and access protection")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Heba Al-Rubaye")
	@Description("Verify that after logout, the user cannot access protected pages like inventory and is redirected back to the login page.")
	@Test(priority = 9)
	
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
