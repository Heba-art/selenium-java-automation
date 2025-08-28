package com.mycompany.selenium_automation_project.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.selenium_automation_project.LoginPage;
import com.mycompany.selenium_automation_project.base.BaseTest;


public class SauceDemoLoginInvalidTest extends BaseTest {
	
	@Test
	public void TC_SD_002_loginWithInvalidPassword_shouldShowErrorAndStayOnLogin() {
		
		
		  LoginPage loginPage = new LoginPage(driver);
		  
		// 1) Open login
		  loginPage.open(baseUrl);
		  
		// 2) Attempt with wrong password
		  loginPage.login("standard_user", "wrong_pass");
		  
		// 3) Wait for error banner to appear
		  By errorBanner = By.cssSelector("h3[data-test='error']");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(errorBanner));
		  
		 // 4) Assert error text
		String actualError = loginPage.getErrorMesssage();
		String expectedError = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actualError, expectedError, "Error message mismatch!");

		
		// 5) Assert still on login page (URL did not change to inventory)
		Assert.assertEquals(driver.getCurrentUrl(),baseUrl,"Should remain on login page after invalid login.");
		
	}

}