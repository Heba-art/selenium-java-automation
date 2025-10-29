package com.mycompany.selenium_automation_project.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.CartPage;
import com.mycompany.selenium_automation_project.CheckoutPage;
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

public class SauceDemoCheckoutNegativeTest extends BaseTest {

	private void seedCartWithOneItem(String product) {
	LoginPage login = new LoginPage (driver);
	login.open(baseUrl);
	login.login("standard_user", "secret_sauce");
	
	ProductsPage products = new ProductsPage(driver);
	products.waitUntilLoaded();
	products.addProductToCart(product);
	Assert.assertEquals(products.getCartBadgeText(), "1", "Badge should be 1");
	
	CartPage cart= products.openCart();
	Assert.assertTrue(cart.isLoaded(),"Cart should load");
	Assert.assertTrue(cart.isProductInCart(product), "Item must exist before checkout");
    }
	
	@Epic("SauceDemo Automation")
	@Feature("Checkout")
	@Story("Negative checkout: missing required field")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Heba AL-Rubaye")
	@Description("Verify that leaving the 'First Name' field empty during checkout displays an appropriate validation error and prevents continuation.")
	@Test(priority = 6)
	
    public void TC_SD_006_Negative_missingFirstName_showsError() {
		final String product = "Sauce Labs Backpack";
		seedCartWithOneItem(product);
		
		// Go to Checkout
		CartPage cart = new CartPage (driver, wait);
		CheckoutPage checkout = cart.clickCheckout();
		checkout.waitUntilInfoLoaded();
		// Leave First Name empty; fill others
		checkout.fillInfo("", "QA", "3000");//Continue will be pressed inside fillInfo.
		// Verify error
		String err = checkout.getErrorMessage();
		Assert.assertNotNull(err, "Error message should appear");
        Assert.assertTrue(err.contains("First Name is required"), "Mismatch error: " + err);
    }
	
	@Epic("SauceDemo Automation")
	@Feature("Checkout")
	@Story("Negative checkout: missing Last Name field")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Heba AL-Rubaye")
	@Description("Verify that leaving the 'Last Name' field empty during checkout triggers the correct validation error message and prevents proceeding to the next step.")
	@Test(priority = 6)
	
    public void TC_SD_006_Negative_missingLastName_showsError() {
		final String product = "Sauce Labs Backpack";
        seedCartWithOneItem(product);
        
        CartPage cart = new CartPage(driver, wait);
        CheckoutPage checkout = cart.clickCheckout();
        checkout.waitUntilInfoLoaded();

        // First Name and Postal Input only
        checkout.clearInfoFields();
        // Fill in the fields manually and then continue (use clickContinueOnly)
        //FirstName
        driver.findElement(By.id("first-name")).sendKeys("Heba");
        // last-name empty***
        //postal-cod
        driver.findElement(By.id("postal-code")).sendKeys("3000");
        checkout.clickContinueOnly();
        String err = checkout.getErrorMessage();
        Assert.assertNotNull(err, "Error message should appear");
        Assert.assertTrue(err.contains("Last Name is required"), "Mismatch error: " + err);
    }

	@Epic("SauceDemo Automation")
	@Feature("Checkout")
	@Story("Negative checkout: missing Postal Code field")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Heba AL-Rubaye")
	@Description("Verify that leaving the 'Postal Code' field empty during checkout shows the correct validation error and prevents moving to the next step.")
	@Test(priority = 6)
	
    public void TC_SD_006_Negative_missingPostalCode_showsError() {
        final String product = "Sauce Labs Backpack";
        seedCartWithOneItem(product);

        CartPage cart = new CartPage(driver, wait);
        CheckoutPage checkout = cart.clickCheckout();
        checkout.waitUntilInfoLoaded();

     // Fill in First/Last name only
        checkout.clearInfoFields();
        driver.findElement(By.id("first-name")).sendKeys("Heba");
        driver.findElement(By.id("last-name")).sendKeys("QA");
        // postal-code empty
        checkout.clickContinueOnly();

        String err = checkout.getErrorMessage();
        Assert.assertNotNull(err, "Error message should appear");
        Assert.assertTrue(err.contains("Postal Code is required"), "Mismatch error: " + err);
    }	
			
	
}
