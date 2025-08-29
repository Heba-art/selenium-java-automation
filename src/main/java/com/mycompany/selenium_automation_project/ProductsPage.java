
package com.mycompany.selenium_automation_project;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By headerTitle = By.className("title");                 // "Products"
    private final By cartBadge   = By.className("shopping_cart_badge");
    private final By cartIcon    = By.id("shopping_cart_container");
    //TC-SD-007
    private final By inventoryList = By.className("inventory_list");
    private final By priceLabels = By.cssSelector(".inventory_item_price");
    private final By sortSelectByClass  = By.cssSelector("select.product_sort_container");
  //TC-SD-009
    private final By burgerMenuBtn   = By.id("react-burger-menu-btn");
    private final By logoutLink      = By.id("logout_sidebar_link");
    
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void waitUntilLoaded() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(headerTitle, "Products"));
        wait.until(ExpectedConditions.presenceOfElementLocated(inventoryList));
    }
    public String getCartBadgeText() {
    	List<WebElement> badges = driver.findElements(cartIcon);
    	return badges.isEmpty() ? null : badges.get(0).getText().trim();
    	
    }
    public CartPage openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        CartPage cart = new CartPage(driver,wait);
        cart.waitUntilLoaded();
        return cart;
    }
    public boolean isLoaded() {
        try {
            return driver.getCurrentUrl().contains("/inventory.html")
                && "Products".equals(driver.findElement(headerTitle).getText().trim());
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void waitForBadgeToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartBadge));
    }
    private String toSlug(String name) {
        return name.toLowerCase().replace(" ", "-");
    }

    public void addProductToCart(String productName) {
        String slug = toSlug(productName);
        By addBtn    = By.cssSelector("button[data-test='add-to-cart-" + slug + "']");
        By removeBtn = By.cssSelector("button[data-test='remove-"     + slug + "']");

        // If it is already added, do not try to add it again.
        if (!driver.findElements(removeBtn).isEmpty()) {
            return; // already in cart
        }
        // Otherwise add it
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        btn.click();
        // Make sure the button is turned to "Remove"
        wait.until(ExpectedConditions.presenceOfElementLocated(removeBtn));
    }
    
    public void sortByPriceLowToHigh() {
        WebElement selectEl = wait.until(ExpectedConditions.presenceOfElementLocated(sortSelectByClass));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", selectEl);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectEl));
            new Select(selectEl).selectByValue("lohi"); // low→high
        } catch (Exception e) {
            // Fallback / dispatchEvent
            ((JavascriptExecutor) driver).executeScript(
               "arguments[0].value='lohi'; arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                selectEl
            );
        }
        //Wait to see prices (DOM update)
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(priceLabels));
    }

   public List<Double> getDisplayedPrices() {
	   List<WebElement> els = driver.findElements(priceLabels);
	   List<Double> prices = new ArrayList<>(els.size());
	   for (WebElement el : els) {
		String txt= el.getText().trim();
		String num = txt.replaceAll("[^0-9.]", "");
		 if(!num.isEmpty()) {
			 prices.add(Double.parseDouble(num));
         }
     }
     return prices;
 }
   public static boolean isSortedAscending (List<Double> nums) {
	for(int i=1; i<nums.size(); i++) {
		if (nums.get(i) < nums.get(i-1)) return false;
	} return true;
  }
   public boolean isCartBadgeDisplayed() {
	 return !driver.findElements(cartBadge).isEmpty();
   }
   public void openMenu() {
	   wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn)).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));   
   }
   public LoginPage clickLogout() {
	   if (driver.findElements(logoutLink).isEmpty()) {
		   openMenu();
	   }
	   wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
	   LoginPage login = new LoginPage(driver);
	   login.waitUntilLoaded();
	   return login;
   }
   public ProductDetailsPage openProductByName(String name) {
	   By productLocator = By.xpath("//div[normalize-space()='" + name + "']");
	   wait.until(ExpectedConditions.elementToBeClickable(productLocator)).click();  
	   ProductDetailsPage details = new ProductDetailsPage(driver, wait);
	    details.waitUntilLoaded();
	    return details;
   }
}	
    

