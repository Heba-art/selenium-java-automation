
package com.mycompany.selenium_automation_project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.base.BaseTest;

public class SauceDemoLoginLockedOutTest extends BaseTest {
	//Test Case3
	@Test
    public void loginWithLockedOutUser_shouldShowLockedOutError() {
	LoginPage loginPage = new LoginPage(driver);

    loginPage.open(baseUrl);
    loginPage.login("locked_out_user", "secret_sauce");
    
    By errorBanner = By.cssSelector("h3[data-test='error']");
    wait.until(ExpectedConditions.visibilityOfElementLocated(errorBanner));
    
    
	 // 4) Assert error text
    String actualError = loginPage.getErrorMesssage();
    String expectedError = "Epic sadface: Sorry, this user has been locked out.";
    Assert.assertEquals(actualError, expectedError, "Error message mismatch!");


	// 5) Assert still on login page (URL did not change to inventory)
	String currentUrl = driver.getCurrentUrl();
    Assert.assertFalse(currentUrl.contains("/inventory.html"),"User should NOT navigate to Products page. Current URL: " + currentUrl);
	
	}	

}
