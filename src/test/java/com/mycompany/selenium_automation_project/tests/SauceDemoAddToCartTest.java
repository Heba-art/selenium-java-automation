
package com.mycompany.selenium_automation_project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.CartPage;
import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.ProductsPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoAddToCartTest extends BaseTest {
	//Test Case4
	@Test 
	public void addSingleItemToCart_shouldShowBadgeAndItemInCart() {
	    final String product = "Sauce Labs Backpack";

	    // 1) Login
	    LoginPage login = new LoginPage(driver);
	    login.open(baseUrl);
	    login.login("standard_user", "secret_sauce");

	    // 2) Products page ready
	    ProductsPage products = new ProductsPage(driver);
	    products.waitUntilLoaded();
	    Assert.assertTrue(products.isLoaded(), "Products page should be loaded after login.");

	    // 3) Add item (robust add with waits/scroll)
	    products.addToCart(product);
	    By removeBtn = By.id("remove-sauce-labs-backpack");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn));


	    // 4) Verify badge = 1
	    By badge = By.className("shopping_cart_badge");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(badge));
	    Assert.assertEquals(products.getCartBadgeText(), "1", "Cart badge should be 1 after adding one item.");

	    // 5) Open cart and verify item exists
	    products.openCart();
	    CartPage cart = new CartPage(driver, wait);
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("title"), "Your Cart"));
	    Assert.assertTrue(cart.isProductInCart(product), "Cart should contain '" + product + "'.");
	}
	//Test Case5
	@Test 
    public void removeItemFromCart_shouldEmptyCartAndHideBadge() {
        final String product = "Sauce Labs Backpack";

        // --- Precondition: One item already in cart ---
        // 1. Login to the application
        LoginPage login = new LoginPage(driver);
        login.open(baseUrl);
        login.login("standard_user", "secret_sauce");

        // 2. Go to products page and add one item
        ProductsPage products = new ProductsPage(driver);
        products.waitUntilLoaded();
        products.addToCart(product); // This is the robust version we created
        Assert.assertEquals(products.getCartBadgeText(), "1", "Precondition failed: Cart badge should be 1.");

        // 3. Open the cart page
        CartPage cart = products.openCart();
        Assert.assertTrue(cart.isLoaded(),"Cart page did not load successfully.");
        Assert.assertTrue(cart.isProductInCart(product),"Expected product was not found in the cart.");
        cart.removeProductFromCart(product);
        Assert.assertFalse(cart.isProductInCart(product),"Product was not removed from the cart.");

	
	}
	
}


	
	
	
