package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.CartPage;
import com.mycompany.selenium_automation_project.CheckoutPage;
import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoCheckoutTest extends BaseTest{

	@Test
    public void TC_SD_006_completeCheckoutFlow() {
		
	
		final String product= "Sauce Labs Backpack";
		 // Login
		LoginPage login = new LoginPage (driver);
		login.open(baseUrl);
		login.login("standard_user", "secret_sauce");

		 // Add 1 product
		ProductsPage products = new ProductsPage (driver);
		products.waitUntilLoaded();
		products.addProductToCart(product);
		Assert.assertEquals(products.getCartBadgeText(), "1", "Badge should be 1");
		
		 // Go to Cart & assert item exists
		CartPage cart = products.openCart();
		Assert.assertTrue(cart.isLoaded(), "Cart should load");
		Assert.assertTrue(cart.isProductInCart(product),"Item must exist before checkout");
		
		  // Checkout flow
		CheckoutPage checkout =cart.clickCheckout();
		checkout.fillInfo("Heba", "QA", "3000");
		checkout.waitUntilOverviewLoaded();
		checkout.finish();
		checkout.waitUntilCompleteLoaded();
		
		// Verify Complete page
		Assert.assertTrue(checkout.isComplete(), "Should be on 'Checkout: Complete!' page");
	}

}
