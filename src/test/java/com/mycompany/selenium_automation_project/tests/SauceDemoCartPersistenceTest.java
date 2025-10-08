package com.mycompany.selenium_automation_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.CartPage;
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

public class SauceDemoCartPersistenceTest extends BaseTest {
	

	@Epic("SauceDemo Automation")
	@Feature("Cart")
	@Story("Cart state persists after navigation")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Heba AL-Rubaye")
	@Description("Verify that items added to the cart remain after navigating away and returning to the Products page.")
	@Test(priority = 8)
	
    public void TC_SD_008_cartStatePersistsAfterNavigation() {
		final String product = "Sauce Labs Backpack";
		 // 1) Login
		LoginPage login= new LoginPage(driver);
		login.open(baseUrl);
		login.login("standard_user", "secret_sauce");
		 // 2) Add item on Products page
		ProductsPage products = new ProductsPage(driver);
		products.waitUntilLoaded();
		products.addProductToCart(product);
		// Verify badge = 1
		Assert.assertEquals(products.getCartBadgeText(),"1", "Badge should be 1 after adding item");
		// 3) Open cart
		CartPage cart= products.openCart();
		Assert.assertTrue(cart.isLoaded(), "Cart page should load" );
		Assert.assertTrue(cart.isProductInCart(product),"Item must exist in cart");
		// 4) Click Continue Shopping -> back to Products
		products= cart.clickContinueShopping();
		Assert.assertTrue(products.isCartBadgeDisplayed(),"Badge should still be visible after navigating back");
		Assert.assertEquals(products.getCartBadgeText(), "1", "Badge should remain 1 after continue shopping");
		//(Optional) Open the cart again and make sure the item is still there.
		cart = products.openCart();
        Assert.assertTrue(cart.isProductInCart(product), "Item should still be in cart after navigation");
	}

}
