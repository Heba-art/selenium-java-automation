
package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoLoginValidTest extends BaseTest {

    @Test
    public void loginWithValidCredentials_shouldNavigateToProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
        loginPage.login("standard_user", "secret_sauce");
        
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed, URL did not match.");

        System.out.println("Test Passed: Successfully navigated to the products page.");

    }
}
